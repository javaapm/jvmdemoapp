package com.ibc.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ObjectContainer
{
	public static boolean finish2 = false;
	static ArrayList globalList = new ArrayList();











































































































	public void getClonedObject()
	{
		while (!finish2)
		{
			ArrayList a = new ArrayList();
			for(int i=0;i<100000;i++)
			{
				for (int j = 0; j < 100; j++) {
					SapBusinessObject sbo = new SapBusinessObject("java",i);
					a.add(sbo);
					globalList.add(sbo);
				}
				try {
					Thread.sleep(1);
				} catch (Exception e) {
				}
			}
			try
			{
				Thread.currentThread().sleep(10000);
				if(globalList.size() > 150 * 20000)
					globalList.clear();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		globalList.clear();
	}

}
