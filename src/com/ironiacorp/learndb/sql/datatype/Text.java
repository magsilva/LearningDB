package com.ironiacorp.learndb.sql.datatype;

public class Text extends AbstractBlob
{
	private int i = 2;
	
	public Text()
	{
		maxLength = 2^(8 * i);	
	}
	
	public int getSize()
	{
		return length + i;
	}
}
