package com.mezzomedia.core.model.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mezzomedia.core.code.CommonCode;

public class ResponseResult<T> extends AbstractResponseObject<T> {

    /** 성공에대한 객체 */
    private Data<T> data;
    /** 실패에 대한 에러 */
    private Error error;

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

    public Data<T> getData() {
        return data;
    }

    public void setData(Data<T> data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
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

	@Override
	public String toJsonString() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(this.getClass());
	}

	@Override
	public String toXMLString() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
