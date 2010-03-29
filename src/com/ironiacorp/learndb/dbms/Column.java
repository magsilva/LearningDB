package com.ironiacorp.learndb.dbms;

import com.ironiacorp.learndb.sql.datatype.DataType;

public class Column
{
	private DataType type;
	
	private String name;
	
	public Column(String name, DataType type)
	{
		this.name = name;
		this.type = type;
	}
	
	public int getSize()
	{
		return type.getSize();
	}

}
