package org.ace.endingCode;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import AceCode.ByteArray;



public class AMF3NettyDecoder extends OneToOneDecoder
 {
	
	//SerializationContext serializationContext = new SerializationContext();
	     public static final Logger logger = LoggerFactory
	             .getLogger(AMF3NettyDecoder.class);
	     /**
	      * 
	      * @param maxFrameLength
	      *            包的最大大小
	     * @param lengthFieldOffset
	      *            包头信息，长度的偏移位
	      * @param lengthFieldLength
	      *            包头信息，长度位数
	      */
	
	     /**
	      * 
	     */
		@Override
		protected Object decode(ChannelHandlerContext ctx, Channel channel,
				Object msg) throws Exception {
			ChannelBuffer frame=(ChannelBuffer)msg;  
			if (frame == null)
		         {
		             return null;
		         }
			ByteArray arr=new ByteArray(frame.readBytes(frame.readableBytes()).array());
	         int type = arr.ReadInt();
	 		int area = arr.ReadInt();
	 		int command = arr.ReadInt();
	//         logger.info("magic type={},area={}", type, area);
	         // 读AMF3字节流的内容
	         Object message =null;
	         if(arr.readnable()){
	        	 byte[] bs=arr.ReadBytes();
	        	 try {
					message= AceCode.Code.aceDecode(bs);
				} catch (Exception e) {
					e.printStackTrace();
				}
	         }
	         frame=null;
			@SuppressWarnings({ "rawtypes", "unchecked" })
			SocketModel model = new SocketModel(type, area, command, message);
	         return model;
		}
	 }