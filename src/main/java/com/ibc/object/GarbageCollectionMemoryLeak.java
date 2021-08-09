package com.ibc.object;

import java.util.*;

public class GarbageCollectionMemoryLeak extends Thread {
	
	private static volatile boolean terminate = false;

	public static final ArrayList all = new ArrayList();
	
	public GarbageCollectionMemoryLeak() {
		terminate = false;
	}
	
	public static void shutDown() {
		terminate = true;
	}

	public void run(){
			int min = 32;
			Object[] arr = new Object[min];
			Runtime rt = Runtime.getRuntime();
			long shortCounter = 0;
			long longCounter = 0;
			//System.out.println("Step/TotalMemory/FreeMemory/UsedMemory:");
			while(!terminate) {
				
				if(this.isInterrupted() || terminate) {
					break;
				}
				try {
					for (int n=0; n<min-1; n++) {
						arr[min-n-1] = arr[min-n-2];
					}
					 arr[0] = getOneMega();
					 long total = rt.totalMemory();
					 long free = rt.freeMemory();
					 //System.out.println(total+"   "+free+"   "
						//+(total-free));
					 /*try {
						//Thread.sleep(1000);
					 } catch (InterruptedException e) {
						System.out.println("Interreupted...");
					 }*/
					 if(shortCounter == 1000){
						String[] l = new String[64*64]; // 1/16 MB
						for (int i=0; i<64*64; i++) 
							l[i] = new String("12345678"); // 16B
						all.add(l);
						String [] l1 = l.clone();
						all.add(l1);

					 }

					 if(shortCounter >= 1000 && longCounter <=100000)
					{
						shortCounter = 0;
						//rt.gc();
					}
					 if(false) {
						 Thread.sleep(100);  
					 }

					 if(shortCounter > 1000)
						 shortCounter = 0;
				}
				catch(InterruptedException ie) {
					System.out.println("IT is Interrupted !!!!");
					break;
				}
				catch(Exception e) {
					
				}
				shortCounter++;
				longCounter++;
			}
		}

	private static Object getOneMega() 
	{
		Object[] lst = new Object[10];
		lst[0] = new long[256*128]; // 1/4 MB
		lst[1] = new int[256*256]; // 1/4 MB
		lst[2] = new double[256*128]; // 1/4 MB
		//lst[3] = new float[64*256]; // 1/16 MB
		//lst[4] = new byte[64*1024]; // 1/16 MB
		//String[] l = new String[64*64]; // 1/16 MB
		//for (int i=0; i<64*64; i++) 
			 //l[i] = new String("12345678"); // 16B
		//lst[5] = l;
		//lst[6] = new char[64*512]; // 1/16 MB
		//System.gc();
		return lst;
	}

	public static void main(String[] ar){
		
		try {
			Thread.sleep(30 * 1000L);
		}
		catch(Exception e) {}
		GarbageCollectionMemoryLeak gc = new GarbageCollectionMemoryLeak();
		gc.start();

		GarbageCollectionMemoryLeak gc1 = new GarbageCollectionMemoryLeak();
		gc1.start();
		
		try {
			Thread.sleep(60 * 1000L);
			gc.interrupt();
		}
		catch(Exception e) {}
		
		
		try {
			Thread.sleep(30 * 1000L);
			gc1.interrupt();
		}
		catch(Exception e) {}
	}
}