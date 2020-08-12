package view;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;


public class ExportDijalog extends JDialog {
	
	private JFileChooser fileChooser;
	private File fileToSave;
	private int userSelection;

	public ExportDijalog() throws IOException
	{
		 fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Cuvanje dokumenta");   
		 
		 userSelection = fileChooser.showSaveDialog(MainFrame.getInstance());
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		     fileToSave = fileChooser.getSelectedFile();
		     
		     ObjectOutputStream os=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileToSave)));
				
				try {
						DefaultMutableTreeNode parentNodeView = (DefaultMutableTreeNode) MainFrame
								.getInstance().getTreeHandler().getTree().getLastSelectedPathComponent();
						// nema sta da se dodaje
						if (parentNodeView == null) {
							return;
						}
						
						Dokument parentNodeModel = (Dokument)parentNodeView.getUserObject();
						Dokument zaCuvanje = new Dokument(parentNodeModel.getName(),parentNodeModel.getAutor(),parentNodeModel.getStranice());
					    os.writeObject(zaCuvanje);
				} finally {
					os.close();
				}
		     
		    //System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		}
	}
}
