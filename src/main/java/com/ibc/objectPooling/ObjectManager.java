package com.ibc.objectPooling;

import com.ibc.connectionPooling.*;
import java.util.Date;

public class ObjectManager extends Thread
{
	public static boolean last = false;
	public static String mysync = "test";
	public ObjectManager()
	{
		this.setName("ObjectManagerThread");
		start();
	}


	public void run ()
	{
		synchronized (mysync)
		{
			long l = 0L;
			while (!last)
			{
				try
				{
					Thread.sleep(3600);
				}
				catch (Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		}
	}

}
