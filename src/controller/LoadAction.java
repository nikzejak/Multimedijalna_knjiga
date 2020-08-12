package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Node;
import model.Workspace;
import view.ExportDijalog;
import view.LoadDijalog;
import view.MainFrame;

public class LoadAction extends AbstractAction {
	
	private LoadDijalog ld;

	@Override
	public void actionPerformed(ActionEvent e) {
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
		{
			try {
				ld = new LoadDijalog();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ld.setVisible(true);
		}
		else
			return;
		
	}

}
