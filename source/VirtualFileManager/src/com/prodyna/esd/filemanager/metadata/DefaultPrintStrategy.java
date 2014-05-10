package com.prodyna.esd.filemanager.metadata;

import com.prodyna.esd.filemanager.model.Node;

public class DefaultPrintStrategy extends AbstractPrintStrategy {
	
	@Override
	void buildFileTypeMetadata(Node node, StringBuilder sb) {
		sb.append(String.format("Name: %s | ", node.getName()));
		sb.append(String.format("File Size: %d | ", node.getSize()));
	}
}
