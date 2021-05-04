package com.ibc.resources;

import com.ibc.resources.*;

public class ResourceDataOne extends Thread
{

	public ResourceDataOne()
	{
		this.setName("ResourceDataOne");
		
		
		
		
		
		
		this.start();
	}













	public void run()
	{
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY + 2);
















		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ResourceMonitor rm = new ResourceMonitor();
		rm.lockFirstResource();
	}
}
