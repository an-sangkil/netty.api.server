package com.mezzomedia.server.web.servlet.filter.intercepter;

import com.mezzomedia.server.web.servlet.filter.AuthenticationFilter;
import com.mezzomedia.server.web.servlet.filter.CorsFilter;
import com.mezzomedia.server.web.servlet.filter.core.FilterManager;
import com.mezzomedia.server.web.servlet.filter.core.Target;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.LastHttpContent;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.05.02
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class IntercepterFilter {

	public IntercepterFilter(HttpRequest httpRequest, LastHttpContent lastHttpContent, ChannelHandlerContext ctx) throws Exception {

        FilterManager filterManager = new FilterManager(new Target());

        // 필터 추가
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new CorsFilter());

        // 필터 실행
        filterManager.filterRequest(httpRequest, lastHttpContent, ctx);

    }

}
