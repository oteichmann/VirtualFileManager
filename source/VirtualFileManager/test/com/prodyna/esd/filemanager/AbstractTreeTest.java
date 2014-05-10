package com.prodyna.esd.filemanager;

import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;

public abstract class AbstractTreeTest {
	
	int directoryCount = 0;
	int fileCount = 0;

	protected Directory createSampleTree(FileManager fileManager) throws FileManagerException {
		Directory rootNode = fileManager.rootNode();
		Directory directoryNode = createDirectory();			
		
		fileManager.addNode(rootNode, createFile());	
		fileManager.addNode(rootNode, createFile("png"));	
		fileManager.addNode(rootNode, createFile("jpg"));	
		fileManager.addNode(rootNode, directoryNode);	
		fileManager.addNode(directoryNode, createFile());
		fileManager.addNode(directoryNode, createFile("png"));
		fileManager.addNode(directoryNode, createFile("avi"));
		fileManager.addNode(directoryNode, createFile("avi"));
		fileManager.addNode(directoryNode, createDirectory());	
		fileManager.addNode(directoryNode, createDirectory());	
		fileManager.addNode(directoryNode, createDirectory(2, 2));
		
		return rootNode;
	}
	
	protected File createFile() {
		return new File(String.format("file%d.txt", fileCount++));
	}
	
	protected File createFile(String extension) {
		return new File(String.format("file%d." + extension, fileCount++));
	}
	
	protected Directory createDirectory() {
		return new Directory(String.format("directory%d", directoryCount++));
	}
	
	protected Directory createDirectory(int numberOfChildDirectories, int numberOfChildFiles) {
		Directory directory = createDirectory();
		
		for (int i = 0; i < numberOfChildDirectories; i++) {
			directory.addChild(createDirectory());
		}
		
		for (int i = 0; i < numberOfChildFiles; i++) {
			directory.addChild(createFile());
		}
		
		return directory;
	}

}
