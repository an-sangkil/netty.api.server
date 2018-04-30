package com.mezzomedia.server.handler.channel;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mezzomedia.server.config.LogMaker;
import com.mezzomedia.server.web.servlet.handler.DispatcherServlet;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
public class MezzoHttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

	private Logger logger  = LoggerFactory.getLogger(MezzoHttpRequestHandler.class);
    private HttpPostRequestDecoder decoder;
	private HttpRequest httpRequest ;
    private static final HttpDataFactory factory = new DefaultHttpDataFactory(DefaultHttpDataFactory.MINSIZE); // Disk
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
                        reqData.put(key, h.getValue());
                    }
                }
            }
        }
		

        ///////////////////////////////////////////////////////////////////////////////
        // HttpContent ( Body ) 처리
        ///////////////////////////////////////////////////////////////////////////////
		if (msg instanceof HttpContent) {
            if (msg instanceof LastHttpContent) {


                LastHttpContent trailer = (LastHttpContent) msg;

                // GET POST data parameter parser
                this.readGetData();
                if(httpRequest.method().equals(HttpMethod.POST)) {
                    this.readPostData();
                }

                // URI URL PATH  분리
                String urlPath = httpRequest.uri();
                URI uri =URI.create(urlPath);
                uri.getPath();


                ////////////////////////////////////////////////////
                // Request Mapping 처리 .. Business logic 처리
                ////////////////////////////////////////////////////
                try {
                    DispatcherServlet.dispatch(urlPath, requestData, httpRequest.method());
                } finally {
                    requestData.clear();
                }

                ////////////////////////////////////////////////////
                // Response 처리
                ////////////////////////////////////////////////////

                if (!writeResponse(trailer, ctx)) {
                    ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
                }

                this.reset();

            }
        }


	}
	
	@Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        logger.info("요청 처리 완료");
        ctx.flush();
    }

    /**
     * HttpRequest 초기화
     */
	private void reset() {
		this.httpRequest = null;
    }


    /**
     * GET Data 에 대한 parameter parser
     */
    private void readGetData() {
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(httpRequest.uri(), CharsetUtil.UTF_8);
        queryStringDecoder.parameters().forEach((k,v) -> {
            requestData.put(k , v);
        });
    }


    /**
     * Post Data 에 대한 request Parameter parser
     */
    private void readPostData() {
       // HttpPostRequestDecoder decoder = null;
        try {

            decoder = new HttpPostRequestDecoder(factory, httpRequest);
            for (InterfaceHttpData data : decoder.getBodyHttpDatas()) {
                if (InterfaceHttpData.HttpDataType.Attribute == data.getHttpDataType()) {
                    try {
                        Attribute attribute = (Attribute) data;
                        requestData.put(attribute.getName(), attribute.getValue());
                    }
                    catch (IOException e) {
                        logger.error("BODY Attribute: " + data.getHttpDataType().name(), e);
                        return;
                    }
                }
                else {
                    logger.info("BODY data : " + data.getHttpDataType().name() + ": " + data);
                }
            }


        } catch (HttpPostRequestDecoder.ErrorDataDecoderException e) {
            logger.error("readPostData error = { } ",e);
        } finally {
            if (decoder != null) {
                decoder.destroy();
            }
        }
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
        response.headers().set(CONTENT_TYPE, "application/json; charset=UTF-8");
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
