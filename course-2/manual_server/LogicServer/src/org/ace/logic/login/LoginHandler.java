package org.ace.logic.login;

import java.util.HashMap;
import java.util.Map;

import org.ace.endingCode.SocketModel;
import org.ace.logic.IHandlerServ;
import org.ace.logic.IoHandler;
import org.jboss.netty.channel.Channel;

public abstract class LoginHandler implements IoHandler {
	private Map<Integer, IHandlerServ> map=new HashMap<Integer, IHandlerServ>();
	
	public void init(){
		for (int i = 0; i < 10; i++) {
			map.put(i, createLoginHandlerImpl());
		}
	}
	
	@Override
	public void messageReceived(Channel channel, SocketModel message) {
		

	}

	@Override
	public void channelClose(Channel channel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onShake(Channel channel) {
		// TODO Auto-generated method stub

	}
	
	public abstract IHandlerServ createLoginHandlerImpl();

}
