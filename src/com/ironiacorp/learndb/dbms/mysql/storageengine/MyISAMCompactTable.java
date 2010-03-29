package com.ironiacorp.learndb.dbms.mysql.storageengine;

/**
 * Compressed storage format is a read-only format that is generated
 * with the myisampack tool. Compressed tables can be uncompressed with myisamchk.
 * 
 * Each row is compressed separately, so there is very little access overhead.
 * The header for a row takes up one to three bytes depending on the biggest row
 * in the table. Each column is compressed differently. There is usually a
 * different Huffman tree for each column.
 */
public class MyISAMCompactTable
{

}
