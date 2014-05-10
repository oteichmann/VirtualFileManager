package com.prodyna.esd.filemanager.exception;

public class FileManagerException extends Exception {

	private static final long serialVersionUID = 8347776987747683873L;

	public FileManagerException() {
		super();
	}

	public FileManagerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileManagerException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileManagerException(String message) {
		super(message);
	}

	public FileManagerException(Throwable cause) {
		super(cause);
	}
	
	
}
