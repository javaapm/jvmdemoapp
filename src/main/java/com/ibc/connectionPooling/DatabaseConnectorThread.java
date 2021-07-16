package com.ibc.connectionPooling;


import java.util.Date;

public class DatabaseConnectorThread extends Thread
{

	public DatabaseConnectorThread()
	{
		this.setName("DatabaseConnectorThread");
		start();
	}

































































































	public void run ()
	{
		PoolManager pm = new PoolManager();
		pm.getConnectionPool();
	}

}
