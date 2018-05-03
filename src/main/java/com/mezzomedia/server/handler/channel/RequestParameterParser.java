package com.mezzomedia.server.handler.channel;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Description :
 * @author skan
 * @since 2018.05.02
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public interface RequestParameterParser {


    /**
     * GET Data 에 대한 parameter parser
     */
    public default void  readGetData(HttpRequest httpRequest, Map<String,Object> requestData ) {
        QueryStringDecoder queryStringDecoder = new QueryStringDecoder(httpRequest.uri(), CharsetUtil.UTF_8);
        queryStringDecoder.parameters().forEach((k,v) -> {
            requestData.put(k , v);
        });
    }



}
