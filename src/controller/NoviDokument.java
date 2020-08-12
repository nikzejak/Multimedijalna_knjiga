package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import model.Dokument;
import model.Kolekcija;
import model.Node;
import view.BiranjeDijalog;
import view.DokumentDijalog;
import view.MainFrame;

public class NoviDokument extends AbstractAction {
	
	private DokumentDijalog dd;
	
	public NoviDokument(DokumentDijalog dd) {
		// TODO Auto-generated constructor stub
		super();
		this.dd = dd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(dd.getNaziv().isEmpty() != true || dd.getAutor().isEmpty() != true)
		{
			try {
				
				DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
				// nema sta da se dodaje
				if (parentNodeView == null) {
					return;
				}
				
				   
					Kolekcija parentNodeModel = (Kolekcija)parentNodeView.getUserObject();
				
					Dokument childNodeModel = new Dokument("Dokument:" + dd.getNaziv(),dd.getAutor(),parentNodeModel);
					
				    parentNodeModel.getComponents().add(childNodeModel);
					
					dd.dispose();
					BiranjeDijalog.getInstance().dispose();
					


					DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(childNodeModel);
					
					DefaultTreeModel model = MainFrame.getInstance().getTreeHandler().getTreeModel();
					
					model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
					
				   
					
					JTree tree = MainFrame.getInstance().getTreeHandler().getTree();
					
					tree.setSelectionPath(new TreePath(childNodeView.getPath()));
					
					tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
					
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		else
		{
			System.out.println("Niste popunili naziv ili autora");
		}
		
	}
	

}
