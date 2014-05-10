package com.prodyna.esd.filemanager.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Node {

	private String name;
	private final Map<String, String> metaData;
	private Node parent;

	public Node(String name) {
		this.metaData = new HashMap<String, String>();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String inName) {
		this.name = inName;
	}

	public Map<String, String> getMetaData() {
		return metaData;
	}
	
	public Node getParent() {
		return parent;
	}

	protected void setParent(Node parent) {
		this.parent = parent;
	}

}
