package view;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class SaveDijalog extends JDialog {


	private JFileChooser fileChooser;
	private File fileToSave;
	private int userSelection;
	
	public SaveDijalog() throws FileNotFoundException, IOException
	{
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Cuvanje stabla");   
		 
		userSelection = fileChooser.showSaveDialog(MainFrame.getInstance());
		
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			
			fileToSave = fileChooser.getSelectedFile();
		     
		     ObjectOutputStream os=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileToSave)));
		     
		     try {
		    	 os.writeObject(MainFrame.getInstance().getTreeHandler().getTreeModel());
			} finally {
				// TODO: handle finally clause
				os.close();
			} 
		
		}
		
		
	}
}
