package com.ironiacorp.learndb.sql.datatype;

public class TinyText extends AbstractBlob
{
	private int i = 1;
	
	public TinyText()
	{
		maxLength = 2^(8 * i);	
	}
	
	public int getSize()
	{
		return length + i;
	}
}
