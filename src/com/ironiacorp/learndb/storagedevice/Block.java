package com.ironiacorp.learndb.storagedevice;

public abstract class Block
{
	protected int size;
	
	public abstract void write(Long address, Byte[] data);

	public abstract Byte[] read(Long address);
}
