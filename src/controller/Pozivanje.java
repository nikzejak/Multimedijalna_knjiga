package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;
import model.Kolekcija;
import model.Node;
import model.Stranica;
import view.BiranjeDijalog;
import view.KolekcijaDijalog;
import view.MainFrame;
import view.StranicaDijalog;

public class Pozivanje extends AbstractAction {
	
	
	MainFrame mf;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		try {
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getSelectionPath().getLastPathComponent();
			Node cvor = (Node)sel.getUserObject();
			if(cvor instanceof Kolekcija)
			{
			    BiranjeDijalog AD = new BiranjeDijalog(MainFrame.getInstance(), true);
			    AD.setLocationRelativeTo(MainFrame.getInstance());
			    AD.setVisible(true);
			}
			else if(cvor instanceof Dokument)
			{
				StranicaDijalog AP = new StranicaDijalog(MainFrame.getInstance(),true);
				AP.setLocationRelativeTo(MainFrame.getInstance());
			    AP.setVisible(true);
			}
			else if(cvor instanceof Stranica)
			{
				return;
			}
			else{
					KolekcijaDijalog KD=new KolekcijaDijalog(MainFrame.getInstance(), true);
					KD.setLocationRelativeTo(MainFrame.getInstance());
					KD.setVisible(true);
				}
		}
		catch(Exception e1)
		{
			System.out.println("Niste odabrali dobar cvor");
		}
		
	}

}
