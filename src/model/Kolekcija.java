package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Kolekcija extends Node implements Component  {

	private List<Component> components = new ArrayList<Component>();
	private Kolekcija parent_kolekcija;
	private Workspace parent_workspace;
	
	
	
	public Kolekcija()
	{
		
	}
	
	public Kolekcija(String naziv)
	{
		this.name = naziv;
	}
	
	public Kolekcija(String naziv,Kolekcija parent)
	{
		this.name = naziv;
		this.parent_kolekcija = parent;
	
		
	}
	
	public Kolekcija(String naziv,Workspace parent)
	{
		this.name = naziv;
		this.parent_workspace = parent;
	
		
	}
	
	
	
	
	public List<Component> getComponents() {
		return components;
	}
	public void setComponents(List<Component> components) {
		this.components = components;
	}
	@Override
	public void addChilds(DefaultMutableTreeNode root) {
		// TODO Auto-generated method stub
		for(Component c : this.components)
		{
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(c);
			c.addChilds(node);
			root.add(node);
		}
		
	}
	
	
}
