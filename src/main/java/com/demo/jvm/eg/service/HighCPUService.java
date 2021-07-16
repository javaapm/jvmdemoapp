package com.demo.jvm.eg.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.ibc.sap.SapBusinessConnector;
import com.ibc.sap.logic.LogicBuilder;

@Service
public class HighCPUService implements JvmService {

	private boolean running = false;
	
	@Override
	public void start() {
		int numberOfCpu = GetCpuCountDetails.getNumberOfCPUCores();
		LogicBuilder.finish = false;
		int threadCount = 0; 
		if(numberOfCpu == 0) {
			numberOfCpu = Runtime.getRuntime().availableProcessors();
			threadCount = numberOfCpu;
		}else {
			threadCount = (numberOfCpu * 2) - 2;
		}
		for (int i = 0; i < threadCount; i++) {
			SapBusinessConnector sap = new SapBusinessConnector();
		}
		System.out.println("INFO : "+new java.util.Date() +" : Started CPU demo ...");
		this.running = true;
	}

	@Override
	public void stop() {
		LogicBuilder.finish = true;
		System.out.println("INFO : "+new java.util.Date() +" : Stopped CPU demo ... ");
		this.running = false;
	}
	
	@Override
	public String getName() {
		return "HighCPU";
	}
	
	@Override
	public boolean isRunning() {
		return this.running;
	}
	
	@Override
	public void updateStatus(HashMap<String, String> statusMap) {
		if(this.running) {
			statusMap.put("highcpuStatus", "newstatus");
			statusMap.put("highcpuStopDisabled", "");
			statusMap.put("highcpuStartDisabled", "disabled");
		}
		else {
			statusMap.put("highcpuStatus", "newnotrunning2");
			statusMap.put("highcpuStopDisabled", "disabled");
			statusMap.put("highcpuStartDisabled", "");
		}
	}
}
