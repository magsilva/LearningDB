package com.ironiacorp.learndb.dbms.mysql.storageengine;

import com.ironiacorp.learndb.dbms.Column;
import com.ironiacorp.learndb.dbms.Table;

/**
 * A table cannot contain more than 1000 columns.
 * 
 * The internal maximum key length is 3500 bytes, but MySQL itself restricts
 * this to 1024 bytes.
 * 
 * The maximum row length, except for VARCHAR, BLOB and TEXT columns, is slightly
 * less than half of a database page. That is, the maximum row length is about 8000
 * bytes. LONGBLOB and LONGTEXT columns must be less than 4GB, and the total row
 * length, including also BLOB and TEXT columns, must be less than 4GB. InnoDB
 * stores the first 768 bytes of a VARCHAR, BLOB, or TEXT column in the row, and
 * the rest into separate pages.
 * 
 * Although InnoDB supports row sizes larger than 65535 internally, you cannot
 * define a row containing VARCHAR columns with a combined size larger than 65535:
 * 
 * The default database page size in InnoDB is 16KB. By recompiling the code, you can
 * set it to values ranging from 8KB to 64KB. You must update the values of
 * UNIV_PAGE_SIZE and UNIV_PAGE_SIZE_SHIFT in the univ.i source file.
 * 
 * 
 * 
 * Indexes
 * 
 * All InnoDB indexes are B-trees where the index records are stored in
 * the leaf pages of the tree. The default size of an index page is 16KB.
 * When new records are inserted, InnoDB tries to leave 1/16 of the page
 * free for future insertions and updates of the index records.
 * 
 * If index records are inserted in a sequential order (ascending or descending),
 * the resulting index pages are about 15/16 full. If records are inserted in a
 * random order, the pages are from 1/2 to 15/16 full. If the fill factor of 
 * an index page drops below 1/2, InnoDB tries to contract the index tree
 * to free the page.
 * 
 * If there are random insertions into or deletions from the indexes of a table,
 * the indexes may become fragmented. Fragmentation means that the physical
 * ordering of the index pages on the disk is not close to the index ordering
 * of the records on the pages, or that there are many unused pages in the
 * 64-page blocks that were allocated to the index.
 * 
 *  
 *  
 *  
 * File Space Management
 * 
 * The data files that you define in the configuration file form the tablespace
 * of InnoDB. The files are simply concatenated to form the tablespace. There is
 * no striping in use. Currently, you cannot define where within the tablespace
 * your tables are allocated. However, in a newly created tablespace, InnoDB
 * allocates space starting from the first data file.
 * 
 * The tablespace consists of database pages with a default size of 16KB. The
 * pages are grouped into extents of 64 consecutive pages. The “files” inside
 * a tablespace are called segments in InnoDB. The term “rollback segment” is
 * somewhat confusing because it actually contains many tablespace segments.
 * 
 * Two segments are allocated for each index in InnoDB. One is for non-leaf
 * nodes of the B-tree, the other is for the leaf nodes. The idea here is to
 * achieve better sequentiality for the leaf nodes, which contain the data.
 * 
 * When a segment grows inside the tablespace, InnoDB allocates the first 32
 * pages to it individually. After that InnoDB starts to allocate whole extents
 * to the segment. InnoDB can add to a large segment up to 4 extents at a
 * time to ensure good sequentiality of data.
 * 
 * Some pages in the tablespace contain bitmaps of other pages, and therefore
 * a few extents in an InnoDB tablespace cannot be allocated to segments as
 * a whole, but only as individual pages.
 * 
 * When you ask for available free space in the tablespace by issuing a
 * SHOW TABLE STATUS statement, InnoDB reports the extents that are definitely
 * free in the tablespace. InnoDB always reserves some extents for cleanup and
 * other internal purposes; these reserved extents are not included in the free
 * space.
 * 
 * When you delete data from a table, InnoDB contracts the corresponding B-tree
 * indexes. Whether the freed space becomes available for other users depends
 * on whether the pattern of deletes frees individual pages or extents to the
 * tablespace. Dropping a table or deleting all rows from it is guaranteed to
 * release the space to other users, but remember that deleted rows are
 * physically removed only in an (automatic) purge operation after they are
 * no longer needed for transaction rollbacks or consistent reads. 
 * 
 * 
 * 
 * 
 * Implementation of Multi-Versioning
 * 
 * Because InnoDB is a multi-versioned storage engine, it must keep information
 * about old versions of rows in the tablespace. This information is stored in
 * a data structure called a rollback segment (after an analogous data structure
 * in Oracle).
 * 
 * Internally, InnoDB adds two fields to each row stored in the database. A 6-byte
 * field indicates the transaction identifier for the last transaction that
 * inserted or updated the row. Also, a deletion is treated internally as an
 * update where a special bit in the row is set to mark it as deleted. Each row
 * also contains a 7-byte field called the roll pointer. The roll pointer points
 * to an undo log record written to the rollback segment. If the row was updated,
 * the undo log record contains the information necessary to rebuild the content
 * of the row before it was updated.
 * 
 * InnoDB uses the information in the rollback segment to perform the undo
 * operations needed in a transaction rollback. It also uses the information to
 * build earlier versions of a row for a consistent read.
 *  
 * Undo logs in the rollback segment are divided into insert and update undo
 * logs. Insert undo logs are needed only in transaction rollback and can be
 * discarded as soon as the transaction commits. Update undo logs are used also
 * in consistent reads, but they can be discarded only after there is no
 * transaction present for which InnoDB has assigned a snapshot that in a
 * consistent read could need the information in the update undo log to build
 * an earlier version of a database row.
 * 
 * You must remember to commit your transactions regularly, including those
 * transactions that issue only consistent reads. Otherwise, InnoDB cannot
 * discard data from the update undo logs, and the rollback segment may grow
 * too big, filling up your tablespace.
 * 
 * The physical size of an undo log record in the rollback segment is typically
 * smaller than the corresponding inserted or updated row. You can use this
 * information to calculate the space need for your rollback segment.
 * 
 * In the InnoDB multi-versioning scheme, a row is not physically removed from
 * the database immediately when you delete it with an SQL statement. Only when
 * InnoDB can discard the update undo log record written for the deletion can
 * it also physically remove the corresponding row and its index records from
 * the database. This removal operation is called a purge, and it is quite
 * fast, usually taking the same order of time as the SQL statement that did
 * the deletion.
 */
public class InnoDB
{
	public static final int MIN_ROW_SIZE = 6;
	
	public int getRowSize(Table t)
	{
		int totalSize = 0;
		int columnsSize = 0;
		int offsetSize = 0;
		
		// Row header
		totalSize += MIN_ROW_SIZE;
		
		// Columns
		for (Column c : t.getColumns()) {
			columnsSize += c.getSize();
		}
		totalSize += columnsSize;
		
		// Field start offset
		// The size of each offset can be either one byte or two bytes. One-byte
		// offsets are only usable if the total record size is less than 127. There
		// is a flag in the "Extra Bytes" part which will tell you whether the size 
		// is one byte or two bytes.
		if (columnsSize < 127) {
			offsetSize = 1;
		} else {
			offsetSize = 2;
		}
		totalSize += t.getColumnCount() * offsetSize;
		
		return totalSize;
	}
}
