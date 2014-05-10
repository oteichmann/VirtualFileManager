package com.prodyna.esd.filemanager.model;

public class File extends Node {
	
	private long size;

	public File(String name) {
		super(name);
	}
	
	public long getSize() {
		return this.size;
	}

	public void setSize(long size) {
		this.size = size;
	}
}
