package org.ace.logic;

import org.ace.endingCode.SocketModel;
import org.jboss.netty.channel.Channel;

public interface IHandlerServ {
	public void setArea(int area);
	public void Colse(Channel channel);
	@SuppressWarnings("rawtypes")
	public void messageReceived(Channel channel, SocketModel message);
}
