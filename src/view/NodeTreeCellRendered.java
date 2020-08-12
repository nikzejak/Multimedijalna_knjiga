package view;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Dokument;
import model.Kolekcija;
import model.Node;
import model.Stranica;

public class NodeTreeCellRendered extends DefaultTreeCellRenderer{
	
	public NodeTreeCellRendered() {
		// TODO Auto-generated constructor stub
	}
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		if (value instanceof DefaultMutableTreeNode) {
			// ocekujemo DefaultMutableTreeNode
			// iz koga preuzimamo node
			Node node = (Node) ((DefaultMutableTreeNode) value).getUserObject();
			// do ovoga ne bi trebalo da dodje, ako je stablo pazljivo kreirano
			if (node == null) {
				return this;
			}
			// na jedan nacin iscrtavamo cvor stabla koji ima decu
			// a na drugi nacin cvor modela koji je list
			/*String iconPath = node.isRoot() ? "images/root.png"
					: (node.isLeaf() ? "images/leaf.png" : "images/internal.png");
			String text = node.getName() + ":" + (node.isRoot() ? "root" : (node.isLeaf() ? "leaf" : "internal"));
			
			setIcon(new ImageIcon(iconPath));
			setText(text);
			*/
             
			// ukoliko bismo imali cvorove u stablo modela koji pripadaju
			// razlicitim klasama, tada bismo radili sledece
			

            	if (node instanceof Kolekcija) {
            		setIcon(new ImageIcon("images/kolekcija.png"));	
            	} else if (node instanceof Dokument) {
             		setIcon(new ImageIcon("images/dokument.png"));
            	} else if (node instanceof Stranica) {
           		  setIcon(new ImageIcon("images/stranica.png"));
            	}

		}

		return this;
	}

}
