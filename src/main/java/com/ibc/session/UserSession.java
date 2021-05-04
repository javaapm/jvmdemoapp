package com.ibc.session;

public class UserSession
{
	public void removeSession()
	{












































	

















































































	}
	public void isLiveSession()
	{
		createSession();
	}

	public void trackSession()
	{



































































	}

	public synchronized void createSession()
	{
		try
		{
			//System.out.println("Started to wait ... @ "+new java.util.Date());
			wait();
		}
		catch (InterruptedException e)
		{
			System.out.println("Exiting MainThread...");
		}
	}

	public synchronized void notifyThread()
	{
		try
		{
			notify();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
