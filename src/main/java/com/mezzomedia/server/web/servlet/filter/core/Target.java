package com.mezzomedia.server.web.servlet.filter.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mezzomedia.core.model.common.AbstractResponseObject;
import com.mezzomedia.core.model.common.ResponseResult;
import com.mezzomedia.server.function.ServerResponse;
import com.mezzomedia.server.template.AbstractApiRequest;
import com.mezzomedia.server.web.servlet.Dispatcher;
import com.mezzomedia.util.utils.json.JsonUtils;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.LastHttpContent;

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
	 */
	public <T> AbstractResponseObject<T> execute(HttpRequest httpRequest, LastHttpContent lastHttpContent,
			ChannelHandlerContext ctx) throws Exception {
		// logger.debug("target execute Start !!!!!!!!!!!!!!!!!! ");

		// service  호출
		Dispatcher.dispatch(httpRequest, lastHttpContent, ctx);
		

		return null;
	}

	

}
