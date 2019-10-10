package com.netty.api.core.model.common;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.06.20
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class Error implements ReturnObject {

    /**
     *  사용자 Error 메세지
     */
    private String userMessage;

    /**
     * 시스템 Error 메세지
     */
    private String internalMessage;

    /**
     * 에러 코드
     */
    private String code;

    


}
