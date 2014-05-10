package com.prodyna.esd.filemanager.visitor;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;
import com.prodyna.esd.filemanager.model.Node;

public class PrintFullPathTreeStructureVisitor implements NodeVisitor {
	
	public void printTreeStructure(Directory directory) {
		directory.accept(this);
	}
	
	@Override
	public void visit(Directory directory) {
		System.out.println(directory.getPath());
		for (Node child : directory.getChildren()) {
			child.accept(this);
		}
	}

	@Override
	public void visit(File file) {
		System.out.println(file.getPath());
	}
	
}
