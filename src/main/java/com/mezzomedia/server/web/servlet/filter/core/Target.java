package com.mezzomedia.server.web.servlet.filter.core;

import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mezzomedia.server.web.servlet.Dispatcher;

import java.net.URI;
import java.util.HashMap;

/**
 * <pre>
 * Description :
 * @author skan
 * @since 2018.05.02
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class Target {

    Logger logger = LoggerFactory.getLogger(Target.class);

    //Target object is the request handler
    public void execute(HttpRequest httpRequest, HttpResponse response) {

        logger.debug("target execute Start !!!!!!!!!!!!!!!!!! ");
        // URI URL PATH  분리
        String urlPath = httpRequest.uri();
        URI uri =URI.create(urlPath);
        HttpMethod method = httpRequest.method();

        Dispatcher.dispatch(uri.getPath() , new HashMap<>() , method);



    }
}
