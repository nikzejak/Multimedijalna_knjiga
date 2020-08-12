package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class CancelButton implements ActionListener{

	private JDialog JD;
	
	 public CancelButton(JDialog jd) {
		this.JD=jd;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JD.dispose();
	}

}
