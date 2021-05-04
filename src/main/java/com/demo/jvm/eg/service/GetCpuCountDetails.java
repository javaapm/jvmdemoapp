package com.demo.jvm.eg.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetCpuCountDetails {
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static void main(String[] args) {
		 System.out.println(" Number CPU per Core Logical processor : "+Runtime.getRuntime().availableProcessors());
		 System.out.println(" Number of CPU Cores  : "+getNumberOfCPUCores());
	}
	
	public static int getNumberOfCPUCores() {
	    String command = "";
	    if(isUnix()){
	        command = "lscpu";
	    }else if(isWindows()){
	        command = "cmd /C WMIC CPU Get /Format:List";
	    }
	    Process process = null;
	    int numberOfCores = 0;
	    int sockets = 0;
	    try {
	        process = Runtime.getRuntime().exec(command);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    BufferedReader reader = new BufferedReader(
	            new InputStreamReader(process.getInputStream()));
	    String line;

	    try {
	        while ((line = reader.readLine()) != null) {
	            if (isUnix()) {
	                if (line.contains("Core(s) per socket:")) {
	                    numberOfCores = Integer.parseInt(line.split("\\s+")[line.split("\\s+").length - 1]);
	                }
	                if(line.contains("Socket(s):")){
	                    sockets = Integer.parseInt(line.split("\\s+")[line.split("\\s+").length - 1]);
	                }
	            } else if (isWindows()) {
	                if (line.contains("NumberOfCores")) {
	                    numberOfCores = Integer.parseInt(line.split("=")[1]);
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    if(isUnix()){
	    	if (sockets == 0) {
	    		return numberOfCores;
			}
	        return numberOfCores * sockets;
	    }
	    return numberOfCores;
	}
	
	public static boolean isWindows() {
	    return (OS.indexOf("win") >= 0);
	}

	public static boolean isUnix() {
	    return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
	}
}
 	 
