package org.ace.endingCode;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import AceCode.ByteArray;

public class AMF3NettyEncoder extends OneToOneEncoder {

	@Override
	protected Object encode(ChannelHandlerContext arg0, Channel channel,
			Object msg) throws Exception {

		if (msg instanceof ChannelBuffer) {
			return msg;
		} else {
			@SuppressWarnings("rawtypes")
			SocketModel model = (SocketModel) msg;
			ChannelBuffer out = ChannelBuffers.dynamicBuffer();
			ByteArray arr=new ByteArray();

			arr.WriteInt(model.getType());
			arr.WriteInt(model.getArea());
			arr.WriteInt(model.getCommand());
			amfEncode(model.getMessage(), arr);
			out.writeBytes(arr.getBuffer());
			arr=null;
			return out;
		}

	}

	private void amfEncode(Object message, ByteArray out) {
		try {
			byte[] bs=AceCode.Code.aceEncode(message);
			out.WriteBytes(bs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
