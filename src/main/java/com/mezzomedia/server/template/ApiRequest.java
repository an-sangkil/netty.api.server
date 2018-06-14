package com.mezzomedia.server.template;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.06.14
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public interface ApiRequest<T> {


    public void parameterValidation() throws Exception;

    /**
     * 서비스 구현
     *
     * @throws Exception
     */
    public void service(T t) throws Exception;

    /**
     * 서비스 실행
     *
     * @throws Exception
     */
    public void executeService(T t) throws Exception;

    /**
     * Response 결과값 생성
     *
     * @throws Exception
     */
    public void responseResult() throws Exception;

}