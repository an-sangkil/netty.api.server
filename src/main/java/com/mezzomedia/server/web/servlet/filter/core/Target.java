package com.mezzomedia.server.web.servlet.filter.core;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.LastHttpContent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mezzomedia.core.model.common.AbstractResponseObject;
import com.mezzomedia.server.web.servlet.Dispatcher;

import java.net.URI;
import java.util.HashMap;

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
	public <T> AbstractResponseObject<T>  execute(HttpRequest httpRequest, LastHttpContent lastHttpContent, ChannelHandlerContext ctx) throws Exception{
		//logger.debug("target execute Start !!!!!!!!!!!!!!!!!! ");
		
		Dispatcher.dispatch(httpRequest, lastHttpContent, ctx);
		
		return null;
	}
}
