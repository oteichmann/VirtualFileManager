package com.prodyna.esd.filemanager.command;

import java.util.List;

import com.prodyna.esd.filemanager.model.Node;

public class Print implements Action {
	
	List<Node> nodes;
	
	public Print(List<Node> inNodes) {
		nodes = inNodes;
	}
	
	@Override
	public void execute() {
		for (Node node: nodes) {
			System.out.println(node.toString());
		}
	}
}
