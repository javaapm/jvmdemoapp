package com.demo.jvm.eg.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ibc.session.SessionController;

@Service
public class WaitedThreadService implements JvmService {

	private boolean running = false;
	
	@Override
	public void start() {
		SessionController sc = SessionController.getInstance();
		SessionController.isWait = true;
		//sc.startThread();
		System.out.println("INFO : "+new java.util.Date() +" : Started WAITED demo ...");
		this.running = true;
	}

	@Override
	public void stop() {
		SessionController sc = SessionController.getInstance();
		SessionController.isWait = false;
		sc.notifyThread();
		System.out.println("INFO : "+new java.util.Date() +" : Stopped WAITED demo ... ");
		this.running = false;

	}

	@Override
	public String getName() {
		return "Waited";
	}

	@Override
	public boolean isRunning() {
		return this.running ;
	}
	
	@Override
	public void updateStatus(HashMap<String, String> statusMap) {
		if(this.running) {
			statusMap.put("waitedStatus", "newstatus");
			statusMap.put("waitedStopDisabled", "");
			statusMap.put("waitedStartDisabled", "disabled");
		}
		else {
			statusMap.put("waitedStatus", "newnotrunning2");
			statusMap.put("waitedStopDisabled", "disabled");
			statusMap.put("waitedStartDisabled", "");
		}
	}

}
