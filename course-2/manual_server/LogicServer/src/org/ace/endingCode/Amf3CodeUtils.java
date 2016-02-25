package org.ace.endingCode;

import java.io.IOException;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import AceCode.ByteArray;

public class Amf3CodeUtils {
	
	public static ChannelBuffer encode(
			@SuppressWarnings("rawtypes") SocketModel model) throws IOException
	{

		return amf3ChannelBufferEncode(model);
	}
	
	private static ChannelBuffer amf3ChannelBufferEncode(
			@SuppressWarnings("rawtypes") SocketModel model) throws IOException
	{

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
	
	private static void amfEncode(Object message, ByteArray out) {
		try {
			byte[] bs=AceCode.Code.aceEncode(message);
			out.WriteBytes(bs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
