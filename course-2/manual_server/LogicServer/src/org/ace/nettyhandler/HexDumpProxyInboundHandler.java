package org.ace.nettyhandler;


import org.ace.endingCode.SocketModel;
import org.ace.logic.LogicHandler;
import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;



public class HexDumpProxyInboundHandler extends SimpleChannelUpstreamHandler {
	
	private Logger logger=Logger.getLogger(getClass());
	private LogicHandler logic;

	public LogicHandler getLogic() {
		return logic;
	}
	
	public void setLogic(LogicHandler logic) {
		this.logic = logic;
	}
	
	@Override
	public void handleUpstream(ChannelHandlerContext ctx, ChannelEvent e)
			throws Exception {
//		if (e instanceof ChannelStateEvent) {
//			System.out.println(e.toString());
//			if(((ChannelStateEvent) e).getState().name()=="OPEN" && (Boolean)((ChannelStateEvent) e).getValue()==false){
//				logger.debug("channel close:"+e.getChannel());
//				logic.channelClose(e.getChannel());
//			}
//		}
		super.handleUpstream(ctx, e);
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		logger.debug("用户连接");
//		SocketModel model=new SocketModel();
//		model.setType(Protocol.TYPE_LOGIN);
//		model.setCommand(LoginProtocol.login_init);
//		e.getChannel().write(model);
	}

	@SuppressWarnings({ "rawtypes"})
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
		SocketModel message=(SocketModel)e.getMessage();
		logic.messageReceived(e.getChannel(), message);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
//		logger.debug("channel close:"+e.getChannel());
//		logic.channelClose(e.getChannel());
		e.getChannel().close();
	}
	
	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e){
		logger.debug("channel close:"+e.getChannel());
		logic.channelClose(e.getChannel());
	}

}
