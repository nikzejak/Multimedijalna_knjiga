package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;
import view.MainFrame;
import view.PageTableModel;

public class OpenBook extends AbstractAction {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)
	                MainFrame.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
			
		     if (node == null) return;
		     Object nodeInfo = node.getUserObject();
		     if (nodeInfo instanceof Dokument) {
		    	 Dokument b = (Dokument)nodeInfo;
		     	((PageTableModel) MainFrame.getInstance().getTableHandler().getModel())
		     	.setTableData(b.getStranice());
		    	MainFrame.getInstance().cl.show(MainFrame.getInstance().panel1, "2");
		        MainFrame.getInstance().setCitanje(true);
		}

	
    }
}
