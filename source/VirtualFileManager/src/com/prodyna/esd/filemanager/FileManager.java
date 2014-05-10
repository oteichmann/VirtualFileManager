package com.prodyna.esd.filemanager;

import com.prodyna.esd.filemanager.manager.FileManagerFactory;
import com.prodyna.esd.filemanager.model.Node;

public interface FileManager {

	public static final FileManagerFactory FACTORY = FileManagerFactory.getInstance();
	
	abstract public void addNode(Node node);
}
