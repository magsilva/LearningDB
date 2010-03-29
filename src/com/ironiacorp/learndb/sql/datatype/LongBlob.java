package com.ironiacorp.learndb.sql.datatype;

public class LongBlob extends AbstractBlob
{
	private int i = 4;
	
	public LongBlob()
	{
		maxLength = 2^(8 * i);	
	}
	
	public int getSize()
	{
		return length + i;
	}
}
