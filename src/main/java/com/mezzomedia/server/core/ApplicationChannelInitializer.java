package com.mezzomedia.server.core;

import com.mezzomedia.server.handler.channel.ApiRequestParser;
import com.mezzomedia.server.handler.channel.MezzoHttpHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 
 * <pre>
 * Description : 채널 초기화 부분 -> HTTP 채널 사용
 *               Request, Response 및  Body 자동 컴포져
 *               사용자 확장 핸들러 추가 
 *               
 * </pre>
 *
 * @author skan
 * @since 2018. 2. 19.
 * @version 
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class ApplicationChannelInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {
		///////////////////////////////////////////////
		// 채널 파이프라인 객체 생성
		///////////////////////////////////////////////
		ChannelPipeline channelPipeline =  socketChannel.pipeline();
		
		channelPipeline.addLast(new HttpRequestDecoder());
		channelPipeline.addLast(new HttpObjectAggregator(65536));
		channelPipeline.addLast(new HttpResponseEncoder());
		channelPipeline.addLast(new HttpContentCompressor());
		channelPipeline.addLast(new ApiRequestParser());
		channelPipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
		channelPipeline.addLast(new MezzoHttpHandler());
		
	}

}
