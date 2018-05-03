package com.mezzomedia.server.web.servlet.filter;

import com.mezzomedia.server.web.servlet.filter.core.Filter;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;

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
    public void execute(HttpRequest httpRequest) {
        // HEADER 에서 token 체크
        HttpHeaders headers = httpRequest.headers();
        System.out.println("filter1");

    }

}
