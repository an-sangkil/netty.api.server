package com.mezzomedia.server.web.servlet.filter.core;

import com.mezzomedia.server.web.servlet.handler.Dispatcher;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;

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


    //Target object is the request handler
    public void execute (HttpRequest httpRequest) {
        System.out.println("target execute");
        Dispatcher.dispatch("",new HashMap<>(),HttpMethod.GET);
    }
}
