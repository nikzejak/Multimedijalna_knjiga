package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import ObserverPackage.EventType;
import model.Dokument;
import model.Node;
import model.Stranica;
import view.BiranjeDijalog;
import view.MainFrame;
import view.StranicaDijalog;

public class NovaStranica extends AbstractAction {

	private StranicaDijalog sd;
	
	public NovaStranica(StranicaDijalog sd) {
		// TODO Auto-generated constructor stub
		
		this.sd = sd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    
		//if(sd.getBroj().isEmpty() != true)
		//{
			try {
				
				DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
				// nema sta da se dodaje
				if (parentNodeView == null) {
					return;
				}
				
				   
					Dokument parentNodeModel = (Dokument)parentNodeView.getUserObject();
				    
					String id = parentNodeModel.getName() + " " + (parentNodeModel.getStranice().size() + 1);
					
					Stranica childNodeModel = new Stranica("Stranica",parentNodeModel,id);
					
				    parentNodeModel.getStranice().add(childNodeModel);
					
					sd.dispose();
					
					childNodeModel.addObserver(MainFrame.getInstance().getTreeHandler());
					childNodeModel.addObserver(MainFrame.getInstance().getTableHandler());

					childNodeModel.notifyObservers(EventType.ADDED);
					
					
					
					
					
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Pogresan unos broja stranice!");
			}
		}
	 
		
	
	

}
