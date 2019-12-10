package com.mezzomedia.server.web.servlet.handler;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

/**
 * 
 * <pre>
 * 
 * 특정 업무를 수행할 url Mapping 및 Service 호출 
 *  
 * </pre>
 *
 * @author skan
 * @since 2018. 2. 27.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class HandlerInterceptorAdapter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpRequest request, HttpResponse response) throws Exception {
        return false;
    }

    @Override
    public void postHandle(HttpRequest request, HttpResponse response) throws Exception {

    }

    @Override
    public void afterCompletion(HttpRequest request, HttpResponse response) throws Exception {

    }
}
