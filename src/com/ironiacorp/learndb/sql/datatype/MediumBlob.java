package com.ironiacorp.learndb.sql.datatype;

public class MediumBlob extends AbstractBlob
{
	private int i = 3;
	
	public MediumBlob()
	{
		maxLength = 2^(8 * i);	
	}
	
	public int getSize()
	{
		return length + i;
	}
}
