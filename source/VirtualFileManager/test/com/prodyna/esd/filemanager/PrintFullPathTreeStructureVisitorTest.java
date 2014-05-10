package com.prodyna.esd.filemanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;
import com.prodyna.esd.filemanager.visitor.PrintFullPathTreeStructureVisitor;
import com.prodyna.esd.filemanager.visitor.PrintTreeStructureVisitor;

public class PrintFullPathTreeStructureVisitorTest {

	
	int directoryCount = 0;
	int fileCount = 0;
	
	
	private FileManager fileManager;

	@Before
	public void setUp() throws Exception {
		fileManager = FileManager.FACTORY.createMemoryFileManager();
	}

	@After
	public void tearDown() throws Exception {
		fileManager = null; 
	}

	@Test
	public void testPrintTreeStructure() throws FileManagerException {

		Directory rootNode = fileManager.rootNode();
		Directory directoryNode = createDirectory();			
		
		fileManager.addNode(rootNode, createFile());	
		fileManager.addNode(rootNode, createFile());	
		fileManager.addNode(rootNode, directoryNode);	
		fileManager.addNode(directoryNode, createFile());
		fileManager.addNode(directoryNode, createDirectory());	
		fileManager.addNode(directoryNode, createDirectory());	
		fileManager.addNode(directoryNode, createDirectory(2, 2));
		
		new PrintFullPathTreeStructureVisitor().printTreeStructure(rootNode);
	}
	
	private File createFile() {
		return new File(String.format("file%d.txt", fileCount++));
	}
	
	private Directory createDirectory() {
		return new Directory(String.format("directory%d", directoryCount++));
	}
	
	private Directory createDirectory(int numberOfChildDirectories, int numberOfChildFiles) {
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
