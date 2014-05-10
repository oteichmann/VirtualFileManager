package com.prodyna.esd.filemanager.manager;

import com.prodyna.esd.filemanager.FileManager;
import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.Node;

public class MemoryFileManager implements FileManager {

	public static MemoryFileManager createMemoryFileManager() {
		return null;
	}
	
	private MemoryFileManager() {
		
	}

	@Override
	public void addNode(Directory parentNode, Node node)
			throws FileManagerException {
		// TODO Auto-generated method stub		
	}
}
