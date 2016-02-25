/*
 * 2011-3-8 o≧﹏≦o Powered by EXvision
 */

package org.ace.endingCode;

import java.io.Serializable;

public class SocketModel<T> implements Serializable
{
	private static final long serialVersionUID = 4263772933241543089L;

	private int type;// 类别 id
	private int area;// 区域id
	private int command;// 指令
	private T message;// 序列化对象

	public SocketModel()
	{
		super();
	}

	public SocketModel(int type, int area, int command)
	{
		super();
		setType(type);
		setArea(area);
		setCommand(command);
	}

	public SocketModel(int type, int area, int command, T message)
	{
		super();
		setType(type);
		setArea(area);
		setCommand(command);
		setMessage(message);
	}

	/**
	 * @return the type
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * @return the area
	 */
	public int getArea()
	{
		return area;
	}

	/**
	 * @param area
	 *            the area to set
	 */
	public void setArea(int area)
	{
		this.area = area;
	}

	/**
	 * @return the command
	 */
	public int getCommand()
	{
		return command;
	}

	/**
	 * @param command
	 *            the command to set
	 */
	public void setCommand(int command)
	{
		this.command = command;
	}

	/**
	 * @return the message
	 */
	public T getMessage()
	{
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(T message)
	{
		this.message = message;
	}


	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "SocketModel [type=" + type + ", area="
				+ area + ", command=" + command + ", message=" + message + "]";
	}

}
