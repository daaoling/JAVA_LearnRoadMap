package org.ace.nettyhandler;


import org.ace.endingCode.AMF3NettyDecoder;
import org.ace.endingCode.AMF3NettyEncoder;
import org.ace.endingCode.LengthFieldDecoder;
import org.ace.endingCode.LengthFieldEncoder;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;



public abstract class HexDumpProxyPipelineFactory implements
		ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline pipeline = Channels.pipeline(); // Note the static import.

		pipeline.addLast("lengthFieldDecoder", new LengthFieldDecoder());
		pipeline.addLast("lengthFieldEncoder", new LengthFieldEncoder());
		
		pipeline.addLast("encoder", new AMF3NettyEncoder());
		pipeline.addLast("decoder", new AMF3NettyDecoder());


		pipeline.addLast("handler", createHexDumpProxyHandler());

		return pipeline;
	}

	public abstract ChannelHandler createHexDumpProxyHandler();

}
