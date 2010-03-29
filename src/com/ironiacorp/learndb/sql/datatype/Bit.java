package com.ironiacorp.learndb.sql.datatype;

public class Bit implements DataType
{
	private int size;
	
	public Bit(int size)
	{
		this.size = size;
	}
	
	
	public int getSize()
	{
		return (size + 7) / 8;
	}

}
