package com.prodyna.esd.filemanager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.visitor.PrintTreeStructureVisitor;

public class PrintTreeStructureVisitorTest extends AbstractTreeTest {

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
		
		Directory rootNode = createSampleTree(fileManager);
		
		new PrintTreeStructureVisitor().printTreeStructure(rootNode);
	}
}
