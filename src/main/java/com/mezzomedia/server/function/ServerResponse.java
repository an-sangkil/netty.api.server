package com.mezzomedia.server.function;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpResponseStatus;

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
public interface ServerResponse {
	
	HttpResponseStatus httpResponseStatus();
	HttpHeaders httpHeader();

	static BodyBuilder status(HttpResponseStatus status) {
		return new DefaultServerResponseBuilder(status);
	}
	
	static BodyBuilder isOk() {
		return status(HttpResponseStatus.OK);
	}
	
	static BodyBuilder isFail() {
		return status(HttpResponseStatus.BAD_REQUEST);
	}
	
	interface BodyBuilder {
			
		public BodyBuilder header(String headerName, String... headerValues);
		
		BodyBuilder contentLength(long contentLength);
		BodyBuilder contentLength();
		
		/**
		 * 
		 * @param contentType
		 * @param directive - 상세 
		 * 						media-type  : 리소스 혹은 데이터의 MIME type.
		 * 						charset		: 문자 인코딩 표준.
		 * 						boundary	: 멀티파트 개체에 대해 boundary 디렉티브는 필수인데, 이메일 게이트를 통해 매우 탄탄해졌다고 알려진 캐릭터셋의 1~70개의 문자들로 구성되며, 빈 공백으로 끝나지 않습니다. 이는 메시지의 멀티 파트 경계선을 캡슐화하기 위해 사용됩니다.
		 * @return
		 */
		BodyBuilder contentType(String contentType, String directive);
		
		BodyBuilder hint(String key, Object value);
		
		FullHttpResponse body();
		
		/**
		 * 
		 * @param currentObj
		 * @param ctx
		 * @param o
		 * @return
		 */
		FullHttpResponse body(HttpObject currentObj, ChannelHandlerContext ctx, Object o); 
		
	}
}
