package com.mezzomedia.server.handler.channel;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;

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
 * 			Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */

public class ApiRequestParser extends ChannelInboundHandlerAdapter {

//	@Override
//	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		ctx.channel();
//	}

	// public void test() {
	// System.out.println(" ApiRequestParser Call test(): ");
	// }
	public void test1() {
		System.out.println(" ApiRequestParser Call test1() : ");
	}
}
