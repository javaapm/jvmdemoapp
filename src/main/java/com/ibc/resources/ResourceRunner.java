package com.ibc.resources;

import com.ibc.resources.*;

public class ResourceRunner extends Thread
{
	public ResourceRunner()
	{
		this.setName("ResourceRunner");
		this.start();
	}

	public void run()
	{
		ResourceDataOne resDataOne = new ResourceDataOne();
		
		
		
		
		
		
		
		
		ResourceDataTwo resDataTwo = new ResourceDataTwo();
		while(true)
		{
			try
			{
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
