package com.netty.api.server.handler.channel;

import java.util.Map;

import io.netty.handler.codec.http.HttpRequest;

/**
 * <pre>
 * Description : 요청 파라미터에 대한 파싱 인터페이스 
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

    
    /**
     * default Response data 생성  
     */
    public default void responseData () {

    }



}
