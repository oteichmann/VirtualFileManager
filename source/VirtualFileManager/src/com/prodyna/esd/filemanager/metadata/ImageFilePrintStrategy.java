package com.prodyna.esd.filemanager.metadata;

import com.prodyna.esd.filemanager.model.Node;

public class ImageFilePrintStrategy extends MediaFilePrintStrategy {
	
	@Override
	void buildFileTypeMetadata(Node node, StringBuilder sb) {
		super.buildFileTypeMetadata(node, sb);
		sb.append(String.format("ISO: %s | ", Math.random() * 100));
	}

}
