package com.demo.jvm.eg.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSourceService implements JvmService{

	private boolean running = false;
	private List<Connection> connectionObjectList = null;
	
	@Autowired
    private DataSource dataSource;
	
	
	@Override
	public void start() {
		try {
			this.running = true;
			System.out.println("INFO : "+new java.util.Date() +" : Started SpringBoot Tomcat Hikari ConnectionPool demo ...");
			if (dataSource != null && connectionObjectList == null) {
				connectionObjectList = new ArrayList<Connection>();
				for (int i = 0; i < 19; i++) {
					connectionObjectList.add(dataSource.getConnection());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() {
		try {
			this.running = false;
			System.out.println("INFO : "+new java.util.Date() +" : Stopped SpringBoot Tomcat Hikari ConnectionPool demo ...");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connectionObjectList != null) {
				for (int i = 0; i < connectionObjectList.size(); i++) {
					try {
						connectionObjectList.get(i).close();
					} catch (Exception e2) {
						connectionObjectList = null;
						e2.printStackTrace();
					}
				}
				connectionObjectList.clear();
				connectionObjectList = null;
			}
		}
	}

	@Override
	public String getName() {
		return "DataSource";
	}

	@Override
	public void updateStatus(HashMap<String, String> statusMap) {
		if(this.running) {
			statusMap.put("dataSourceStatus", "newstatus");
			statusMap.put("dataSourceStopDisabled", "");
			statusMap.put("dataSourceStartDisabled", "disabled");
		}
		else {
			statusMap.put("dataSourceStatus", "newnotrunning2");
			statusMap.put("dataSourceStopDisabled", "disabled");
			statusMap.put("dataSourceStartDisabled", "");
		}
		
	}

	@Override
	public boolean isRunning() {
		return this.running;
	}

}
