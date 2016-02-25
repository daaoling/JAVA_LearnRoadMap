package org.ace.event;

import java.util.concurrent.Delayed;

public interface IEvent<T> extends Delayed
{
	public static final long DELAY_TIME = 10000000000L;

	public String getType();

	public T getMessage();
}
