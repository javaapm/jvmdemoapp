package com.demo.jvm.eg.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.jvm.eg.service.BlockedThreadService;
import com.demo.jvm.eg.service.DataSourceService;
import com.demo.jvm.eg.service.DeadLockThreadService;
import com.demo.jvm.eg.service.GcHighCpuService;
import com.demo.jvm.eg.service.HighCPUService;
import com.demo.jvm.eg.service.MemoryLeakService;
import com.demo.jvm.eg.service.WaitedThreadService;

@RestController
@RequestMapping("/eGJvmDemo")
public class DemoController {
	
	@Autowired
	BlockedThreadService blockedThreadService;
	
	@Autowired
	DeadLockThreadService deadLockThreadService;
	
	@Autowired
	HighCPUService highCPUService;
	
	@Autowired
	WaitedThreadService waitedThreadService;
	
	@Autowired
	GcHighCpuService gcHighCpuService;
	
	@Autowired
	MemoryLeakService memoryLeakService;
	
	@Autowired
	DataSourceService dataSourceService;
	
	@RequestMapping(value= {"","/","/list"},method=RequestMethod.GET)
	public ModelAndView getIndexPage() {
		HashMap <String, String> data = new HashMap<String,String>();
		data.put("heading", "eG JVM Monitoring Demo");
	
		//Running status
		blockedThreadService.updateStatus(data);
		deadLockThreadService.updateStatus(data);
		highCPUService.updateStatus(data);
		waitedThreadService.updateStatus(data);
		gcHighCpuService.updateStatus(data);
		memoryLeakService.updateStatus(data);
		dataSourceService.updateStatus(data);
		return new ModelAndView("welcome","message", data);
	}
	
	 @RequestMapping(value="/blocked/start", method=RequestMethod.GET)
	 public ModelAndView startBlockedDemo() {
		 blockedThreadService.start();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/blocked/stop", method=RequestMethod.GET)
	 public ModelAndView stopBlockedDemo() {
		 blockedThreadService.stop();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	
	 @RequestMapping(value="/cpu/start", method=RequestMethod.GET)
	 public ModelAndView startCPUDemo() {
		 highCPUService.start();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/cpu/stop", method=RequestMethod.GET)
	 public ModelAndView stopCPUDemo() {
		 highCPUService.stop();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/deadlock/start", method=RequestMethod.GET)
	 public ModelAndView startDeadlockDemo() {
		 deadLockThreadService.start();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/deadlock/stop", method=RequestMethod.GET)
	 public ModelAndView stopDeadlockDemo() {
		 deadLockThreadService.stop();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/waited/start", method=RequestMethod.GET)
	 public ModelAndView startWaitedDemo() {
		 waitedThreadService.start();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/waited/stop", method=RequestMethod.GET)
	 public ModelAndView stopWaitedDemo() {
		 waitedThreadService.stop();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/cpugc/start", method=RequestMethod.GET)
	 public ModelAndView startCpuGcDemo() {
		 gcHighCpuService.start();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/cpugc/stop", method=RequestMethod.GET)
	 public ModelAndView stopCpuGcDemo() {
		 gcHighCpuService.stop();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/mleak/start", method=RequestMethod.GET)
	 public ModelAndView startMemoryLeakDemo() {
		 memoryLeakService.start();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/mleak/stop", method=RequestMethod.GET)
	 public ModelAndView stopMemoryLeakDemo() {
		 memoryLeakService.stop();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/dataSource/start", method=RequestMethod.GET)
	 public ModelAndView startDataSourceDemo() {
		 dataSourceService.start();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
	 
	 @RequestMapping(value="/dataSource/stop", method=RequestMethod.GET)
	 public ModelAndView stopDataSourceDemo() {
		 dataSourceService.stop();
		 return new ModelAndView("redirect:/eGJvmDemo/list");
	 }
}
