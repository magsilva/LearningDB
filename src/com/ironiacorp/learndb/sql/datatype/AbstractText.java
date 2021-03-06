package com.ironiacorp.learndb.sql.datatype;

public abstract class AbstractText implements DataType
{
	protected int maxLength;
	
	protected int length;
	
	public void setLength(int length)
	{
		if (length > maxLength) {
			throw new IllegalArgumentException();
		}
		
		this.length = length;
	}
}
