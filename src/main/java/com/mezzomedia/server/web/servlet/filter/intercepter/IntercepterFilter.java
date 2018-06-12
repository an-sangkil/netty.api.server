package com.mezzomedia.server.web.servlet.filter.intercepter;

import com.mezzomedia.core.model.common.ResponseResult;
import com.mezzomedia.server.web.servlet.filter.AuthenticationFilter;
import com.mezzomedia.server.web.servlet.filter.CorsFilter;
import com.mezzomedia.server.web.servlet.filter.core.FilterManager;
import com.mezzomedia.server.web.servlet.filter.core.Target;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;

/**
 * <pre>
 * Description : 빌더용 인터셉터 필터 
 * @author mezzomedia
 * @since 2018.05.02
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class IntercepterFilter {
	
	 
	HttpRequest httpRequest;
	LastHttpContent lastHttpContent;
	ChannelHandlerContext ctx;
	ResponseResult<Object> responseResult;
	  
	public static class Builder {
		private HttpRequest httpRequest;
		private LastHttpContent lastHttpContent;
		private ChannelHandlerContext ctx;
		
		private ResponseResult<Object> responseResult;
		
		public Builder(HttpRequest httpRequest, LastHttpContent lastHttpContent, ChannelHandlerContext ctx) throws Exception {

	        FilterManager filterManager = new FilterManager(new Target());

	        // 필터 추가
	        filterManager.setFilter(new AuthenticationFilter());
	        filterManager.setFilter(new CorsFilter());

	        // 필터 실행
	        filterManager.filterRequest(httpRequest, lastHttpContent, ctx);
	    }
		
		
		public Builder responseResult(ResponseResult<Object> responseResult) {
			this.responseResult =  responseResult;
			return this;
		}
		
		public IntercepterFilter build() {
			return new IntercepterFilter(this);
		}
	}
	
	private IntercepterFilter(Builder builder) {
		httpRequest = builder.httpRequest;
		lastHttpContent = builder.lastHttpContent;
		ctx = builder.ctx;
		responseResult = builder.responseResult;
	}
	
	

}
