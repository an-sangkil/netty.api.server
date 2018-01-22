package cj.enm.mezzo;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EhcoServerHandler extends ChannelInboundHandlerAdapter {
	// 채널을 읽을 때 동작할 코드를 정의 합니다
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		
		String readMessage = ((ByteBuf)msg).toString(Charset.defaultCharset());
		ctx.write(msg); // 메시지를 그대로 다시 write 합니다.
		System.out.println(readMessage);
	}

	// 채널 읽는 것을 완료했을 때 동작할 코드를 정의 합니다.
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush(); // 컨텍스트의 내용을 플러쉬합니다.
	};

	// 예외가 발생할 때 동작할 코드를 정의 합니다.
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace(); // 쌓여있는 트레이스를 출력합니다.
		ctx.close(); // 컨텍스트를 종료시킵니다.
	}
}