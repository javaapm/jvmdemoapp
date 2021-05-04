package com.demo.jvm.eg.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ibc.connectionPooling.DatabaseConnectorThread;
import com.ibc.connectionPooling.DbConnection;
import com.ibc.objectPooling.ObjectManager;

@Service
public class BlockedThreadService implements JvmService {
	
	private boolean running = false;
	
	@Override
	public void start() {
		ObjectManager.last = false;
		DbConnection.finish1 = false;
		ObjectManager db1 = new ObjectManager();
		try
		{
			Thread.sleep(2000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		DatabaseConnectorThread db = new DatabaseConnectorThread();
		System.out.println("INFO : "+new java.util.Date() +" : Started BLOCKED demo ...");
		this.running = true;
	}

	@Override
	public void stop() {
		ObjectManager.last = true;
		DbConnection.finish1 = true;
		System.out.println("INFO : "+new java.util.Date() +" : Stopped BLOCKED demo ... ");
		this.running = false;
	}

	@Override
	public String getName() {
		return "Blocked";
	}
	
	@Override
	public boolean isRunning() {
		return this.running;
	}

	@Override
	public void updateStatus(HashMap<String, String> statusMap) {
		if(this.running) {
			statusMap.put("blockedStatus", "newstatus");
			statusMap.put("blockedStopDisabled", "");
			statusMap.put("blockedStartDisabled", "disabled");
		}
		else {
			statusMap.put("blockedStatus", "newnotrunning2");
			statusMap.put("blockedStopDisabled", "disabled");
			statusMap.put("blockedStartDisabled", "");
		}
	}
}
