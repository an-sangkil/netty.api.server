package com.mezzomedia.server.handler.channel;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mezzomedia.server.config.LogMaker;
import com.mezzomedia.server.handler.dispatcher.DispatcherServlet;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.CharsetUtil;

/**
 * <pre>
 * 	 HTTP Channel Handler 설정 및 처리 
 * 		모든 Request 및 Response 의 처리를  해당 채널에서 구현 한다. 
 * 
 *  	TODO : 1. Auth 처리 
 *             2. Parameter 처리 . 
 *             3. URL Mapping 
 *  
 *    
 * </pre>
 *
 * @author skan
 * @since 2018. 2. 27.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class MezzoHttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

	private Logger logger  = LoggerFactory.getLogger(MezzoHttpHandler.class);
	
	HttpRequest httpRequest ;
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

		if(msg instanceof HttpRequest) {
			this.httpRequest = msg;
			
			if (HttpUtil.is100ContinueExpected(httpRequest)) {
                send100Continue(ctx);
            }
		}
		
		// TODO URL PATH 분기 처리
        String urlPath = "";
		DispatcherServlet.dispatch(urlPath);
		
		
		if (msg instanceof HttpContent) {
            if (msg instanceof LastHttpContent) {
                logger.debug(LogMaker.accessMaker ,"LastHttpContent message received!! {}", httpRequest.uri());

                LastHttpContent trailer = (LastHttpContent) msg;


                if (!writeResponse(trailer, ctx)) {
                    // If keep-alive is off, close the connection once the
                    // content is fully written.
                    ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
                }
                reset();
            }
        }
		
		
		this.reset();
	}
	
	@Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        logger.info("요청 처리 완료");
        ctx.flush();
    }
	
	private void reset() {
		this.httpRequest = null;
    }
	
	
	private boolean writeResponse(HttpObject currentObj, ChannelHandlerContext ctx) {
        
		// Decide whether to close the connection or not.
        boolean keepAlive = HttpUtil.isKeepAlive(httpRequest);

        // Build the response object.
        FullHttpResponse response = new DefaultFullHttpResponse(
        		HTTP_1_1,
                currentObj.decoderResult().isSuccess() ? OK : BAD_REQUEST,
                Unpooled.copiedBuffer( "test", CharsetUtil.UTF_8));
        
        //HttpHeaderNames.CONTENT_LENGTH;
        response.headers().set(CONTENT_TYPE, "application/json; charset=UTF-8");

        if (keepAlive) {
            // Add 'Content-Length' header only for a keep-alive connection.
            response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
            // Add keep alive header as per:
            // -
            // http://www.w3.org/Protocols/HTTP/1.1/draft-ietf-http-v11-spec-01.html#Connection
            response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        }

        // Write the response.
        ctx.write(response);
        
        logger.debug(LogMaker.responseMaker ,"ResponseData = {}", response.content());

        return keepAlive;
    }
	
	private static void send100Continue(ChannelHandlerContext ctx) {
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, CONTINUE);
        ctx.write(response);
    }


}
