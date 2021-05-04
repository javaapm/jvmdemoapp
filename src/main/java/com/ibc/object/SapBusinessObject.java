package com.ibc.object;

public class SapBusinessObject
{
	private String thisString;
	private long thisNo;




























	SapBusinessObject(String thisString , long thisNo)
	{
		this.thisString = thisString;
		this.thisNo=thisNo;
	}

	public String getThisString() {
		return thisString;
	}

	public void setThisString(String thisString) {
		this.thisString = thisString;
	}

	public long getThisNo() {
		return thisNo;
	}

	public void setThisNo(int thisNo) {
		this.thisNo = thisNo;
	}
	
	
}