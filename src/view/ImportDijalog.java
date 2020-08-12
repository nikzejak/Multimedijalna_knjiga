package view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import ObserverPackage.EventType;
import model.Dokument;
import model.Kolekcija;
import model.Stranica;

public class ImportDijalog extends JDialog {

	private JFileChooser fileChooser;
	private File fileToLoad;
	private int userSelection;
	
	public ImportDijalog() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		 fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Ucitavanje dokumenta");
		fileChooser.setApproveButtonText("Load");
		 userSelection = fileChooser.showDialog(MainFrame.getInstance(), "Load");
		 
		 if (userSelection == JFileChooser.APPROVE_OPTION) {
		     fileToLoad = fileChooser.getSelectedFile();
		     
		     ObjectInputStream oi=new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileToLoad)));
		     try {
		    	 
		    	 DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
							.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
					// nema sta da se dodaje
					if (parentNodeView == null) {
						return;
					}
					
					Kolekcija parentNodeModel = (Kolekcija)parentNodeView.getUserObject();
					
					Dokument childNodeModel = (Dokument)oi.readObject();
					Dokument d = new Dokument(childNodeModel.getName(),childNodeModel.getAutor(),parentNodeModel);
					//childNodeModel.getStranice();
					
					parentNodeModel.getComponents().add(d);
					
                    DefaultMutableTreeNode childNodeView = new DefaultMutableTreeNode(d);
                    
					
					DefaultTreeModel model = MainFrame.getInstance().getTreeHandler().getTreeModel();
					
					model.insertNodeInto(childNodeView, parentNodeView, parentNodeView.getChildCount());
					
									
					JTree tree = MainFrame.getInstance().getTreeHandler().getTree();
					
					tree.setSelectionPath(new TreePath(childNodeView.getPath()));
					
					tree.scrollPathToVisible(new TreePath(childNodeView.getPath()));
					
					/*
					model = MainFrame.getInstance().getTreeHandler().getTreeModel();
					for(int i = 0 ; i < d.getStranice().size(); i++)
					{
						DefaultMutableTreeNode childNodeView1 = new DefaultMutableTreeNode(d.getStranice().get(i));
						model.insertNodeInto(childNodeView1, childNodeView, i);
						
						
						 tree = MainFrame.getInstance().getTreeHandler().getTree();
						
						tree.setSelectionPath(new TreePath(childNodeView1.getPath()));
						
						tree.scrollPathToVisible(new TreePath(childNodeView1.getPath()));
					
					*/
					System.out.println(d.getStranice().size() + "\n\n");
					
					for(int i = 0; i < childNodeModel.getStranice().size();i++)
					{
						
						Stranica s = new Stranica(childNodeModel.getStranice().get(i).getName(),d,childNodeModel.getStranice().get(i).getId());
						d.getStranice().add(s);
						s.addObserver(MainFrame.getInstance().getTreeHandler());
						s.addObserver(MainFrame.getInstance().getTableHandler());

						s.notifyObservers(EventType.ADDED);
					}
				
			} finally {
				oi.close();
			}
		 }
	}
}
