package com.ironiacorp.learndb.dbms.mysql.storageengine;

/**
 * Each index record contains a five-byte header that may be preceded by a
 * variable-length header. The header is used to link together consecutive
 * records, and also in row-level locking.
 * 
 * The record header contains a bit vector for indicating NULL columns. The
 * bit vector occupies (n_nullable+7)/8 bytes. Columns that are NULL will
 * not occupy other space than the bit in this vector.
 * 
 * For each non-NULL variable-length field, the record header contains the
 * length of the column in one or two bytes. Two bytes will only be needed
 * if part of the column is stored externally or the maximum length exceeds
 * 255 bytes and the actual length exceeds 127 bytes.
 * 
 * The record header is followed by the data contents of the columns. Columns
 * that are NULL are omitted.
 * 
 * Records in the clustered index contain fields for all user-defined columns.
 * In addition, there is a six-byte field for the transaction ID and a
 * seven-byte field for the roll pointer.
 * 
 * If no primary key was defined for a table, each clustered index record
 * also contains a six-byte row ID field.
 * 
 * Each secondary index record contains also all the fields defined for the
 * clustered index key.
 * 
 * Internally, InnoDB stores fixed-length, fixed-width character columns such
 * as CHAR(10) in a fixed-length format. InnoDB truncates trailing spaces
 * from VARCHAR columns.
 * 
 * Internally, InnoDB attempts to store UTF-8 CHAR(n) columns in n bytes by
 * trimming trailing spaces. In ROW_FORMAT=REDUNDANT, such columns occupy 3*n
 * bytes. The motivation behind reserving the minimum space n is that it in
 * many cases enables an update of the column to be done in place without
 * causing fragmentation of the index page.
 */
public class InnoDBCompact
{

}
