package com.ironiacorp.learndb.dbms.mysql.storageengine;

/**
 * Static format is the default for MyISAM  tables. It is used when
 * the table contains no columns BLOB or TEXT). Each row is
 * stored using a fixed number of bytes. CHAR and VARCHAR  columns are
 * space-padded to the specified column width, although the column
 * type is not altered.
 * 
 * It is also the fastest of the on-disk formats due to the ease with
 * which rows in the data file can be found on disk: To look up a row
 * based on a row number in the index, multiply the row number by the
 * row length to calculate the row position. Also, when scanning a table,
 * it is very easy to read a constant number of rows with each disk
 * read operation.
 */
public class MyISAMStaticTable
{

}
