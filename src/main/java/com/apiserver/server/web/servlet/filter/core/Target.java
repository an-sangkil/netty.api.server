package com.apiserver.server.web.servlet.filter.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.apiserver.core.model.common.AbstractResponseObject;
import com.apiserver.core.model.common.ResponseResult;
import com.apiserver.server.function.ServerResponse;
import com.apiserver.server.template.ApiRequest;
import com.apiserver.server.web.servlet.Dispatcher;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * <pre>
 * Description :
 * 
 * @author skan
 * @since 2018.05.02
 * @version
 *
 * 			Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class Target {

	Logger logger = LoggerFactory.getLogger(Target.class);

	/**
	 * Target object is the request handler
	 * 
	 * @param httpRequest
	 * @param lastHttpContent
	 * @param ctx
	 * @param requestData 
	 */
	public <T> AbstractResponseObject<T> execute(HttpRequest httpRequest, LastHttpContent lastHttpContent,
			ChannelHandlerContext ctx, Map<String, Object> requestData) throws Exception {
		// logger.debug("target execute Start !!!!!!!!!!!!!!!!!! ");

		// service  호출
		ApiRequest apiRequest = Dispatcher.dispatch(httpRequest, lastHttpContent, ctx, requestData);
		
		System.out.println("apiRequest = "+ apiRequest);

		apiRequest.executeService();
		ResponseResult<T> response =  apiRequest.responseResult();
		this.response(httpRequest, lastHttpContent, ctx, response);

		return null;
	}
	
	
	/**
	 * 
	 * @param httpRequest
	 * @param lastHttpContent
	 * @param ctx
	 * @param response
	 * @throws Exception
	 */
	public static <T> void response(HttpRequest httpRequest, LastHttpContent lastHttpContent, ChannelHandlerContext ctx,
			AbstractResponseObject<T> response) throws Exception {

		// Decide whether to close the connection or not.
		boolean keepAlive = HttpUtil.isKeepAlive(httpRequest);

		if (!keepAlive) {
			ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		FullHttpResponse fullHttpResponse = ServerResponse.status(HttpResponseStatus.INTERNAL_SERVER_ERROR)
				.contentType("", "").body(lastHttpContent, ctx, objectMapper.writeValueAsString(response));

		// Write the response.
		ctx.write(fullHttpResponse);

	}

	

}
