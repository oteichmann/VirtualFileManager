package com.prodyna.esd.filemanager.visitor;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;
import com.prodyna.esd.filemanager.model.Node;

public class PrintTreeStructureVisitor implements NodeVisitor {
	
	private int treeDepth = 0;

	public void printTreeStructure(Directory directory) {
		directory.accept(this);
	}
	
	@Override
	public void visit(Directory directory) {
		System.out.println(String.format("%s%s/", createSpaces(treeDepth), directory.getName()));
		this.treeDepth++;
		for (Node child : directory.getChildren()) {
			child.accept(this);
		}
		this.treeDepth--;
	}

	@Override
	public void visit(File file) {
		System.out.println(String.format("%s%s/", createSpaces(treeDepth), file.getName()));
	}
	
	private String createSpaces(int number){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
}
