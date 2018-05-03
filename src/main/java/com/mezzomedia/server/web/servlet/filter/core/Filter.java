package com.mezzomedia.server.web.servlet.filter.core;

import com.mezzomedia.server.web.servlet.handler.HandlerInterceptor;
import io.netty.handler.codec.http.HttpRequest;

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

    public void execute(HttpRequest httpRequest);



}
