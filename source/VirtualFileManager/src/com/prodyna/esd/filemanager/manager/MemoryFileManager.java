package com.prodyna.esd.filemanager.manager;

import com.prodyna.esd.filemanager.FileManager;
import com.prodyna.esd.filemanager.command.Action;
import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.Node;

public class MemoryFileManager implements FileManager {

	private Directory rootNode;
	
	public static MemoryFileManager createMemoryFileManager() {
		return new MemoryFileManager();
	}
	
	private MemoryFileManager() {
		
	}
	
	@Override
	public <T extends Node> T addNode(T node)
			throws FileManagerException {
		
		return addNode(rootNode(), node);
	}

	@Override
	public <T extends Node> T addNode(Directory parentNode, T node)
			throws FileManagerException {
		
		validateAddNode(parentNode, node);
		
		parentNode.addChild(node);
		
		return node;
	}

	private void validateAddNode(Directory parentNode, Node node) throws FileManagerException {
		if(parentNode == null || node == null) {
			throw new FileManagerException("The parameteres parentNode and node must not be null.");
		}
	}

	@Override
	public Directory rootNode() throws FileManagerException {
		if (this.rootNode == null) {
			synchronized (this) {
				if (this.rootNode == null) {
					this.rootNode = new Directory("");
				}
			}
		}
		
		return this.rootNode;
	}

	@Override
	public void listNodes() throws FileManagerException {
		// TODO Auto-generated method stub		
	}

	@Override
	public void executeAction(Action action) throws FileManagerException {
		// TODO Auto-generated method stub		
	}
}
