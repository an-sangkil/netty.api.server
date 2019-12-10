package com.mezzomedia.server.web.servlet.filter.core;

import io.netty.handler.codec.http.HttpRequest;
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
public interface Filter {

    /**
     * 업무 시작 전처리 작업
     * @param httpRequest
     * @param lastHttpContent
     * @return
     */
    public boolean  execute(HttpRequest httpRequest, LastHttpContent lastHttpContent);

    /**
     * 업무 후처리 작업
     * @param httpRequest
     * @param lastHttpContent
     */
    public void postProcessing(HttpRequest httpRequest, LastHttpContent lastHttpContent) ;

}
