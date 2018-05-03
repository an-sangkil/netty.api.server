package com.mezzomedia.server.web.servlet.filter;

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
public class Target {


    //Target object is the request handler
    public void execute (HttpRequest httpRequest) {
        System.out.println("target execute");

    }
}
