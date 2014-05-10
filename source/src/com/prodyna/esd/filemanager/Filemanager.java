package com.prodyna.esd.filemanager;

import com.prodyna.esd.filemanager.manager.FileManagerFactory;

public interface Filemanager {

	public static final FileManagerFactory FACTORY = FileManagerFactory.getInstance();
}
