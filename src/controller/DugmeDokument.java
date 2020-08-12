package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.DokumentDijalog;
import view.MainFrame;

public class DugmeDokument extends AbstractAction {

	DokumentDijalog dd;
	
	 public DugmeDokument() {
		// TODO Auto-generated constructor stub
		 dd = new DokumentDijalog(MainFrame.getInstance(), true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		dd.setVisible(true);
		
		
	}

}
