package com.prodyna.esd.filemanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;
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
	public void testRootNode() {		
		try {
			Directory rootNode = fileManager.rootNode();
			
			assertNotNull(rootNode);
			assertNotNull(rootNode.getMetaData());
			assertNotNull(rootNode.getChildren());
			assertEquals(true, rootNode.isRoot());
			assertEquals("A created root node should never change", rootNode, fileManager.rootNode());
			assertEquals("A created root node should never change", true, rootNode == fileManager.rootNode());
		} catch (FileManagerException e) {
			fail("No exception was expected");
		}
	}

	@Test
	public void testAddNodeForMemoryFileManager() {		
		try {
			Directory rootNode = fileManager.rootNode();
			File newfileNode = new File("Test1.txt");			
			File addedFileNode = fileManager.addNode(rootNode, newfileNode);	
			
			assertNotNull(addedFileNode);
			assertEquals(newfileNode.getName(), addedFileNode.getName());
			assertEquals("Added files shouldn't be the same files", false, newfileNode == addedFileNode);
			
			assertEquals(rootNode.getChildren().size(), 1);
			assertEquals(newfileNode.getName(), rootNode.getChildren().get(0));
			assertEquals("Nodes in collection must be unmodifiable", false, newfileNode == rootNode.getChildren().get(0));		
					
			Directory directoryNode = new Directory("Test");
			Directory addedDirectoryNode = fileManager.addNode(rootNode, directoryNode);
			
			assertNotNull(addedDirectoryNode);
			assertEquals(false, addedDirectoryNode.isRoot());
			assertEquals(addedDirectoryNode.getName(), addedDirectoryNode.getName());
			assertEquals("Added directories shouldn't be the same directories", false, directoryNode == addedDirectoryNode);

			assertEquals(rootNode.getChildren().size(), 2);
			
			try {
				rootNode.getChildren().add(new File("not_allowed.txt"));
				
				fail("An exception was expected");
			} catch (UnsupportedOperationException unsupportedOperationException) { }

			assertNotNull(rootNode.getMetaData());
			assertNotNull(rootNode.getChildren());
			assertEquals("A created root node should never change", rootNode, fileManager.rootNode());
			assertEquals("A created root node should never change", true, rootNode == fileManager.rootNode());
		} catch (FileManagerException e) {
			fail("No exception was expected");
		}
	}

	@Test
	public void testAddNodeFailureForMemoryFileManager() {		
		Directory rootNode = null;
		Node childNode = null;
		
		try {			
			fileManager.addNode(null, null);
			
			fail("An exception was expected");
		} catch (FileManagerException exception) { }
		
		try {			
			fileManager.addNode(rootNode, null);
			
			fail("An exception was expected");
		} catch (FileManagerException exception) { }
		
		try {			
			fileManager.addNode(null, childNode);
			
			fail("An exception was expected");
		} catch (FileManagerException exception) { }
	}
}
