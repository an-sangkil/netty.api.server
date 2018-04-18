package com.mezzomedia.server.handler.channel;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

/**
 * <pre>
 * 	 HTTP Channel Handler 설정 및 처리
 * 		모든 Request 및 Response 의 처리를  해당 채널에서 구현 한다.
 *
 *  	TODO : 1. Auth 처리
 *             2. Parameter 처리 .
 *             3. URL Mapping
 *
 *
 * </pre>
 *
 * @author skan
 * @since 2018. 2. 27.
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Deprecated
public class ApiRequestParser implements ChannelHandler {

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub

	}

}
