package com.prodyna.esd.filemanager.visitor;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;

public class PrintTreeStructureVisitor implements NodeVisitor {

	public void printTreeStructure(Directory directory) {
		directory.accept(this);
	}
	
	@Override
	public void visit(Directory directory) {
		System.out.println(String.format("%s/", directory.getName()));
	}

	@Override
	public void visit(File file) {
		System.out.println(String.format("%s", file.getName()));
	}
}
