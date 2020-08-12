package view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.atomic.DoubleAdder;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import ObserverPackage.EventType;
import model.Component;
import model.Dokument;
import model.Kolekcija;
import model.Node;
import model.Stranica;
import model.Workspace;

public class LoadDijalog extends JDialog {
		
	private JFileChooser fileChooser;
	private File fileToLoad;
	private int userSelection;
	
	public LoadDijalog() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		 fileChooser = new JFileChooser();
		 fileChooser.setDialogTitle("Ucitavanje stabla");
		 fileChooser.setApproveButtonText("Load");
		 userSelection = fileChooser.showDialog(MainFrame.getInstance(), "Load");
		 if (userSelection == JFileChooser.APPROVE_OPTION) {
			 fileToLoad = fileChooser.getSelectedFile();
			 
			 ObjectInputStream oi=new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileToLoad)));
		     
		    try {
		    	DefaultTreeModel newModel=(DefaultTreeModel)oi.readObject();
		    	//MainFrame.getInstance().setTree1(newModel);
				//MainFrame.getInstance().getTreeHandler().setTreeModel(newModel);
		    	
		    	DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
						.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		    	Workspace cvor = (Workspace)parentNodeView.getUserObject();
		    	//Workspace parentNodeModel = (Workspace)parentNodeView.getUserObject();
		    	DefaultMutableTreeNode node = (DefaultMutableTreeNode) newModel.getRoot();
		    	Workspace root =(Workspace) node.getUserObject();
		    	
		    	for(int i = 0 ; i < node.getChildCount(); i++)
		    	{
		    		DefaultMutableTreeNode kolekcija_def = (DefaultMutableTreeNode) node.getChildAt(i);
		    		Kolekcija k = (Kolekcija) kolekcija_def.getUserObject();
		    		
		    		cvor.getKolekcije().add(k);
		    		
		    		
		    		DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(k);
					
					DefaultTreeModel model = MainFrame.getInstance().getTreeHandler().getTreeModel();
					
					model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
					
				   
					
					JTree tree = MainFrame.getInstance().getTreeHandler().getTree();
					
					tree.setSelectionPath(new TreePath(childNodeView.getPath()));
					
					tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
		    		
		    		for(int j = 0; j < kolekcija_def.getChildCount(); j++)
		    		{
		    			DefaultMutableTreeNode dokument_def = (DefaultMutableTreeNode) kolekcija_def.getChildAt(j);
		    			Node n = (Node)dokument_def.getUserObject();
		    			
		    			 if(n instanceof Kolekcija)
		    			 {
		    				 Kolekcija k1 = (Kolekcija)n;
		 		    		 k.getComponents().add(k1);
		 		    		
		 		    		
		 		    		DefaultMutableTreeNode childNodeView1 = new DefaultMutableTreeNode(k1);
		 					
		 					DefaultTreeModel model1 = MainFrame.getInstance().getTreeHandler().getTreeModel();
		 					
		 					DefaultMutableTreeNode parentNodeView1 = (DefaultMutableTreeNode) MainFrame
		 							.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		 					
		 					model.insertNodeInto(childNodeView1, parentNodeView1, parentNodeView1.getChildCount());
		 					
		 				   
		 					
		 					JTree tree1 = MainFrame.getInstance().getTreeHandler().getTree();
		 					
		 					tree1.setSelectionPath(new TreePath(childNodeView1.getPath()));
		 					
		 					tree1.scrollPathToVisible(new TreePath(childNodeView1.getPath()));
		    			 }
		    			 else if(n instanceof Dokument)
		    			 {
		    				 Dokument k1 = (Dokument)n;
		 		    		 k.getComponents().add(k1);
		 		    		
		 		    		
		 		    		DefaultMutableTreeNode childNodeView1 = new DefaultMutableTreeNode(k1);
		 					
		 					DefaultTreeModel model1 = MainFrame.getInstance().getTreeHandler().getTreeModel();
		 					
		 					DefaultMutableTreeNode parentNodeView1 = (DefaultMutableTreeNode) MainFrame
		 							.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
		 					
		 					model.insertNodeInto(childNodeView1, parentNodeView1, parentNodeView1.getChildCount());
		 					
		 				   
		 					
		 					JTree tree1 = MainFrame.getInstance().getTreeHandler().getTree();
		 					
		 					tree1.setSelectionPath(new TreePath(childNodeView1.getPath()));
		 					
		 					tree1.scrollPathToVisible(new TreePath(childNodeView1.getPath()));
		 					
		 				    k1.getStranice().removeAll(k1.getStranice());
		 					
		 					for(int t = 0; t < dokument_def.getChildCount(); t++)
			    			{
			    				
			    				
			    				DefaultMutableTreeNode stranica_def = (DefaultMutableTreeNode) dokument_def.getChildAt(t);
			    				Stranica s = (Stranica)stranica_def.getUserObject();
			    				Stranica s1 = new Stranica(s.getName(),s.getParent(),s.getId());
			    				k1.getStranice().add(s1);
			    				s1.addObserver(MainFrame.getInstance().getTreeHandler());
								s1.addObserver(MainFrame.getInstance().getTableHandler());

							    s1.notifyObservers(EventType.ADDED);
			    				
				
			    				
			    			}
		    			 }
		    			
		    			 	    			
		    			
		    		}
		    	}
		    	
		    	
		    	
			} finally { 	
				// TODO: handle finally clause
				oi.close();
			}
		 
		 }
	}
}
