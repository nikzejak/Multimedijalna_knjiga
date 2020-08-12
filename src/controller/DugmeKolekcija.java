package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.KolekcijaDijalog;
import view.MainFrame;

public class DugmeKolekcija extends AbstractAction {
	
	KolekcijaDijalog kd;
	
	public DugmeKolekcija() {
		// TODO Auto-generated constructor stub
		kd = new KolekcijaDijalog(MainFrame.getInstance(), true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		kd.setVisible(true);
	}

}
