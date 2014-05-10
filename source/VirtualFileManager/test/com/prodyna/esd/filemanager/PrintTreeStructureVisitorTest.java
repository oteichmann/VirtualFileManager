package com.prodyna.esd.filemanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;
import com.prodyna.esd.filemanager.visitor.PrintTreeStructureVisitor;

public class PrintTreeStructureVisitorTest {

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
		
		int directoryCount = 0;
		int fileCount = 0;
		
		Directory rootNode = fileManager.rootNode();
		Directory newDirectoryNode = createDirectory(directoryCount++);			
		
		fileManager.addNode(rootNode, createFile(fileCount++));	
		fileManager.addNode(rootNode, newDirectoryNode);	
		fileManager.addNode(newDirectoryNode, createFile(fileCount++));	
		fileManager.addNode(newDirectoryNode, createFile(fileCount++));	
		fileManager.addNode(newDirectoryNode, createDirectory(directoryCount++));	
		fileManager.addNode(newDirectoryNode, createDirectory(directoryCount++));	
		
		new PrintTreeStructureVisitor().printTreeStructure(rootNode);
	}
	
	private File createFile(int count) {
		return new File(String.format("file%d.txt", count));
	}
	
	private Directory createDirectory(int count) {
		return new Directory(String.format("directory%d", count));
	}
}
