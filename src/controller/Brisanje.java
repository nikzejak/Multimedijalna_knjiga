package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Component;
import model.Dokument;
import model.Kolekcija;
import model.Node;
import model.Stranica;
import model.Workspace;
import view.MainFrame;

public class Brisanje extends AbstractAction{
	
	
	public Brisanje() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode childNodeView = (DefaultMutableTreeNode) MainFrame
				.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		
		if (childNodeView == null) {
			return;
		}
		
		Node childNodeModel = (Node) childNodeView.getUserObject();
		
		if (childNodeModel instanceof Workspace)
			return;
		
		
		if(childNodeModel instanceof Kolekcija)
		{
			Kolekcija k = (Kolekcija) childNodeModel;
			DefaultMutableTreeNode parent = (DefaultMutableTreeNode)childNodeView.getParent();
			if(parent.getUserObject() instanceof Workspace)
			{
			   ((Workspace)parent.getUserObject()).getKolekcije().remove(k);
			   MainFrame.getInstance().getTreeHandler().getTreeModel().removeNodeFromParent(childNodeView);
			}
			else
			{
				 ((Kolekcija)parent.getUserObject()).getComponents().remove(k);
				  MainFrame.getInstance().getTreeHandler().getTreeModel().removeNodeFromParent(childNodeView);
			}
			
		}
		
		else if(childNodeModel instanceof Dokument && MainFrame.getInstance().isCitanje() == false)
		{
			Dokument d = (Dokument) childNodeModel;
			DefaultMutableTreeNode parent = (DefaultMutableTreeNode)childNodeView.getParent();
			 ((Kolekcija)parent.getUserObject()).getComponents().remove(d);
			 MainFrame.getInstance().getTreeHandler().getTreeModel().removeNodeFromParent(childNodeView);
		}
		else if(childNodeModel instanceof Stranica)
		{
			Stranica s = (Stranica) childNodeModel;
			DefaultMutableTreeNode parent = (DefaultMutableTreeNode)childNodeView.getParent();
			 ((Dokument)parent.getUserObject()).getStranice().remove(s);
			 MainFrame.getInstance().getTreeHandler().getTreeModel().removeNodeFromParent(childNodeView);
		}
		
		
		
	}

}
