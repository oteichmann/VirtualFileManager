package com.prodyna.esd.filemanager.metadata;

import com.prodyna.esd.filemanager.model.Node;

public abstract class AbstractPrintStrategy implements PrintStrategy {
	
	@Override
	public void printMetadata(Node node) {
		StringBuilder sb = new StringBuilder();
		buildFileTypeMetadata(node, sb);
		System.out.println(sb.toString());
	}

	abstract void buildFileTypeMetadata(Node node, StringBuilder sb);
}
