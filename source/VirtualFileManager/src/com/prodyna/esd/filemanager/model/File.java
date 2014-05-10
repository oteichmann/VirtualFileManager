package com.prodyna.esd.filemanager.model;

public class File extends Node {
	
	public File(String name) {
		super(name);
	}

	private int size;
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
