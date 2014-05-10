package com.prodyna.esd.filemanager.visitor;

import java.util.LinkedList;
import java.util.List;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;
import com.prodyna.esd.filemanager.model.Node;

public class SearchVisitor implements NodeVisitor {
	
	private Directory rootDirectory;
	private Criterium criterium;
	private List<Node> resultNodes;
	
	public SearchVisitor(Directory inRootDirectory, Criterium inCriterium) {
		criterium = inCriterium;
		rootDirectory = inRootDirectory;
	}

	public synchronized List<Node> search(Node node) {
		resultNodes = new LinkedList<Node>();		
		rootDirectory.accept(this);
		return resultNodes;
	}
	
	@Override
	public void visit(Directory directory) {
		addToResultIfMatches(directory);
		
		for (Node child : directory.getChildren()) {
			child.accept(this);
		}
	}

	@Override
	public void visit(File file) {
		addToResultIfMatches(file);
	}
	
	public void addToResultIfMatches(Node node) {
		if (criterium.matches(node)) {
			resultNodes.add(node);
		}
	}
}
