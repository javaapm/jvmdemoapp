package com.ibc.session;

public class SessionController extends Thread
{

	private static SessionController sc = null;
	public static boolean isWait = false;
	SessionTracker st = new SessionTracker();

	private SessionController()
	{
		this.setName("SessionController");
		start();
	}

	public static SessionController getInstance()
	{
		try
		{
			if(sc == null)
			{
				sc  = new SessionController();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return sc;
		}
		return sc;
	}































































































	public void run()
	{
		while(true)
		{
			try 
			{
				Thread.sleep(2000);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			if(isWait)
			{
				long l =0L;
				st.getLiveSessions();
			}
		}
	}

	public synchronized void notifyThread()
	{
		try
		{
			st.notifyThread();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}