package com.prodyna.esd.filemanager.metadata;

import com.prodyna.esd.filemanager.model.File;

public class TxtAnalysator extends FileTypeAnalysator {
	
	TxtAnalysator(FileTypeAnalysator inNextFileTypeAnalysator) {
		super(inNextFileTypeAnalysator);
	}

	protected FileType getFileType(File inFile) {
		return inFile.getName().endsWith("txt")? FileType.TXT: null;
	}
}
