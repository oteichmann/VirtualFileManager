package com.prodyna.esd.filemanager.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.prodyna.esd.filemanager.visitor.NodeVisitable;
import com.prodyna.esd.filemanager.visitor.NodeVisitor;

public class Directory extends Node implements NodeVisitable {
	
	private final static String FILE_SEPARATOR = System.getProperty("file.separator");
	
	private List<Node> children = new LinkedList<Node>();
	
	public Directory(String name) {
		super(name);
	}
	
	public boolean isRoot() {
		return (getParent() == null);
	}

	public List<Node> getChildren() {
		return Collections.unmodifiableList(children);
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	public void addChild(Node node) {
		children.add(node);
		node.setParent(this);
	}
	
	@Override
	public void setParent(Node parent) {
		super.setParent(parent);
	}

	@Override
	public long getSize() {
		long size = 0;
		
		for (Node child : children) {
			size = size + child.getSize();
		}
		
		return size;
	}
	
	public String getPath() {
		
		if(isRoot()) {
			return FILE_SEPARATOR;
		}
		
		StringBuilder path = new StringBuilder();
		path.append(getParent().getPath());
		path.append(super.getPath());
		return path.toString();		
	}

	@Override
	public void accept(NodeVisitor nodeVisitor) {
		nodeVisitor.visit(this);
	}
	
}
