package view;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.Brisanje;
import controller.CloseBook;
import controller.EditAction;
import controller.ExportAction;
import controller.ImportAction;
import controller.LeftAction;
import controller.LoadAction;
import controller.MonotipAction;
import controller.OpenBook;
import controller.Pozivanje;
import controller.RightAction;
import controller.SaveAction;
import model.Dokument;
import model.Node;

public class Toolbar extends JToolBar {
	
	private JButton newB;
	private JButton deleteB;
	private JButton editB;
	private JButton importB;
	private JButton exportB;
	private JButton leftB;
	private JButton rightB;
	private JButton saveB;
	private JButton loadB;
	private JButton monotipB;
	private JButton readB;
	private JButton closeB;
	
	public Toolbar()
	{
		
			
		
		newB = new JButton("");
		newB.setHideActionText(true);
		newB.setToolTipText("New");
		newB.setIcon(new ImageIcon("images/new.jpg"));
		newB.addActionListener(new Pozivanje());
		
		add(newB);
		addSeparator();
		
		deleteB = new JButton("");
		deleteB.setToolTipText("Delete");
		deleteB.setHideActionText(true);
		deleteB.setIcon(new ImageIcon("images/delete.png"));
		deleteB.addActionListener(new Brisanje());
		
		add(deleteB);
		addSeparator();
		
		editB = new JButton("");
		editB.setToolTipText("Edit");
	    editB.addActionListener(new EditAction());
		
		
		editB.setHideActionText(true);
		editB.setIcon(new ImageIcon("images/edit.png"));
		add(editB);
		addSeparator();
		
	    importB = new JButton("");
	    importB.setToolTipText("Import");
	    importB.setHideActionText(true);
	    importB.setIcon(new ImageIcon("images/import.png"));
	    importB.addActionListener(new ImportAction());
	    add(importB);
	    addSeparator();
	    
	    exportB = new JButton("");
	    exportB.setToolTipText("Export");
	    exportB.setHideActionText(true);
	    exportB.setIcon(new ImageIcon("images/export.png"));
	    exportB.addActionListener(new ExportAction());
	    add(exportB);
	    addSeparator();
	    
	    
	    saveB = new JButton("");
	    saveB.setToolTipText("Save");
	    saveB.setIcon(new ImageIcon("images/save.jpg"));
	    saveB.setHideActionText(true);
	    saveB.addActionListener(new SaveAction());
	    add(saveB);
	    addSeparator();
	    
	    loadB = new JButton("");
	    loadB.setToolTipText("Load");
	    loadB.setIcon(new ImageIcon("images/load.png"));
	    loadB.setHideActionText(true);
	    loadB.addActionListener(new LoadAction());
	    add(loadB);
	    addSeparator();
	    
	    monotipB = new JButton("");
	    monotipB.setToolTipText("Monotipovi");
	    monotipB.setIcon(new ImageIcon("images/monotip.png"));
	    monotipB.setHideActionText(true);
	    monotipB.addActionListener(new MonotipAction());
	    add(monotipB);
	    addSeparator();
	    
	    readB = new JButton("");
	    readB.setToolTipText("Otvaranje knjige");
	    readB.setIcon(new ImageIcon("images/read.png"));
	    readB.setHideActionText(true);
	    readB.addActionListener(new OpenBook());
	    add(readB);
	    addSeparator();
	    
	    closeB = new JButton("");
	    closeB.setToolTipText("Zatvaranje knjige");
	    closeB.setIcon(new ImageIcon("images/closeB.png"));
	    closeB.setHideActionText(true);
	    closeB.addActionListener(new CloseBook());
	    add(closeB);
	    addSeparator();
	    
	    add(Box.createHorizontalGlue());
	    
	    leftB = new JButton("");
	    leftB.setToolTipText("Left");
	    leftB.setIcon(new ImageIcon("images/levo.png"));
	    leftB.setHideActionText(true);
	    leftB.addActionListener(new LeftAction());
	    add(leftB);
	    addSeparator();
	    
	    rightB = new JButton("");
	    rightB.setToolTipText("Right");
	    rightB.setIcon(new ImageIcon("images/desno.png"));
	    rightB.setHideActionText(true);
	    rightB.addActionListener(new RightAction());
	    add(rightB);
	    addSeparator();
	    
		
	}
	
}
