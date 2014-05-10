package com.prodyna.esd.filemanager.metadata;

import com.prodyna.esd.filemanager.model.File;

public class PngAnalysator extends FileTypeAnalysator {
	
	PngAnalysator(FileTypeAnalysator inNextFileTypeAnalysator) {
		super(inNextFileTypeAnalysator);
	}

	protected FileType getFileType(File inFile) {
		return inFile.getName().endsWith("png")? FileType.PNG: null;
	}
}
