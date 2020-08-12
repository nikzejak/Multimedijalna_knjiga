package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;
import model.Node;
import view.ExportDijalog;
import view.MainFrame;
import view.MonotipoviDijalog;

public class MonotipAction extends AbstractAction {

	private MonotipoviDijalog m;
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
		
		if(cvor instanceof Dokument)
		{
			m = new MonotipoviDijalog(MainFrame.getInstance(),true);
			m.setVisible(true);
		}
		else
			return;
		
	}
	
}
