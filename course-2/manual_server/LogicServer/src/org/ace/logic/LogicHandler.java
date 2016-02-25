package org.ace.logic;

import javax.annotation.Resource;

import org.ace.endingCode.SocketModel;
import org.ace.event.model.OnShakeEvent;
import org.ace.nettyhandler.HeartBeatHandler;
import org.ace.protocol.Protocol;
import org.ace.tool.impl.ErrorUtil;
import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.springframework.context.ApplicationListener;

public class LogicHandler implements IoHandler,
		ApplicationListener<OnShakeEvent> {
	
	
	private Logger logger = Logger.getLogger(getClass());
	
	private IoHandler login;

	@Resource(name = "heartBeatHandler")
	private HeartBeatHandler heartBeatHandler;

	@Override
	public void onApplicationEvent(OnShakeEvent event) {
		Channel channel = event.getChannel();
//		login.onShake(channel);
//		map.onShake(channel);
//		mission.onShake(channel);
//		user.onShake(channel);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void messageReceived(Channel channel, SocketModel message) {
		try {

			switch (message.getType()) {
			case Protocol.TYPE_LOGIN:
				login.messageReceived(channel, message);
//				if (message.getCommand() == LoginProtocol.LOGIN) {
//					heartBeatHandler.received(channel);
//				}
				break;
			case Protocol.TYPE_MAP:
				
				break;
			case Protocol.TYPE_MISSION:
			
				break;
			case Protocol.TYPE_USER:
			
				break;
			case Protocol.TYPE_HEART_BEAT:
				heartBeatHandler.received(channel);
				break;
			case Protocol.TYPE_RAID:
			
				break;
			}
		} catch (Exception e) {
			logger.error(ErrorUtil.decode(e));
		}

	}

	@Override
	public void channelClose(Channel channel) {
//			raid.channelClose(channel);
//			map.channelClose(channel);
//			mission.channelClose(channel);
//			// 下面三个必须最后调用---因为会清除channel与角色的映射关系
//			login.channelClose(channel);
//			user.channelClose(channel);
			heartBeatHandler.close(channel);
		
	}

	@Override
	public void onShake(Channel channel) {
		// 总逻辑控制 无需监听 --握手由此class派发

	}



	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public HeartBeatHandler getHeartBeatHandler() {
		return heartBeatHandler;
	}

	public void setHeartBeatHandler(HeartBeatHandler heartBeatHandler) {
		this.heartBeatHandler = heartBeatHandler;
	}

	public IoHandler getLogin() {
		return login;
	}

	public void setLogin(IoHandler login) {
		this.login = login;
	}

	
	
}
