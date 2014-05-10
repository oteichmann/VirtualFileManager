package com.prodyna.esd.filemanager.manager;

public interface Observable {

	abstract public void addObserver(Observer observer);
	
	abstract public void removeObserver(Observer observer);
}
