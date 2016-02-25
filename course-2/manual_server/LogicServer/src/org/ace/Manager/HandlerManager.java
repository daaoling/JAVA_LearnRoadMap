package org.ace.Manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.ace.Manager.interfaces.IHandlerManager;
import org.ace.logic.IHandlerServ;

public class HandlerManager implements IHandlerManager {
	private Map<Integer,IHandlerServ> handlers=new ConcurrentHashMap<Integer, IHandlerServ>();
	@Override
	public int register(int area, IHandlerServ handler) {
		handler.setArea(area);
		handlers.put(area, handler);
		return area;
	}

	@Override
	public void unregister(int area) {
		handlers.remove(area);
	}

	@Override
	public boolean hasServ(int area) {
		return handlers.containsKey(area);
	}

	@Override
	public IHandlerServ get(int area) {
		
		return handlers.get(area);
	}

}
