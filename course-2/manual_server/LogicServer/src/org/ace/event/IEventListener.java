package org.ace.event;

import java.util.EventListener;

public interface IEventListener<T> extends EventListener
{
	public void handle(IEvent<T> event);
}
