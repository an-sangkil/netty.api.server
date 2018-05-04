package com.mezzomedia.server.web.servlet.filter.core;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

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
    FilterChain filterChain;

    public FilterManager(Target target) {
        filterChain = new FilterChain();
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
     * @param request
     * @param response
     */
    public void filterRequest(HttpRequest request, HttpResponse response){
        filterChain.execute(request, response);
    }




}
