package com.apiserver.server.template;

import com.apiserver.core.model.common.ResponseResult;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.06.14
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public interface ServiceTemplate<T> {

	/**
	 * 필수 파라미터 체크 
	 * @param t
	 * @throws Exception
	 */
	public void parameterValidation(T t) throws Exception;

    /**
     * 서비스 구현
     *
     * @throws Exception
     */
    void service(T t) throws Exception;

    /**
     * 서비스 실행 - 객체 방식 
     *
     * @throws Exception
     */
    public ResponseResult<T> executeService(T t) throws Exception;
    

    /**
     * Response 결과값 생성
     *
     * @throws Exception
     */
    public ResponseResult<T> responseResult(T t) throws Exception;


}