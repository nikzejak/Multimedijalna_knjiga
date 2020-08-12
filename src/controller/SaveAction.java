package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Node;
import model.Workspace;
import view.MainFrame;
import view.SaveDijalog;

public class SaveAction extends AbstractAction {

	private SaveDijalog sd;
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
				sd = new SaveDijalog();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			sd.setVisible(true);
		}
		else
		{
			return;
		}
	}
	

}
