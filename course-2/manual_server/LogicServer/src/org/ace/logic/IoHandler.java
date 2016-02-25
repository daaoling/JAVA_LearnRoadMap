package org.ace.logic;

import org.ace.endingCode.SocketModel;
import org.jboss.netty.channel.Channel;

public interface IoHandler {
	@SuppressWarnings("rawtypes")
	public void messageReceived(Channel channel,SocketModel message);
	
	public void channelClose(Channel channel);
	
	public void onShake(Channel channel);
}
