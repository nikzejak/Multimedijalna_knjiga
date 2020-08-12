package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import model.Kolekcija;
import model.Node;
import model.Workspace;
import view.BiranjeDijalog;
import view.KolekcijaDijalog;
import view.MainFrame;

public class NovaKolekcija extends AbstractAction {
	
	private KolekcijaDijalog kd;
	
	public NovaKolekcija(KolekcijaDijalog kd) {
		// TODO Auto-generated constructor stub
		super();
		this.kd = kd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(kd.getNaziv().isEmpty() != true)
		{
			try {
				
				DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
				// nema sta da se dodaje
				if (parentNodeView == null) {
					return;
				}
				
				   
					Node parentNodeModel = (Node)parentNodeView.getUserObject();
					
					if(parentNodeModel instanceof Workspace)
					{
									
						Workspace parentKolekcija = (Workspace) parentNodeModel;
						   
						Kolekcija childNodeModel = new Kolekcija("Kolekcija:" + kd.getNaziv(),parentKolekcija);
						
						
						
						
						parentKolekcija.getKolekcije().add(childNodeModel);	
						
						kd.dispose();
						BiranjeDijalog.getInstance().dispose();
						
	
	
						DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(childNodeModel);
						
						DefaultTreeModel model = MainFrame.getInstance().getTreeHandler().getTreeModel();
						
						model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
						
					   
						
						JTree tree = MainFrame.getInstance().getTreeHandler().getTree();
						
						tree.setSelectionPath(new TreePath(childNodeView.getPath()));
						
						tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
						
					}
					else if (parentNodeModel instanceof Kolekcija)
					{
					
						Kolekcija parentKolekcija = (Kolekcija) parentNodeModel;
					   
						Kolekcija childNodeModel = new Kolekcija("Kolekcija: " + kd.getNaziv(),parentKolekcija);
						
						
						
						
						parentKolekcija.getComponents().add(childNodeModel);
						
						kd.dispose();
						BiranjeDijalog.getInstance().dispose();
						
	
	
						DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(childNodeModel);
						
						DefaultTreeModel model = MainFrame.getInstance().getTreeHandler().getTreeModel();
						
						model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
						
					   
						
						JTree tree = MainFrame.getInstance().getTreeHandler().getTree();
						
						tree.setSelectionPath(new TreePath(childNodeView.getPath()));
						
						tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
					}
					
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		else
		{
			System.out.println("Niste popunili naziv");
		}
		
	}

}
