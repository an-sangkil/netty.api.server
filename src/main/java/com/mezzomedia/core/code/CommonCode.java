package com.mezzomedia.core.code;

/**
 * 
 * Description : 공통 코드 
 *  
 * @author skan
 * @since 2018. 9. 8.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia. All right reserved.
 */
public enum CommonCode {
	
	// Controller 성공 실패 응답 코드 
	RESPONSE_CODE("응답에 대한 성공 실패 코드"),
		SUCCESS("성공 하였습니다."),
		FAIL("실패 하였습니다."),
			FAIL_NODATA("데이터 없음"),
			FAIL_LOCATION_NO_DATA("지면 없음");
	
	
		

	private String codeName;
	private CommonCode (String codeName) {
		this.codeName = codeName;
	}
	
	/**
	 * 역할 코드 이름
	 * @return
	 */
	public String getCodeName() {
		return codeName;
	}
}
