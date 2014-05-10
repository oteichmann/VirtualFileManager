package com.prodyna.esd.filemanager;

import com.prodyna.esd.filemanager.command.Action;
import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.manager.FileManagerFactory;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.Node;

public interface FileManager {

	public static final FileManagerFactory FACTORY = FileManagerFactory.getInstance();
	
	/**
	 * Adds a node to a parent node
	 * 
	 * @param node the parent node of the node to add
	 * @param node the node to add
	 * 
	 * @throws FileManagerException throw an exception if the node couldn't be added
	 */
	abstract public void addNode(Directory parentNode, Node node) throws FileManagerException;
	
	abstract public void rootNode() throws FileManagerException;
	
	abstract public void listNodes() throws FileManagerException;
	
	abstract public void executeAction(Action action) throws FileManagerException;
}
