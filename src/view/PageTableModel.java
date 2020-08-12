package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import model.Stranica;

public class PageTableModel extends AbstractTableModel {

	private List<Stranica> stranice;
	
	public PageTableModel() {
		this.stranice=new ArrayList<>();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return stranice.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Stranica page = stranice.get(rowIndex);
		Object value = null;
		switch(columnIndex) {
		case 0:
			value = page.getName();
			break;
		case 1:
			break;
	}
		return value;
		
	}
	
	public Stranica getValueAt(int rowIndex) {
		return stranice.get(rowIndex);
	}
	

	public void setTableData(List<Stranica> pages) {
		this.stranice=pages;
		fireTableDataChanged();
	}
	
	public String getColumnName(int column) {
		String value = null;
        switch (column) {
            case 0:
                value = "Stranica";
                break;
            case 1:
                value = "Remove";
                break;
        }
        return value;
    }
	  public boolean isCellEditable(int rowIndex, int columnIndex) {
	        return columnIndex == 1;
	    }

	public List<Stranica> getPages() {
		return stranice;
	}

	public void setPages(List<Stranica> pages) {
		this.stranice = pages;
	}
}
