package com.prodyna.esd.filemanager.model;

import com.prodyna.esd.filemanager.visitor.NodeVisitable;
import com.prodyna.esd.filemanager.visitor.NodeVisitor;

public class File extends Node implements NodeVisitable {
	
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
	
	@Override
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
}
