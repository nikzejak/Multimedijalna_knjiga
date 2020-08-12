package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.MainFrame;

public class MyKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.isActionKey() || e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
			return;
		}
		JTextField txt= (JTextField) e.getComponent();
		if (txt.getText().length()==13){
			//vec je uneto 13 karaktara
			JOptionPane.showMessageDialog(null, "Mozete uneti maksimalno 13 karaktera!");
			txt.setText(txt.getText().substring(0,13));
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	  try {
		  if (e.isActionKey() || e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
				return;
			}
			char c=e.getKeyChar();
			if (c!='0' && c!='1' && c!='2' && c!='3' && c!='4' && 
				c!='5' && c!='6' && c!='7' && c!='8' && c!='9' ){
				JOptionPane.showMessageDialog(null,"Dozvoljen je upis samo brojeva");
				JTextField txt= (JTextField) e.getComponent();
				txt.setText(txt.getText().substring(0,txt.getText().length()-1));
		
	          }
	  }catch (Exception e2) {
		// TODO: handle exception
		  
	          }
		
			
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
