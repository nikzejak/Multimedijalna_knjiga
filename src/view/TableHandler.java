package view;

import javax.swing.JTable;

import ObserverPackage.Observable;
import ObserverPackage.Observer;

public class TableHandler implements Observer {

    private JTable table;
 	
	private PageTableModel model;	
	
	public TableHandler() {
	
		// TODO Auto-generated constructor stub
		this.model=new PageTableModel();
		this.table=new JTable(model);
		this.table.setRowHeight(24);
		EditRemoveRenderer renderer = new EditRemoveRenderer();
		table.getColumnModel().getColumn(1).setCellRenderer(renderer);
		table.getColumnModel().getColumn(1).setCellEditor(new EditRemoveEditor());
		
		
		
	}
	
	
	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public PageTableModel getModel() {
		return model;
	}


	public void setModel(PageTableModel model) {
		this.model = model;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		this.model.fireTableDataChanged();
	}
}


