/*
 * 2011-8-22 o≧﹏≦o Powered by EXvision
 */

package org.ace.endingCode;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.jboss.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import AceCode.ByteArray;

/**
 * 抗粘包解码器[4-length][bytes]<br>
 * 注意 这个必须是多例
 * 
 * <pre>
 * MESSAGE FORMAT
 * ==============
 * 
 * Offset:  0        4                   (Length + 4)
 *          +--------+------------------------+
 * Fields:  | Length | Actual message content |
 *          +--------+------------------------+
 * 
 * DECODER IMPLEMENTATION
 * ======================
 * </pre>
 * 
 * @author EXvision
 * @since 2011-8-22
 */
public class LengthFieldDecoder extends FrameDecoder
{
	 public static final Logger logger = LoggerFactory
     .getLogger(AMF3NettyDecoder.class);
	private static final int PACKAGE_MAX = 128 * 1024;

	private int packageMax;

	public LengthFieldDecoder()
	{
		this(PACKAGE_MAX);
	}

	public LengthFieldDecoder(int packageMax)
	{
		super();
		this.packageMax = packageMax;
	}

	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel,
			ChannelBuffer buffer) throws Exception
	{
		// Make sure if the length field was received.
		if (buffer.readableBytes() < 8)
		{
			return null;
		}
		buffer.markReaderIndex();

		// Read the length field.
		byte[] bs=buffer.readBytes(8).array();
		
		int length = new ByteArray(bs).ReadInt();

		// 效验长度最小值与最大值
		if (length >= packageMax || length <= 0)
		{
			String dump = buffer.toString(CharsetUtil.UTF_8);
			logger.info("Illegal package size :["
					+ length + "]! Package limit to [0-" + packageMax
					+ "]. DUMP: [" + dump + "] " + channel);
//
//			throw new IllegalPackageException("Illegal package size :["
//					+ length + "]! Package limit to [0-" + packageMax
//					+ "]. DUMP: [" + dump + "] " + channel);
		}
		// 效验长度最小值与最大值 END

		if (buffer.readableBytes() < length)
		{
			buffer.resetReaderIndex();

			return null;
		}

		// There's enough bytes in the buffer. Read it.
		ChannelBuffer frame = buffer.readBytes(length);

		// Successfully decoded a frame. Return the decoded frame.
		return frame;

	}
}
