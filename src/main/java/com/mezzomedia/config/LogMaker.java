package com.mezzomedia.config;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * 
 * <pre>
 * Class Name  : LogMaker.java
 * Description : logback Filter에서 사용하기 위한 Maker 정의 
 *               fileLog를 요청 및 유형에 따라 분리시키기 위함  
 *               
 * Modification Information
 *
 *    수정일　　　 　　  		수정자　　　     			  수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2018. 2. 21.          mezzomedia               최초생성
 * </pre>
 *
 * @author mezzomedia
 * @since 2018. 2. 21.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class LogMaker {
	
	public static Marker accessMaker = MarkerFactory.getMarker(LogMakerCode.ACCESS_MAKER.name());
	public static Marker responseMaker = MarkerFactory.getMarker(LogMakerCode.RESPONSE_MAKER.name());
	
	/**
	 * <pre>
	 * Class Name  : LogMaker.java
	 * Description : logbak 에서 사용될 Maker Name
	 * </pre>
	 */
	public enum LogMakerCode {
		ACCESS_MAKER, RESPONSE_MAKER
	}
}
