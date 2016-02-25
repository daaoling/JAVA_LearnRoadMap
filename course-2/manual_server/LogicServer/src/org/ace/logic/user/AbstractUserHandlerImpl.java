package org.ace.logic.user;


import org.ace.endingCode.SocketModel;
import org.ace.protocol.Protocol;
import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;

public abstract class AbstractUserHandlerImpl {
	
	public Logger logger=Logger.getLogger(getClass());
//	private int type;

//	@Resource(name="playerBiz")
//	private IPlayerBiz playerBiz;
	
	private int area;

	public int getType() {
		return Protocol.TYPE_USER;
	}

//	public void setType(int type) {
//		this.type = type;
//	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	
//	public Integer getUserId(Channel channel){
//		return playerBiz.getUserId(channel);
//	}

	@SuppressWarnings("rawtypes")
	public void messageReceived(Channel channel, SocketModel message) {
		process(channel, message);
	}

	@SuppressWarnings("rawtypes")
	protected abstract void process(Channel channel, SocketModel message);

//	public void write(Integer userId,int command,Object message){
//		Channel channel= playerBiz.getChannel(userId);
//		if(channel!=null)
////		logger.debug("write type    "+getType()+"    area    "+getArea()+"    command    "+command+"    message    "+message);
//			write(channel, command, message);
//	}
	
	/**
	 * 发送消息给用户
	 * 
	 * @param channel
	 *            用户channel
	 * @param command
	 *            协议
	 * @param message
	 *            消息体
	 */
	public void write(Channel channel, int command, Object message) {
		logger.debug("write type    " + getType() + "    area    " + getArea()
				+ "    command    " + command + "    message    " + message);
		channel.write(createSocketModel(getType(), getArea(), command, message));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SocketModel createSocketModel(int type, int area, int command,
			Object message) {
		SocketModel sm = new SocketModel();
		sm.setType(type);
		sm.setArea(area);
		sm.setCommand(command);
		sm.setMessage(message);
		return sm;
	}
	
	protected void onShake(Channel channel){
		//默认不做任何事情---有操作 自己实现克
	}
}
