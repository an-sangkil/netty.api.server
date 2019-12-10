package com.apiserver.server.template;

import com.apiserver.core.model.common.ResponseResult;

/**
 * API Service request worker interface
 * 
 * @author kris
 */
public interface ApiRequest {
	
    /**
     * Request param null check method.
     * 
     * @throws Exception
     */
    public void requestParamValidation() throws Exception;

    /**
     * 서비스 구현
     * 
     * @throws Exception
     */
    public void service() throws Exception;

    /**
     * API서비스 호출시 실행.
     * 
     * @throws Exception
     */
    public void executeService() throws Exception;

    /**
     * API 서비스 수행 결과 조회.
     * 
     * @return
     */
    public <T> ResponseResult<T> responseResult() throws Exception;
}
