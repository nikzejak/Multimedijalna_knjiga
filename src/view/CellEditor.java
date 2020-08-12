package view;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;

import model.Node;

public class CellEditor extends DefaultTreeCellEditor {
	
	private Node selectedNode;

	/**
	 * @param tree
	 * @param renderer
	 */
	public CellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
		super(tree, renderer);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tree
	 * @param renderer
	 * @param editor
	 */
	public CellEditor(JTree tree, DefaultTreeCellRenderer renderer, TreeCellEditor editor) {
		super(tree, renderer, editor);
	}

	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row) {
		// preuzmemo trenutno selektovani cvor
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getSelectionPath()
				.getLastPathComponent();
		// preuzimamo odgovarajuci cvor modela
		this.selectedNode = (Node)sel.getUserObject();
		return super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
	}

	@Override
	public Object getCellEditorValue() {
		// preuzimamo unos korisnika
		String newName = (String) super.getCellEditorValue();
		// postavljanje imena
		this.selectedNode.setName((String)newName);
		return this.selectedNode;
	}

	@Override
	public boolean stopCellEditing() {
		return false;
	}

}
