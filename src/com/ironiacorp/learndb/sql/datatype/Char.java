package com.ironiacorp.learndb.sql.datatype;

public class Char implements DataType
{
	private int length;
	
	public Char()
	{
		length = 1;
	}
	
	public Char(int length)
	{
		if (length > 255) {
			throw new IllegalArgumentException();
		}
		this.length = length;
	}
	
	public int getSize()
	{
		return length;
	}

}
