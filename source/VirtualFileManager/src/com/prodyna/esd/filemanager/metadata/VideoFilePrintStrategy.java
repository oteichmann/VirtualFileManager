package com.prodyna.esd.filemanager.metadata;

import com.prodyna.esd.filemanager.model.Node;

public class VideoFilePrintStrategy extends MediaFilePrintStrategy {
	
	@Override
	void buildFileTypeMetadata(Node node, StringBuilder sb) {
		super.buildFileTypeMetadata(node, sb);
		sb.append(String.format("Duration in minutes: %s | ", Math.random() * 100));
	}

}
