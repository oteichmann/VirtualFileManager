package com.prodyna.esd.filemanager.command;

import com.prodyna.esd.filemanager.model.Node;

public interface Action {

	abstract public void execute(Node node);
}
