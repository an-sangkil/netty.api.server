package com.mezzomedia.server.web.servlet.filter.core;

import com.mezzomedia.server.web.servlet.handler.HandlerInterceptor;
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
public interface Filter {

    /**
     * 업무 시작 전처리 작업
     * @param httpRequest
     * @return
     */
    public boolean  execute(HttpRequest httpRequest, HttpResponse httpResponse);

    /**
     * 업무 후처리 작업
     * @param httpRequest
     * @param httpResponse
     */
    public void postProcessing(HttpRequest httpRequest, HttpResponse httpResponse) ;

}
