package com.prodyna.esd.filemanager.visitor;

import com.prodyna.esd.filemanager.model.Node;

public interface Criterium {

	abstract public boolean matches(Node node);
}
