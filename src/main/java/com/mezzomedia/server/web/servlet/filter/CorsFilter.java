package com.mezzomedia.server.web.servlet.filter;

import com.mezzomedia.server.web.servlet.filter.core.Filter;
import io.netty.handler.codec.http.HttpHeaders;
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
public class CorsFilter implements Filter {

    @Override
    public boolean execute(HttpRequest httpRequest, LastHttpContent lastHttpContent) {
        // HEADER 에서 token 체크
        //System.out.println("header " + headers);

        return true;
    }

    @Override
    public void postProcessing(HttpRequest httpRequest, LastHttpContent lastHttpContent) {
        //System.out.println("CorsFilter : postProcessing ");
    }

}
