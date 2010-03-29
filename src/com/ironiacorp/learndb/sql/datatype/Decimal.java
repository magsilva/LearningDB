package com.ironiacorp.learndb.sql.datatype;

public class Decimal implements DataType
{

	private int integerPartPrecision;
	
	private int fractionalPartPrecision;
	
	public Decimal(int integerPartPrecision, int fractionalPartPrecision)
	{
		this.integerPartPrecision = integerPartPrecision;
		this.fractionalPartPrecision = fractionalPartPrecision;
	}
	
	public int getSize()
	{
		int totalSize = 0;
		int fractionalSize = 0;
		int integerSize = 0;
		
		// MySQL >= 5.0.3
		integerSize = (integerPartPrecision / 9) * 4;
		integerSize += (integerPartPrecision % 9) / 2;
		integerSize += integerPartPrecision % 2;

		fractionalSize = (fractionalPartPrecision / 9) * 4;
		fractionalSize += (fractionalPartPrecision % 9) / 2;
		fractionalSize += fractionalPartPrecision % 2;
				
		totalSize = integerSize + fractionalSize;
		
		
		// MySQL < 5.0.3
		if (fractionalPartPrecision > 0) {
			totalSize = integerPartPrecision + 2;
		} else if (fractionalPartPrecision == 0) {
			totalSize = integerPartPrecision + 1;
		} else if (integerPartPrecision < fractionalPartPrecision) {
			totalSize = fractionalPartPrecision + 2;
		}
		
		return totalSize;
	}

}
