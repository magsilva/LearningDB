package com.ironiacorp.learndb.sql.datatype;

public class TinyBlob extends AbstractBlob
{
	private int i = 1;
	
	public TinyBlob()
	{
		maxLength = 2^(8 * i);	
	}
	
	public int getSize()
	{
		return length + i;
	}
}
