package com.prodyna.esd.filemanager.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Directory extends Node {
	
	private boolean root = true;

	private List<Node> children = new LinkedList<Node>();
	
	public Directory(String name) {
		super(name);
	}
	
	
	public boolean isRoot() {
		return root;
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
		this.root = false;
	}
	
}
