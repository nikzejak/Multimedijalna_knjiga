package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Dokument extends Node implements Component {

	private String autor;
	private Kolekcija parent;
	
	private List<Stranica> stranice = new ArrayList<Stranica>();
	
	public Dokument()
	{
		
		autor = "";
	}
	public Dokument(String naziv,String autor,Kolekcija parent)
	{
		this.name = naziv;
		this.autor = autor;
		this.parent = parent;
	}
	
	public Dokument(String naziv,String autor,List<Stranica> stranice)
	{
		this.name = naziv;
		this.autor = autor;
		this.stranice = stranice;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	
	public List<Stranica> getStranice() {
		return stranice;
	}
	public void setStranice(List<Stranica> stranice) {
		this.stranice = stranice;
	}
	@Override
	public void addChilds(DefaultMutableTreeNode root) {
		// TODO Auto-generated method stub
		for(Stranica s : this.stranice)
		{
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(s);
			root.add(node);
		}
	}
	
	
}
