package com.mezzomedia.core.model.common;

import com.mezzomedia.core.code.CommonCode;

public abstract class AbstractResponseObject<T> {
	
	/** 응답시 넘겨줄 객체 를 제네릭으로 선언하여 사용한다. */
	private T object;
	
	/** 응답 메세지 */
	private String responseMessage;
	
	/**
	 * 상태코드
	 * {
	 * 		success : 성공
	 * 		fail	: 실패
	 * } 
	 * 
	 */
	private CommonCode stateCode;

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public CommonCode getStateCode() {
		return stateCode;
	}

	public void setStateCode(CommonCode stateCode) {
		this.stateCode = stateCode;
	}

}
