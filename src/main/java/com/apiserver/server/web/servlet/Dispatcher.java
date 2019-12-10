package com.apiserver.server.web.servlet;

import java.net.URI;
import java.util.Map;

import com.apiserver.core.service.DefaultService;
import com.apiserver.core.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.apiserver.core.service.audience.AudienceFindAerospike;
import com.apiserver.config.ApplicationContextProvider;
import com.apiserver.server.template.ApiRequest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;

/**
 * 
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
 * 			Copyright (C) 2018 by CJENM|Mezzimedia.Inc. All right reserved.
 */
public class Dispatcher {

	private static Logger logger = LoggerFactory.getLogger(Dispatcher.class);

	/**
	 * Spring Context를 주입 받아 사용하기 위함. {@link ApplicationContextProvider} 사용
	 */
	public void initializer(ApplicationContext springContext) {
		logger.info("applicationContextProvider = {} ");
	}

	/**
	 *  TODO : 요청 URI , URL PATH 확인후 분기 처리
	 * @param httpRequest
	 * @param lastHttpContent
	 * @param ctx
	 * @param requestData
	 * @return
	 * @throws Exception
	 */
	public static ApiRequest dispatch(HttpRequest httpRequest
			, LastHttpContent lastHttpContent
			, ChannelHandlerContext ctx 
			, Map<String, Object> requestData) throws Exception {

		logger.trace("dispatch ........ handling....");

		// URI URL PATH 분리
		String urlPath = httpRequest.uri();
		URI uri = URI.create(urlPath);
		HttpMethod method = httpRequest.method();
		
		ApiRequest  apiRequest = null; 
		
		switch (uri.getPath()) {
		case "/audience":
			
			apiRequest = ApplicationContextProvider.getBean(AudienceFindAerospike.class, requestData);
			
			break;
		case "/user/findAll":
			
			break;
		case "/kafka/sender1":

			apiRequest = ApplicationContextProvider.getBean(KafkaService.class, requestData);

			break;
		default:
			apiRequest = ApplicationContextProvider.getBean(DefaultService.class, requestData);
			break;
		}
		
		
		return apiRequest;
		
	}


}
