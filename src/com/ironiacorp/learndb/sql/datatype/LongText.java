package com.ironiacorp.learndb.sql.datatype;

public class LongText extends AbstractBlob
{
	private int i = 4;
	
	public LongText()
	{
		maxLength = 2^(8 * i);	
	}
	
	public int getSize()
	{
		return length + i;
	}
}
