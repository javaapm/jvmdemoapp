package com.demo.jvm.eg.service;

import java.util.HashMap;

public interface JvmService {

	public void start();
	public void stop();
	public String getName();
	public void updateStatus(HashMap<String,String> statusMap);
	public boolean isRunning();
}
