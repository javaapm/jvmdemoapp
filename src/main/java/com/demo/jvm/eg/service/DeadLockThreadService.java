package com.demo.jvm.eg.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ibc.resources.ResourceRunner;

@Service
public class DeadLockThreadService implements JvmService {

	private boolean running = false;
	
	@Override
	public void start() {
		System.out.println("INFO : "+new java.util.Date() +" : DeadLock can't be stopped, once started...");
		ResourceRunner rr = new ResourceRunner();
		this.running = true;
	}

	@Override
	public void stop() {
		//this.running = false;
		//Deadlock Cannn't be Stopped..............
		System.out.println("INFO : "+new java.util.Date() +" : DeadLock can't be stopped ...");
	}
	
	@Override
	public String getName() {
		return "Deadlock";
	}
	
	@Override
	public boolean isRunning() {
		return this.running;
	}
	
	@Override
	public void updateStatus(HashMap<String, String> statusMap) {
		if(this.running) {
			statusMap.put("deadlockStatus", "newstatus");
			statusMap.put("deadlockStartDisabled", "disabled");
			statusMap.put("deadlockStopDisabled", "disabled");
		}
		else {
			statusMap.put("deadlockStatus", "newnotrunning2");
			statusMap.put("deadlockStartDisabled", "");
			statusMap.put("deadlockStopDisabled", "disabled");
		}
	}
	
}
