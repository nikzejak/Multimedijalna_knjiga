package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ObserverPackage.EventType;
import model.Stranica;
import view.MainFrame;
import view.PageTableModel;

public class RemovePageAction extends AbstractAction {

	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int selectedRow = MainFrame.getInstance().getTableHandler().getTable().getSelectedRow();
		
		
		Stranica page = ((PageTableModel)MainFrame.getInstance().getTableHandler().getTable().getModel()).getValueAt(selectedRow);
		
		page.getParent().getStranice().remove(page);
		
		page.notifyObservers(EventType.REMOVED);
	}

	
}
