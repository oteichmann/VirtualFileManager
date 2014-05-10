package com.prodyna.esd.filemanager.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Node {

	private String name;
	private final Map<String, String> metaData;
		
	private Node(String inName) {
		metaData = new HashMap<String, String>();
		name = inName;
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
}
