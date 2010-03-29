package com.ironiacorp.learndb.sql.datatype;

public class MediumText extends AbstractBlob
{
	private int i = 3;
	
	public MediumText()
	{
		maxLength = 2^(8 * i);	
	}
	
	public int getSize()
	{
		return length + i;
	}
}
