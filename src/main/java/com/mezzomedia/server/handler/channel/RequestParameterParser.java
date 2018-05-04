package com.mezzomedia.server.handler.channel;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * METHOD  GET  요청 파라미터 파싱
     * @param httpRequest
     * @param requestData
     */
    public void  readGetData(HttpRequest httpRequest, Map<String,Object> requestData ) ;

    /**
     * METHOD  POST  요청 파라미터 파싱
     * @param httpRequest
     * @param requestData
     */
    public void  readPostData(HttpRequest httpRequest, Map<String,Object> requestData ) ;


    public default void responseData () {

    }



}
