package com.demo.jvm.eg.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ibc.object.ObjectContainer;
import com.ibc.object.ObjectHandler;


@Service
public class MemoryLeakService implements JvmService{

	private boolean running = false;
	
	@Override
	public void start() {
		ObjectContainer.finish2 = false;
		ObjectHandler oh = new ObjectHandler();
		oh.start();
		this.running = true;
		System.out.println("INFO : "+new java.util.Date() +" : Started Memory Leak demo ...");
	}

	@Override
	public void stop() {
		ObjectContainer.finish2 = true;
		System.out.println("INFO : "+new java.util.Date() +" : Stopped Memory Leak demo ...");
		this.running = false;
	}

	@Override
	public String getName() {
		return "MemoryLeak";
	}

	@Override
	public void updateStatus(HashMap<String, String> statusMap) {
		if(this.running) {
			statusMap.put("memoryLeakStatus", "newstatus");
			statusMap.put("memoryLeakStopDisabled", "");
			statusMap.put("memoryLeakStartDisabled", "disabled");
		}
		else {
			statusMap.put("memoryLeakStatus", "newnotrunning2");
			statusMap.put("memoryLeakStopDisabled", "disabled");
			statusMap.put("memoryLeakStartDisabled", "");
		}
	}

	@Override
	public boolean isRunning() {
		return this.running;
	}

}
