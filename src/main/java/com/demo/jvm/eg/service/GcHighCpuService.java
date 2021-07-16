package com.demo.jvm.eg.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ibc.object.GarbageCollection;

@Service
public class GcHighCpuService implements JvmService{

	private boolean running = false;
	
	@Override
	public void start() {
		GarbageCollection gc = new GarbageCollection();
		gc.start();
		this.running = true;
	}

	@Override
	public void stop() {
		GarbageCollection.shutDown();
		this.running = false;
	}

	@Override
	public String getName() {
		return "HighCpuGC";
	}

	@Override
	public boolean isRunning() {
		return this.running ;
	}
	
	@Override
	public void updateStatus(HashMap<String, String> statusMap) {
		if(this.running) {
			statusMap.put("highcpuGcStatus", "newstatus");
			statusMap.put("highcpuGcStopDisabled", "");
			statusMap.put("highcpuGcStartDisabled", "disabled");
		}
		else {
			statusMap.put("highcpuGcStatus", "newnotrunning2");
			statusMap.put("highcpuGcStopDisabled", "disabled");
			statusMap.put("highcpuGcStartDisabled", "");
		}
	}
}
