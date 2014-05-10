package com.prodyna.esd.filemanager.metadata;

import com.prodyna.esd.filemanager.model.File;

public class AviAnalysator extends FileTypeAnalysator {
	
	AviAnalysator(FileTypeAnalysator inNextFileTypeAnalysator) {
		super(inNextFileTypeAnalysator);
	}

	protected FileType getFileType(File inFile) {
		return inFile.getName().endsWith("avi")? FileType.AVI: null;
	}
}
