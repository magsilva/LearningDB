package com.ironiacorp.learndb.dbms.mysql.storageengine;

/**
 * Each index record contains a six-byte header. The header is used to
 * link together consecutive records, and also in row-level locking.
 * 
 * Records in the clustered index contain fields for all user-defined
 * columns. In addition, there is a six-byte field for the transaction
 * ID and a seven-byte field for the roll pointer.
 * 
 * If no primary key was defined for a table, each clustered index
 * record also contains a six-byte row ID field.
 * 
 * Each secondary index record contains also all the fields defined
 * for the clustered index key.
 * 
 * A record contains also a pointer to each field of the record. If 
 * the total length of the fields in a record is less than 128 bytes,
 * the pointer is one byte; otherwise, two bytes. The array of these
 * pointers is called the record directory. The area where these pointers
 * point is called the data part of the record.
 * 
 * Internally, InnoDB stores fixed-length character columns such as
 * CHAR(10) in a fixed-length format. InnoDB truncates trailing spaces
 * from VARCHAR columns.
 * 
 * An SQL NULL value reserves 1 or 2 bytes in the record directory.
 * Besides that, an SQL NULL value reserves zero bytes in the data
 * part of the record if stored in a variable length column. In a
 * fixed-length column, it reserves the fixed length of the column in the
 * data part of the record. The motivation behind reserving the fixed
 * space for NULL values is that it enables an update of the column
 * from NULL to a non-NULL value to be done in place without causing
 * fragmentation of the index page.
 */
public class InnoDBRedundant
{

}
