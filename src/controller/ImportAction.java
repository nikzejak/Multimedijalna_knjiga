package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;
import model.Kolekcija;
import model.Node;
import model.Stranica;
import model.Workspace;
import view.ExportDijalog;
import view.ImportDijalog;
import view.MainFrame;

public class ImportAction extends AbstractAction {

    private ImportDijalog id;
	
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
		else if(cvor instanceof Dokument)
			return;
		else if(cvor instanceof Stranica)
			return;
		else
		{
			try {
				id = new ImportDijalog();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			id.setVisible(true);
		}
		
	}

}
