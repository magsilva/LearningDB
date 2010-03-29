package com.ironiacorp.learndb.dbms;

import java.util.ArrayList;

public class Table
{
	private int recordDataPointerSize = 6;
	
	private ArrayList<Column> columns;
	
	public Table()
	{
		columns = new ArrayList<Column>();
	}
	
	public void addColumn(Column col)
	{
		columns.add(col);
	}
	
	public int getMaxRows()
	{
		return 0;
	}
	
	/**
	 * Number of bytes necessary to encode the position of any record in the
	 * data file. Whenever a record is deleted, its first byte is set accordingly
	 * and the following bytes are overwritten with the encoded position of
	 * the previously deleted record. This makes the so called "delete link".
	 * The number of bytes overwritten is the data file pointer size. See
	 * also the myisam_data_pointer_size system variable.
	 * 
	 * @return
	 */
	public int getRecordDataPointerSize()
	{
		return recordDataPointerSize;
	}
	
	public int getMaxSize()
	{
		return (2^48) * recordDataPointerSize;
	}

	public int getColumnCount()
	{
		return columns.size();
	}

	public Column[] getColumns()
	{
		return columns.toArray(new Column[0]);
	}

	public int getRowCount()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean hasIndexFor(Column c)
	{
		// TODO Auto-generated method stub
		return false;
	}
}
