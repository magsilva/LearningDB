package com.ironiacorp.learndb.dbms.mysql.storageengine;

import com.ironiacorp.learndb.dbms.Column;
import com.ironiacorp.learndb.dbms.Table;


// myisamchk -dvvvv $DATADIR/db/table.MYI
public class MyISAM
{
	public static final int INDEX_PAGE_SIZE = 1024;
	
	public static final int DATA_PAGE_SIZE = 4096;
	
	public static final int DATA_POINTER_SIZE = 4;
	
	
	public int getMinRecordSize(Table t)
	{
		return t.getRecordDataPointerSize() + 1; 	
	}
	
	public int getMaxRowLength(Table t)
	{
		return 0;
	}
	
	public int getAverageRowLength(Table t)
	{
		return 0;
	}
	
	public int getAccessCost(Table t, Column c)
	{
		int cost = 0;
		
		if (t.hasIndexFor(c)) {
			double indexBufferFillRatio = 2 / 3;
			cost = (int)Math.ceil((Math.log(t.getRowCount()) / Math.log((INDEX_PAGE_SIZE * indexBufferFillRatio) / (c.getSize() + DATA_POINTER_SIZE))) + 1);
		} else {
			cost = t.getRowCount();
		}
		return  cost;
	}
	
	/**
	 * MyISAM tables use B-tree indexes. You can roughly calculate the size for the
	 * index file as (key_length+4)/0.67, summed over all keys. This is for the
	 * worst case when all keys are inserted in sorted order and the table
	 * doesn't have any compressed keys. 
	 */
	public int getIndexSize(Table t)
	{
		int totalSize = 0;
		// foreach (t.getKeys() : Key key)
		// totalSize += (key_length+4)/0.67
		
		return totalSize;
	}
}
