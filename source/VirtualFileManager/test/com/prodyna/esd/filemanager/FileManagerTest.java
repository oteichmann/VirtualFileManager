package com.prodyna.esd.filemanager;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.Node;

public class FileManagerTest {
	
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
	public void testAddNodeForMemoryFileManager() {		
		Directory rootNode = null;
		Node childNode = null;
	}

	@Test
	public void testAddNodeFailureForMemoryFileManager() {		
		Directory rootNode = null;
		Node childNode = null;
		
		try {			
			fileManager.addNode(null, null);
			
			fail("An exception was exspected");
		} catch (FileManagerException exception) { }
		
		try {			
			fileManager.addNode(rootNode, null);
			
			fail("An exception was exspected");
		} catch (FileManagerException exception) { }
		
		try {			
			fileManager.addNode(null, childNode);
			
			fail("An exception was exspected");
		} catch (FileManagerException exception) { }
	}
}
