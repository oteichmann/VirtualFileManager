package com.prodyna.esd.filemanager.metadata;

import com.prodyna.esd.filemanager.model.Node;

public class TextFilePrintStrategy extends DefaultPrintStrategy {
	
	@Override
	void buildFileTypeMetadata(Node node, StringBuilder sb) {
		super.buildFileTypeMetadata(node, sb);
		sb.append(String.format("Lines: %s | ", Math.random() * 100));
		sb.append(String.format("Words: %s | ", Math.random() * 2000));
	}
}
