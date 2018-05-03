package com.mezzomedia.server.web.servlet.filter;

import com.mezzomedia.server.web.servlet.handler.HandlerInterceptor;
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
public interface Filter {

    public void execute(HttpRequest httpRequest);

}
