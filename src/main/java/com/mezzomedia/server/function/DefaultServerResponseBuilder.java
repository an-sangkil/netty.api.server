package com.mezzomedia.server.function;

import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.mezzomedia.server.function.ServerResponse.BodyBuilder;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EmptyHeaders;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.CharsetUtil;

/**
 * 
 * <pre>
 * Description : 
 * </pre>
 *
 * @author skan
 * @since 2018. 6. 11.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class DefaultServerResponseBuilder implements ServerResponse.BodyBuilder {
	
	private final HttpResponseStatus httpResponseStatus;
	private HttpHeaders httpHeaders = new DefaultHttpHeaders();
	private FullHttpResponse response;
	
	public DefaultServerResponseBuilder(HttpResponseStatus ok) {
		Assert.notNull(ok,"ServerResponse must not be null");
		this.httpResponseStatus = ok;
	}
	
	public DefaultServerResponseBuilder(HttpHeaders httpHeaders, HttpResponseStatus httpResponseStatus) {
		this.httpHeaders = httpHeaders;
		this.httpResponseStatus = httpResponseStatus;
	}
	
	@Override
	public ServerResponse.BodyBuilder header(String headerName, String... headerValues) {
		for (String headerValue : headerValues) {
			this.httpHeaders.add(headerName, headerValue);
		}
		return this;
	}

	@Override
	public BodyBuilder contentLength(long contentLength) {
		this.httpHeaders.set(HttpHeaderNames.CONTENT_LENGTH, contentLength);
		return this;
	}
	
	@Override
	public BodyBuilder contentLength() {
		this.httpHeaders.set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
		return this;
	}

	@Override
	public BodyBuilder contentType(String contentType, String directive) {
		
		if(StringUtils.isEmpty(contentType)) {
			this.httpHeaders.set(HttpHeaderNames.CONTENT_TYPE, "application/text; charset=UTF-8");	
		} else {
			this.httpHeaders.set(contentType, directive);
		}
		return this;
	}

	@Override
	public BodyBuilder hint(String key, Object value) {
		// TODO Auto-generated method stub
		return this;
	}
	
	@Override
	public FullHttpResponse body() {
		return null;
	}
	
	
	@Override
	public FullHttpResponse body(HttpObject currentObj, ChannelHandlerContext ctx, Object o) {

        // Build the response object.
        response = new DefaultFullHttpResponse(
                                                HTTP_1_1,
                                                currentObj.decoderResult().isSuccess() ? OK : BAD_REQUEST,
                                                Unpooled.copiedBuffer( o.toString() , CharsetUtil.UTF_8));

        this.contentLength();
        response.headers().set(httpHeaders);
        
		return response;
	}
	
}
