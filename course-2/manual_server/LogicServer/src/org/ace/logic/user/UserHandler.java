package org.ace.logic.user;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.ace.Manager.interfaces.IHandlerManager;
import org.ace.endingCode.SocketModel;
import org.ace.logic.IHandlerServ;
import org.ace.logic.IoHandler;
import org.ace.logic.user.protocol.UserProtocol;
import org.jboss.netty.channel.Channel;

public abstract class UserHandler implements IoHandler {

	private IHandlerManager manager;
	
	@PostConstruct
	void init(){
		manager.register(UserProtocol.AREA_PLAYER, createPlayerHandler());
		manager.register(UserProtocol.AREA_TEAM, createTeamHandler());
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void messageReceived(Channel channel, SocketModel message) {
		manager.get(message.getArea()).messageReceived(channel, message);

	}

	@Override
	public void channelClose(Channel channel) {
		manager.get(UserProtocol.AREA_TEAM).Colse(channel);
		manager.get(UserProtocol.AREA_PLAYER).Colse(channel);
	}
	
	public abstract IHandlerServ createPlayerHandler();
	
	public abstract IHandlerServ createTeamHandler();
//	
//	public abstract IHandlerServ createCoinTreeHandler();
//	
//	public abstract IHandlerServ createCosplayHandler();
	
	@Resource(name="userManager")
	protected void setManager(IHandlerManager manager){
		this.manager=manager;
	}
	
	@Override
	public void onShake(Channel channel) {
		// 
		
	}

}
