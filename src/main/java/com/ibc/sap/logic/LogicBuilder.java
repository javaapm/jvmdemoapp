package com.ibc.sap.logic;

public class LogicBuilder
{

	public static boolean finish = false;














































































































































































































	public void createLogic()
	{
		long count = 0L;
		while(!finish)
		{
			try
			{
				if(count > 999999999)
				{
					count = 0;
					Thread.sleep(10);
				}
				count ++;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
