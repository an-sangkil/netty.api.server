package com.netty.api.server.template;

import java.util.Map;
import com.netty.api.core.code.CommonCode;
import com.netty.api.core.model.common.ResponseResult;

/**
 * <pre>
 * Description :
 * 
 * @author skan
 * @since 2018.06.14
 * @version
 *
 * 			Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public abstract class AbstractApiTemplate<T> implements ApiRequest {

	protected Map<String, Object> reqData;
	protected ResponseResult<T> responseResult;
	

	public AbstractApiTemplate() {
	}

	public AbstractApiTemplate(Map<String, Object> reqData) {
		this.reqData = reqData;
		this.responseResult = new ResponseResult<>();
	}


	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mezzomedia.server.template.ApiRequest#executeService(java.lang.Object)
	 */
	@Override
	public void  executeService() throws Exception {

		try {

			//  필수 파라미터 체크, annotation 선언 및 개발
			this.requestParamValidation();

			// 실행
			this.service();


		} catch (Exception e) {

			// ERROR 처리
			this.responseResult.setStateCode(CommonCode.FAIL);

		}
	}
	
	public ResponseResult<T> responseResult() throws Exception {
		return this.responseResult;
		
	}

}
