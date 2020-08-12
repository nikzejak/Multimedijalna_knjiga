package view;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class EditRemoveRenderer extends DefaultTableCellRenderer {

    private EditRemovePanel editRemovePanel;
	
	public EditRemoveRenderer() {
		this.editRemovePanel = new EditRemovePanel();
	}
	
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
        	editRemovePanel.setBackground(table.getSelectionBackground());
        } else {
        	editRemovePanel.setBackground(table.getBackground());
        }
        return editRemovePanel;
    }
}
