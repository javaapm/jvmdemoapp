package com.ibc.object;

public class ObjectHandler extends Thread
{

	private IbcBusinessObject bs = new IbcBusinessObject();

	public ObjectHandler()
	{
		this.setName("ObjectHandler");
	}






















































































































































































































	public void run() 
	{
		bs.getIbcBusinessObject();
	}
}