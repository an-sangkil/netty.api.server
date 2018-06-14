package com.mezzomedia.server.template;

import java.util.Map;

import com.mezzomedia.core.model.common.ResponseResult;

/**
 * <pre>
 * Description :
 * 
 * @author mezzomedia
 * @since 2018.06.14
 * @version
 *
 * 			Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public abstract class AbstractApiRequest<T> implements ApiRequest, ApiRequestObject<T> {

	protected Map<String, String> reqData;

	public AbstractApiRequest() {
	}

	public AbstractApiRequest(Map<String, String> reqData) {
		this.reqData = reqData;
	}

	protected ResponseResult<T> responseResult;

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mezzomedia.server.template.ApiRequest#executeService(java.lang.Object)
	 */
	public ResponseResult<T> executeService(T t) throws Exception {

		ResponseResult<T> result = null;
		try {

			// TODO 필수 파라미터 체크
			// annotation 선언 및 개발
			this.parameterValidation(t);

			// 실행
			this.service(t);

			// 결과 확인
			this.responseResult.setObject(t);

		} catch (Exception e) {

			// ERROR 처리

		}

		return result;

	}

	@Override
	public ResponseResult<T> responseResult() throws Exception {
		this.responseResult = new ResponseResult<>();
		return this.responseResult;
	}

}
