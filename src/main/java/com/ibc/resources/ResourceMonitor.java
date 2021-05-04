package com.ibc.resources;

public class ResourceMonitor
{
	final Object resource1="resource1";
	final Object resource2="resource2";


	public ResourceMonitor() 
	{
		
	}


	public void lockFirstResource()
	{
		synchronized (resource1) 
		{
			try 
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			lockSecondResource();
		}
	}


















	
	public void lockSecondResource()
	{
		synchronized (resource2) 
		{
			try 
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			lockFirstResource();
		}
	}
}
