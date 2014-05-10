package com.prodyna.esd.filemanager.visitor;

import com.prodyna.esd.filemanager.model.Directory;
import com.prodyna.esd.filemanager.model.File;

public interface NodeVisitor {
	
	abstract public void visit(Directory directory);

	abstract public void visit(File file);
}
