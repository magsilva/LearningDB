package com.ironiacorp.learndb.storagedevice;

/**
 * Flash storage cannot be simply overwritten like magnetic storage; instead, a flash block must be
 * explicitly erased and rewritten in two separate steps. The size of the "erase blocks" may not
 * match the block size as understood by the operating system; often, the erase blocks are
 * relatively large. There are limits to the number of times a block of flash memory can be erased
 * and rewritten before it loses the ability to reliably store data. That limit is generally around
 * 100,000 cycles.
 */
public class FlashMemoryDiskBlock extends Block
{

	public Byte[] read(Long address)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void write(Long address, Byte[] data)
	{
		// TODO Auto-generated method stub

	}

}
