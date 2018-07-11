package com.mezzomedia.server;

import org.apache.commons.lang.SystemUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mezzomedia.server.channel.init.ApplicationChannelInitializer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <pre>
 * </pre>
 *
 * @author skan
 * @since 2018. 2. 19.
 * @version
 *
 * 			Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
@Component
public class AdvertisementServer {

	@Value("${netty.server.port:8080}")
	private int tcpPort;

	public void start() {
		
		EventLoopGroup parentGroup = null;
		EventLoopGroup childGroup  = null;

		if(SystemUtils.IS_OS_UNIX || SystemUtils.IS_OS_LINUX ) {
			parentGroup = new EpollEventLoopGroup();
			childGroup = new EpollEventLoopGroup();
		} else {
			parentGroup = new NioEventLoopGroup();
			childGroup = new NioEventLoopGroup();
		}

		try {
			ServerBootstrap sb = new ServerBootstrap();
			sb.group(parentGroup, childGroup)
					.channel(Epoll.isAvailable() ? EpollServerSocketChannel.class : NioServerSocketChannel.class)

					// 외부 요청을 받는 채널 옵션
					.option(ChannelOption.SO_BACKLOG, 300)

					// 커넥션이 맺어진 후 생성되는 자식 채널을 위한 옵션
					//   - keepAlive option 지정
					//.childOption()

					// .handler(new LoggingHandler(LogLevel.INFO))

					// 새롭게 액세스된 Channel을 처리합니다. ChannelInitializer는 특별한 핸들러로 새로운 Channel의 환경 구성을 도와 주는 것이 목적입니다.
					//  - 연결이 수락될때마다 호출

					.childHandler(new ApplicationChannelInitializer());


			// 인커밍 커넥션을 액세스하기 위해 바인드하고 시작합니다.
			ChannelFuture cf = sb.bind(tcpPort).sync();

			// 서버 소켓이 닫힐때까지 대기합니다.
			cf.channel().closeFuture().sync();


//			List<ChannelFuture> futures = new ArrayList<>();
//			futures.add(sb.bind(8080));
//			futures.add(sb.bind(8081));
//			for (ChannelFuture channelFuture : futures){
//				channelFuture.sync();
//			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 대기중이 이벤트와 작업을 모두 처리 하거나 종료.
			parentGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}
	}
}
