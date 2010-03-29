package com.ironiacorp.learndb.sql.datatype;

public class Set implements DataType
{
	private int totalMembers;
	
	public Set(int totalMembers)
	{
		if (totalMembers > 64) {
			throw new IllegalArgumentException();
		}
		this.totalMembers = totalMembers;
	}
	
	public int getSize()
	{
		return (totalMembers / 2) + (totalMembers % 2);
	}

}
