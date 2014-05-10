package com.prodyna.esd.filemanager.manager;

public final class FileManagerFactory {
	
	public static FileManagerFactory fileManagerFactory = new FileManagerFactory();
	
	private FileManagerFactory() {
		
	}
	
	public static FileManagerFactory getInstance() {
		return fileManagerFactory;
	}

	public MemoryFileManager createMemoryFileManager() {
		return MemoryFileManager.createMemoryFileManager();
	}
}
