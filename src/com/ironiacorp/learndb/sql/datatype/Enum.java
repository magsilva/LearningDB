package com.ironiacorp.learndb.sql.datatype;

public class Enum implements DataType
{
	private int totalMembers;
	
	public Enum(int totalMembers)
	{
		if (totalMembers > 65535) {
			throw new IllegalArgumentException();
		}
		this.totalMembers = totalMembers;
	}
	
	public int getSize()
	{
		for (int i = 1; i < 3; i++) {
			int membersPerByte = 2^(8 * i);
			if (totalMembers < membersPerByte) {
				return i;
			}
		}
		
		throw new RuntimeException(); // Actually, this should be caught by the constructor.
	}

}
