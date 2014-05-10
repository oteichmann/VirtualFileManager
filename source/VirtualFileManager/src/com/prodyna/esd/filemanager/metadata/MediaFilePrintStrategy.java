package com.prodyna.esd.filemanager.metadata;

import com.prodyna.esd.filemanager.model.Node;

public class MediaFilePrintStrategy extends DefaultPrintStrategy {

	@Override
	void buildFileTypeMetadata(Node node, StringBuilder sb) {
		super.buildFileTypeMetadata(node, sb);
		sb.append(String.format("Heidth: %s | ", Math.random() * 1000));
		sb.append(String.format("Width: %s | ", Math.random() * 1000));
	}
}
