package com.mezzomedia.server.web.servlet;

import io.netty.handler.codec.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mezzomedia.core.model.dto.AerospikeProduct;
import com.mezzomedia.server.config.ApplicationContextProvider;
import com.mezzomedia.core.service.AerospikeService;
import com.mezzomedia.core.service.MybatisService;

import java.util.Map;

/**

 * <pre>
 * 	
 * 	클라이언트로 부터 받은 HTTP / HTTPS 요청에 대한  Handler Mapping 및 분기 처리 
 * 
 * </pre>
 *
 * @author skan
 * @since 2018. 2. 27.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Component
public class Dispatcher {
	
	private static Logger logger = LoggerFactory.getLogger(Dispatcher.class);
	
	@Autowired private ApplicationContextProvider applicationContextProvider;
	
	private static ApplicationContext APPLICATION_SPRING_CONTEXT;


	@Autowired
	public void initializer(ApplicationContext springContext) {
//		APPLICATION_SPRING_CONTEXT = springContext;
//		applicationContextProvider.setApplicationContext(springContext);
//
//		logger.info("springContext = {} " ,  APPLICATION_SPRING_CONTEXT);
		logger.info("applicationContextProvider = {} " ,  applicationContextProvider);
	}
	
	/**
	 * 
	 * TODO : 요청 URI , URL PATH  확인후 분기 처리
     *
	 * @param httpMethod
     * @param requestDate
     * @param urlPath
	 */
	public static <T> T dispatch(String urlPath, Map<String,Object> requestDate , HttpMethod httpMethod) {

		logger.debug("dispatch ........ handling....");
		logger.debug("///////////////////////////////////////////////////////////////////");
		logger.debug("//  AEROSPIKE TEST ");
		logger.debug("///////////////////////////////////////////////////////////////////");
		AerospikeService aerospikeService =ApplicationContextProvider.getBean(AerospikeService.class);
		aerospikeService.save(new AerospikeProduct());





//		logger.debug("///////////////////////////////////////////////////////////////////");
//		logger.debug("//  Redis TEST");
//		logger.debug("///////////////////////////////////////////////////////////////////");
//
//		RedisService redisService = ApplicationContextProvider.getBean(RedisService.class);
//		redisService.save(new Object());

//		logger.debug("///////////////////////////////////////////////////////////////////");
//		logger.debug("//  Mybatis  TEST");
//		logger.debug("///////////////////////////////////////////////////////////////////");
//
		MybatisService mybatisService = ApplicationContextProvider.getBean(MybatisService.class);
		mybatisService.findUserList();

		return null;
	}


}
