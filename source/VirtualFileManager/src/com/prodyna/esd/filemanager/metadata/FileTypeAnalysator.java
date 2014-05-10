package com.prodyna.esd.filemanager.metadata;

import com.prodyna.esd.filemanager.model.File;

public abstract class FileTypeAnalysator {
	
	private FileTypeAnalysator nextFileTypeAnalysator;
	
	public static FileTypeAnalysator createFileTypeAnalysatorChain() {
		return new AviAnalysator(new PngAnalysator(new TxtAnalysator(null)));		
	}
		
	FileTypeAnalysator(FileTypeAnalysator inNextFileTypeAnalysator) {
		nextFileTypeAnalysator = inNextFileTypeAnalysator;
	}
	
	public FileType analyseFileType(File inFile) {
		FileType fileType = getFileType(inFile);
		
		if (fileType != null) {
			return fileType;
		} else if (chain() != null) {
			return chain().analyseFileType(inFile);
		}
		return FileType.UNKNOWN;
	}
	
	abstract protected FileType getFileType(File inFile);

	protected FileTypeAnalysator chain() {
		return nextFileTypeAnalysator;
	}
}
