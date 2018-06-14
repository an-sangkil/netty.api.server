package com.mezzomedia.server.web.servlet.filter.core;

import java.util.Map;

import com.mezzomedia.core.model.common.AbstractResponseObject;
import com.mezzomedia.core.model.common.ResponseResult;
import com.mezzomedia.server.function.ServerResponse;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.LastHttpContent;

/**
 * <pre>
 * Description :
 * @author skan
 * @since 2018.05.02
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class FilterManager {
    FilterChain<ResponseResult<Object>> filterChain;

    public FilterManager(Target target) {
    	
        filterChain = new FilterChain<ResponseResult<Object>>();
        filterChain.setTarget(target);
        
    }

    /**
     * 수행될 Filfer 등록
     * @param filter
     */
    public void setFilter(Filter filter){
    	
        filterChain.addFilter(filter);
        
    }

  
    /**
     * Filter 실행
     * @param requestData 
     * @param request
     * @param response
     * @throws Exception 
     */
	public void filterRequest(HttpRequest httpRequest, LastHttpContent lastHttpContent, ChannelHandlerContext ctx, Map<String, Object> requestData) throws Exception {
		
		 filterChain.execute(httpRequest, lastHttpContent, ctx, requestData);
		
	}






}
