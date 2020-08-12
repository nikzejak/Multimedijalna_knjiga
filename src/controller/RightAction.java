package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import model.Node;
import model.Stranica;
import view.MainFrame;

public class RightAction extends AbstractAction {

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
		
		try {
			Node cvor_sledeci = (selektovan.getNextNode() == null)?  null : (Node)(selektovan.getNextNode()).getUserObject();
			
			if(cvor_sledeci != null)
			{
				if(cvor_sledeci instanceof Stranica)
				{
				
					if(cvor instanceof Stranica)
					{
					    if(selektovan.getNextNode() != null)
					    {
							selektovan = selektovan.getNextNode();
							Stranica selektovana = (Stranica) selektovan.getUserObject();
							JTree tree = MainFrame.getInstance().getTreeHandler().getTree();
								
								
							tree.setSelectionPath(new TreePath(selektovan.getPath()));
									
							tree.scrollPathToVisible(new TreePath(selektovan.getPath()));
							
							
					    }
							
			
					}
					else
					{
						return;
					}
				}
				else
				{
					return;
				}
			}
			else
			{
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		
		
	}
	
	

}
