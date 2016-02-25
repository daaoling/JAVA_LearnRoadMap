/*
 * 2011-8-22 o≧﹏≦o Powered by EXvision
 */

package org.ace.endingCode;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import AceCode.ByteArray;

/**
 * 抗粘包编码器[4-length][bytes]<br>
 * 
 * @author EXvision
 * @since 2011-8-22
 */
public class LengthFieldEncoder extends OneToOneEncoder
{
//	private static final int lengthFieldLength = 4;
	@Override
	protected Object encode(ChannelHandlerContext ctx, Channel channel,
			Object msg) throws Exception
	{
		ChannelBuffer body = (ChannelBuffer) msg;
		
		ChannelBuffer header = ChannelBuffers.dynamicBuffer();

		int length = body.readableBytes();
		ByteArray arr=new ByteArray();
		arr.WriteInt(length);
		arr.WriteBytes(body.readBytes(length).array());
		header.writeBytes(arr.getBuffer());
		body.resetReaderIndex();
		return header;
	
	}
}
