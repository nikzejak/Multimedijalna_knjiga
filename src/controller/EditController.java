package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import model.Dokument;
import model.Kolekcija;
import model.Node;
import model.Stranica;
import view.EditDijalog;
import view.MainFrame;

public class EditController implements ActionListener
{
	
	private EditDijalog ed;
	
	public EditController(EditDijalog ed) {
		// TODO Auto-generated constructor stub
		this.ed = ed;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
			DefaultMutableTreeNode selektovan=null;;
			try {
			selektovan = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getSelectionPath()
					.getLastPathComponent();
			} catch (Exception e2) {
				System.out.println("Nista nije selektovano!");
			}
			if (selektovan == null) {
				return;
			}
			
			
			Node cvor=(Node) selektovan.getUserObject();
			
				
				if(cvor instanceof Kolekcija)
				{
					Kolekcija k = (Kolekcija) cvor;
					k.setName(ed.getTxtNaziv());
			        	
					k.setName("Kolekcija: " +ed.getTxtNaziv());
					
					
				    MainFrame.getInstance().getTreeHandler().getTreeModel().reload();
					ed.dispose();
				}
				else if(cvor instanceof Dokument)
				{
					Dokument d = (Dokument) cvor;
					d.setName(ed.getTxtNaziv());
					d.setAutor(ed.getTxtAutor());
					
					d.setName("Dokument: " +ed.getTxtNaziv());
					
				    MainFrame.getInstance().getTreeHandler().getTreeModel().reload();
					ed.dispose();
				}						
		
	}

}
