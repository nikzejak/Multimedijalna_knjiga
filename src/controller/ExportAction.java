package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Kolekcija;
import model.Node;
import model.Stranica;
import model.Workspace;
import view.ExportDijalog;
import view.MainFrame;

public class ExportAction extends AbstractAction {

	private ExportDijalog ed;
	
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
			return;
		else if(cvor instanceof Kolekcija)
			return;
		else if(cvor instanceof Stranica)
			return;
		else
		{
			try {
				ed = new ExportDijalog();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ed.setVisible(true);
		}
	}

}
