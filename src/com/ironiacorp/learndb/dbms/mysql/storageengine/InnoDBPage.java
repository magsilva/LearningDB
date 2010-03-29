package com.ironiacorp.learndb.dbms.mysql.storageengine;

/**
 * An InnoDB page has seven parts: - Fil Header - Page Header - Infimum + Supremum Records - User
 * Records - Free Space - Page Directory - Fil Trailer
 */
public class InnoDBPage
{
	public static final int PAGE_SIZE = 16 * 1024; // 16kb

	public static final int FIL_HEADER_SIZE = 38;

	public static final int PAGE_HEADER_SIZE = 56;

	public static final int INFIMUM_RECORD_SIZE = 8;

	public static final int SUPREMUM_RECORD_SIZE = 8;

	public static final int FIL_TRAILER_SIZE = 8;

	public int getHeaderSize()
	{
		return FIL_HEADER_SIZE + PAGE_HEADER_SIZE + INFIMUM_RECORD_SIZE + SUPREMUM_RECORD_SIZE
						+ FIL_TRAILER_SIZE;
	}

	public int getAvailableSpace()
	 {
		 return PAGE_SIZE - getHeaderSize();
	 }

}
