package com.ibc.connectionPooling;

import com.ibc.objectPooling.*;
import java.util.Date;

public class DbConnection
{
	public static boolean finish1 = false;

	public static String sync = "test";















































































































	public void getConnection()
	{
		synchronized (sync)
		{
			long l = 0L;
			while (!finish1)
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
