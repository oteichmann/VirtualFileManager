package com.prodyna.esd.filemanager.manager;

import com.prodyna.esd.filemanager.FileManager;

public final class FileManagerFactory {
	
	public static FileManagerFactory fileManagerFactory = new FileManagerFactory();
	
	private FileManagerFactory() {
		
	}
	
	public static FileManagerFactory getInstance() {
		return fileManagerFactory;
	}

	public FileManager createMemoryFileManager() {
		MemoryFileManager memoryFileManager = MemoryFileManager.createMemoryFileManager();		
		return NotifingFileManagerDecorator.createNotifingFileManagerDecorator(memoryFileManager);
	}
}
