package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Node;
import model.Stranica;
import model.Workspace;
import view.EditDijalog;
import view.MainFrame;

public class EditAction extends AbstractAction {
	
	public EditAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		DefaultMutableTreeNode selektovan=null;
		try {
		selektovan = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getSelectionPath()
				.getLastPathComponent();
		} catch (Exception e2) {
			System.out.println("Nista nije selektovano");
			
		}
	
		
		if (selektovan == null) {
			return;
		}
		
		Node cvor=(Node) selektovan.getUserObject();
		
		if(cvor instanceof Workspace)
			return;
		else if(cvor instanceof Stranica)
			return;
		else
		{
		
			EditDijalog ED=new EditDijalog(MainFrame.getInstance(), true);
			ED.setLocationRelativeTo(MainFrame.getInstance());
			ED.setVisible(true);
		}
		
	}
	
	

}
