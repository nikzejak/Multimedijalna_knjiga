package view;

import javax.swing.UIManager;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try { 
			  
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel"); 
        } 
        catch (Exception e) { 
            System.out.println("Look and Feel not set"); 
        }
		
		
		MainFrame mf = MainFrame.getInstance();
		mf.setVisible(true);
			
	}

}
