package com.mezzomedia.server.web.servlet.filter;

import com.mezzomedia.server.web.servlet.filter.core.Filter;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.05.02
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class AuthenticationFilter implements Filter {

        @Override
    public boolean execute(HttpRequest httpRequest, HttpResponse httpResponse) {
        // HEADER 에서 token 체크
        HttpHeaders headers = httpRequest.headers();
        System.out.println("filter1");

        // TODO TOKEN 인증 실패에 따른 pipeline 종료
        if ("test".equals("test")) {
            return false;
        }
        return true;
    }

    @Override
    public void postProcessing(HttpRequest httpRequest, HttpResponse httpResponse) {
        System.out.println("AuthenticationFilter : postProcessing ");
    }

}
