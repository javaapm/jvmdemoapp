package com.demo.jvm.eg.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ibc.object.GarbageCollectionMemoryLeak;

@Service
public class SlowMemoryLeakService implements JvmService{

	private boolean running = false;
	
	@Override
	public void start() {
		GarbageCollectionMemoryLeak gc = new GarbageCollectionMemoryLeak();
		gc.start();
		this.running = true;
	}

	@Override
	public void stop() {
		GarbageCollectionMemoryLeak.shutDown();
		this.running = false;
	}

	@Override
	public String getName() {
		return "MemLeak";
	}

	@Override
	public boolean isRunning() {
		return this.running ;
	}
	
	@Override
	public void updateStatus(HashMap<String, String> statusMap) {
		if(this.running) {
			statusMap.put("memLeakGcStatus", "newstatus");
			statusMap.put("memLeakGcStopDisabled", "");
			statusMap.put("memLeakGcStartDisabled", "disabled");
		}
		else {
			statusMap.put("memLeakGcStatus", "newnotrunning2");
			statusMap.put("memLeakGcStopDisabled", "disabled");
			statusMap.put("memLeakGcStartDisabled", "");
		}
	}
}
