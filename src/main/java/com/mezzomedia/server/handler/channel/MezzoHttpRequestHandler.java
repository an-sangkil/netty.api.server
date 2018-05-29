package com.mezzomedia.server.handler.channel;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mezzomedia.server.config.LogMaker;
import com.mezzomedia.server.web.servlet.filter.intercepter.IntercepterFilter;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
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
public class MezzoHttpRequestHandler extends AbstractRequestParameterParser {

	private Logger logger  = LoggerFactory.getLogger(MezzoHttpRequestHandler.class);
	private HttpRequest httpRequest;
	private HttpResponse httpResponse;
    private Map<String, Object> requestData = new HashMap<>();
    private static    Set<String> usingHeader = new HashSet<>();
    static  {
        usingHeader.add("TOKEN_");
    }

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {

	    ///////////////////////////////////////////////////////////////////////////////
	    // header 처리
        ///////////////////////////////////////////////////////////////////////////////
		if(msg instanceof HttpRequest) {
			this.httpRequest = msg;
			if (HttpUtil.is100ContinueExpected(httpRequest)) {
                send100Continue(ctx);
            }

            HttpHeaders headers = httpRequest.headers();
            if (!headers.isEmpty()) {
                for (Map.Entry<String, String> h : headers) {
                    String key = h.getKey();
                    if (usingHeader.contains(key)) {
                        requestData.put(key, h.getValue());
                    }
                }
            }
        }

        ///////////////////////////////////////////////////////////////////////////////
        // GET POST data parameter parser
        ///////////////////////////////////////////////////////////////////////////////
        this.readGetData(httpRequest,requestData);
        if(httpRequest.method().equals(HttpMethod.POST)) {
            this.readPostData(httpRequest, requestData);
        }


        ///////////////////////////////////////////////////////////////////////////////
        // HttpContent ( Body ) 처리
        ///////////////////////////////////////////////////////////////////////////////
        LastHttpContent lastHttpContent = null;
		if (msg instanceof HttpContent) {
            if (msg instanceof LastHttpContent) {
                lastHttpContent = (LastHttpContent) msg;        
            }
        }


        ////////////////////////////////////////////////////
        // Request Mapping 처리 .. Business logic 처리
        ////////////////////////////////////////////////////
        try {
            // 인터 셉터 실행
            new IntercepterFilter(httpRequest, null);

		} finally {

            requestData.clear();
        }

        ////////////////////////////////////////////////////
        // Response 처리
        ////////////////////////////////////////////////////
        if (!writeResponse(lastHttpContent, ctx)) {
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }

        //
        this.reset();


	}
	
	@Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        logger.info("데이터 수신 완료 ");
        ctx.flush();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
    	
        ctx.fireExceptionCaught(cause);
        ctx.close();
    }

    /**
     * HttpRequest 초기화
     */
	private void reset() {
		this.httpRequest = null;
    }





    /**
     *  응답에 대한 요청 처리
     * @param currentObj
     * @param ctx
     * @return
     */
	private boolean writeResponse(HttpObject currentObj, ChannelHandlerContext ctx) {
        
		// Decide whether to close the connection or not.
        boolean keepAlive = HttpUtil.isKeepAlive(httpRequest);

        // Build the response object.
        FullHttpResponse response = new DefaultFullHttpResponse(
                                                                HTTP_1_1,
                                                                currentObj.decoderResult().isSuccess() ? OK : BAD_REQUEST,
                                                                Unpooled.copiedBuffer( "test", CharsetUtil.UTF_8));

        //HttpHeaderNames.CONTENT_LENGTH;
        response.headers().set(CONTENT_TYPE, "application/text; charset=UTF-8");
        if (keepAlive) {
            response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
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
