package org.ace.Manager.interfaces;

import org.ace.logic.IHandlerServ;

public interface IHandlerManager {
	public int register(int area,IHandlerServ handler);
	public void unregister(int area);
	public boolean hasServ(int area);
	public IHandlerServ get(int area);
}
