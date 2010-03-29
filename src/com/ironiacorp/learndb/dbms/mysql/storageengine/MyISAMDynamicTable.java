package com.ironiacorp.learndb.dbms.mysql.storageengine;

/**
 * Dynamic format is a little more complex than static format because each row
 * has a header that indicates how long it is. A row can become fragmented
 * (stored in non-contiguous pieces) when it is made longer as a result of an update.
 * 
 * Each row is preceded by a bitmap that indicates which columns contain the empty
 * string (for string columns) or zero (for numeric columns). Note that this does
 * not include columns that contain NULL values. If a string column has a length
 * of zero after trailing space removal, or a numeric column has a value of zero,
 * it is marked in the bitmap and not saved to disk. Non-empty strings are saved
 * as a length byte plus the string contents.
 * 
 *  The expected row length for dynamic-sized rows is calculated using the
 *  following expression:
 *  
 *  3
 *  + (number of columns + 7) / 8
 *  + (number of char columns)
 *  + (packed size of numeric columns)
 *  + (length of strings)
 *  + (number of NULL columns + 7) / 8
 *  
 *  There is a penalty of 6 bytes for each link. A dynamic row is linked whenever
 *  an update causes an enlargement of the row. Each new link is at least
 *  20 bytes, so the next enlargement probably goes in the same link. If not,
 *  another link is created. 
 */
public class MyISAMDynamicTable
{

}
