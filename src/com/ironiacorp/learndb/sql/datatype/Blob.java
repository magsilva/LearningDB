package com.ironiacorp.learndb.sql.datatype;

public class Blob extends AbstractBlob
{
	private int i = 2;
	
	public Blob()
	{
		maxLength = 2^(8 * i);	
	}
	
	public int getSize()
	{
		return length + i;
	}
}
