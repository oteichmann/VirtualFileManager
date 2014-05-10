package com.prodyna.esd.filemanager;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.prodyna.esd.filemanager.command.Print;
import com.prodyna.esd.filemanager.exception.FileManagerException;
import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;
import com.prodyna.esd.filemanager.model.Node;
import com.prodyna.esd.filemanager.visitor.Criterium;
import com.prodyna.esd.filemanager.visitor.SearchVisitor;

public class SearchVisitorTest {

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
		Directory newDirectoryNode = new Directory("Test_Directory");			
		
		fileManager.addNode(rootNode, new File("Test1.txt"));	
		fileManager.addNode(rootNode, newDirectoryNode);	
		fileManager.addNode(newDirectoryNode, new File("Test2.txt"));	
		fileManager.addNode(newDirectoryNode, new File("Test3.txt"));	
		
		List<Node> result = new SearchVisitor(rootNode, new Criterium() {			
			@Override
			public boolean matches(Node node) {
				return node.getName().contains("Test");
			}
		}).search(new File("Test3.txt"));
		
		System.out.println(result);
		
		result = new SearchVisitor(rootNode, new Criterium() {			
			@Override
			public boolean matches(Node node) {
				return node.getName().contains("Test") && node instanceof Directory;
			}
		}).search(new File("Test3.txt"));
		
		Print printCommand = new Print(result);
		printCommand.execute();
	}
}
