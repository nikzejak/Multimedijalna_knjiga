package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Workspace extends Node {

  
		private Workspace parent;
		
		private List<Kolekcija> kolekcije = new ArrayList<Kolekcija>();
		
		public Workspace(String naziv,Workspace parent)
		{
			this.name  = naziv;
			this.parent = parent;
		}

		

		public Workspace getParent() {
			return parent;
		}

		public void setParent(Workspace parent) {
			this.parent = parent;
		}
		
		public void addChilds(DefaultMutableTreeNode root) {
			
			for (Kolekcija p : this.kolekcije) {
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(p);
				p.addChilds(node);
				root.add(node);
			}
		}



		public List<Kolekcija> getKolekcije() {
			return kolekcije;
		}



		public void setKolekcije(List<Kolekcija> kolekcije) {
			this.kolekcije = kolekcije;
		}
		
		
		
}
