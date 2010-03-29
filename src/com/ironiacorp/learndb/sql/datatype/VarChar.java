package com.ironiacorp.learndb.sql.datatype;

public class VarChar implements DataType
{
	private int maxLength;
	
	private int length;
	
	public VarChar()
	{
		maxLength = 1;
	}
	
	public VarChar(int maxLength)
	{
		if (maxLength > 255) { // 65535 no MySQL 5.0.3
			throw new IllegalArgumentException();
		}
		this.maxLength = maxLength;
	}
	
	public int getSize()
	{
		if (maxLength <= 255) {
			return length + 1;
		} else {
			return length + 2;
		}
	}
	
	public void setLength(int length)
	{
		if (length > maxLength) {
			throw new IllegalArgumentException();
		}
		
		this.length = length;
	}
}
