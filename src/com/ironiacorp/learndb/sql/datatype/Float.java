package com.ironiacorp.learndb.sql.datatype;

public class Float implements DataType
{
	private int precision;
	
	public Float()
	{
		this.precision = 24;
	}
	
	public Float(int precision)
	{
		this.precision = precision;
	}
	
	public int getSize()
	{
		if (precision <= 24) {
			return 4;
		} else if (precision <= 53) {
			return 8;
		} else {
			return 4;
		}
	}

}
