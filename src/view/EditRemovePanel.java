package view;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.RemovePageAction;

public class EditRemovePanel extends JPanel {
	
   private JButton remove;
	
	public EditRemovePanel() {
		setLayout(new GridBagLayout());
		remove = new JButton("Remove");

		add(remove);

        remove.addActionListener(new RemovePageAction());
	}
	
	public void addActionListener(ActionListener listener) {
		remove.addActionListener(listener);
    }

}
