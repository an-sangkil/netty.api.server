package com.mezzomedia.core;

import com.mezzomedia.handler.MezzoHttpHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * 
 * <pre>
 * Class Name  : ApplicationChannelInitializer.java
 * Description : 
 * Modification Information
 *
 *    수정일　　　 　　  		수정자　　　     			  수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2018. 2. 19.          skan               최초생성
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
		
		ChannelPipeline channelPipeline =  socketChannel.pipeline();
		
		channelPipeline.addLast(new HttpRequestDecoder());
		channelPipeline.addLast(new HttpObjectAggregator(65536));
		channelPipeline.addLast(new HttpResponseEncoder());
		channelPipeline.addLast(new HttpContentCompressor());
		channelPipeline.addLast(new MezzoHttpHandler());
		
	}

}
