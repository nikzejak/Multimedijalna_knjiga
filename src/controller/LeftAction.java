package controller;

import java.awt.event.ActionEvent;

import javax.management.MalformedObjectNameException;
import javax.swing.AbstractAction;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import model.Dokument;
import model.Node;
import model.Stranica;
import view.MainFrame;

public class LeftAction extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode selektovan=null;
		try {
		selektovan = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getSelectionPath()
				.getLastPathComponent();
		} catch (Exception e2) {
			System.out.println("Nist selektovali stranicu");
			
		}
	
		
		if (selektovan == null) {
			return;
		}
		
		Node cvor=(Node) selektovan.getUserObject();
		if(cvor instanceof Stranica)
		{
			selektovan = selektovan.getPreviousNode();
			try {
				Stranica selektovana = (Stranica) selektovan.getUserObject();
				JTree tree = MainFrame.getInstance().getTreeHandler().getTree();
				
				if(selektovana instanceof Stranica)
				{
					tree.setSelectionPath(new TreePath(selektovan.getPath()));
					
					tree.scrollPathToVisible(new TreePath(selektovan.getPath()));
				}
				else
				{
					return;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			

		}
		else
		{
			return;
		}
	}

}
