package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {
	
	protected String name;
	private Node parent;
	private List<Node> children;
	
	
	public Node()
	{
		this.children = new ArrayList<Node>();

	}
	
	
	
	public Node(String name, Node parent) {
		this();
		this.name = name;
		this.parent = parent;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public String toString() {
		return this.name;
	}


}
