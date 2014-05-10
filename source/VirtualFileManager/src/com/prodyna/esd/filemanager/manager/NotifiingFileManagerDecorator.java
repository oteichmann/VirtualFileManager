package com.prodyna.esd.filemanager.manager;

import java.util.List;

import com.prodyna.esd.filemanager.FileManager;
import com.prodyna.esd.filemanager.command.Action;
import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.Node;

class NotifiingFileManagerDecorator implements FileManager, Observable {
	
	private FileManager fileManager;
	private List<Observer> observers;
	
	public NotifiingFileManagerDecorator(FileManager inFileManager) {
		fileManager = inFileManager;
	}

	@Override
	public <T extends Node> T addNode(T node) throws FileManagerException {
		return fileManager.addNode(node);
	}

	@Override
	public <T extends Node> T addNode(Directory parentNode, T node)
			throws FileManagerException {
		T newNode = fileManager.addNode(parentNode, node);
		notifyObservers(Event.NODE_ADDED);
		return newNode;
	}

	@Override
	public Directory rootNode() throws FileManagerException {
		return fileManager.rootNode();
	}

	@Override
	public void listNodes() throws FileManagerException {
		fileManager.listNodes();		
	}

	@Override
	public void executeAction(Action action) throws FileManagerException {
		fileManager.executeAction(action);
	}
	
	public void notifyObservers(Event event) {
		for (Observer observer: observers) {
			observer.notify(event);
		}
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);		
	}
}
