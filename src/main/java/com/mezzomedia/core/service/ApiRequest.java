package com.mezzomedia.core.service;

public interface ApiRequest {
	/**
	 * Request param null check method.
	 * 
	 * @throws RequestParamException
	 */
	public void requestParamValidation();

	/**
	 * 서비스 구현
	 * 
	 * @throws Exception
	 */
	public void service();

	/**
	 * API서비스 호출시 실행.
	 * 
	 * @throws Exception
	 */
	public void executeService();

}
