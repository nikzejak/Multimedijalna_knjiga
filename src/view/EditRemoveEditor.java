package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

public class EditRemoveEditor extends AbstractCellEditor implements TableCellEditor {

	
	private EditRemovePanel panel;

    public EditRemoveEditor() {
    	panel = new EditRemovePanel();
    	panel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        stopCellEditing();
                    }
                });
            }
        });
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
        	panel.setBackground(table.getSelectionBackground());
        } else {
        	panel.setBackground(table.getBackground());
        }
        return panel;
    }

}
