package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

import controller.CancelButton;
import controller.EditController;
import controller.MyKeyListener;
import model.Dokument;
import model.Kolekcija;
import model.Node;
import model.Stranica;

public class EditDijalog extends JDialog {
	
	private JLabel lblNazivK;
	private JLabel lblNazivD;
	private JLabel lblAutorD;
	private JLabel lblBrojS;
	
	private JTextField txtNaziv = new JTextField();
	private JTextField txtAutor = new JTextField();
	private JTextField txtBroj = new JTextField();
	
	private JButton izmeniK;
	private JButton cancelK;
	
	private JButton izmeniD;
	private JButton cancelD;
	
	private JButton izmeniS;
	private JButton cancelS;
	
	public EditDijalog(JFrame owner, boolean modal)
	{
		super(owner,modal);
		
		
		
		DefaultMutableTreeNode selektovan=null;
		try {
		selektovan = (DefaultMutableTreeNode) MainFrame.getInstance().getTreeHandler().getTree().getSelectionPath()
				.getLastPathComponent();
		} catch (Exception e2) {
			System.out.println("Nista nije selektovano");
			
		}
	
		
		if (selektovan == null) {
			this.dispose();
			return;
		}
		
		Node cvor=(Node) selektovan.getUserObject();
		
		
		
		if(cvor instanceof Kolekcija)
		{
			Kolekcija k = (Kolekcija) cvor;
			setTitle("Izmena podataka o kolekciji");
			lblNazivK = new JLabel("Naziv: ");
			
			String[] splited = k.getName().split(":");
			String naziv = splited[1];
			
			txtNaziv.setText(naziv);
			init1();
			
		}
		else if(cvor instanceof Dokument)
		{
			Dokument d = (Dokument) cvor;
			setTitle("Izmena podataka o dokumentu");
			lblNazivD = new JLabel("Naziv: ");
			lblAutorD = new JLabel("Autor: ");
			
			String[] splited = d.getName().split(":");
			String naziv = splited[1];
			
			txtNaziv.setText(naziv);
			txtAutor.setText(d.getAutor());
			
			init2();
		}
		else if(cvor instanceof Stranica)
		{
			try {
				return;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error");
			}
			
		}
		
		/*
		else if(cvor.isPage() == true)
		{
			setTitle("Izmena podataka o stranici");
			lblBrojS = new JLabel("Broj: ");
			txtBroj.setText(Integer.toString(cvor.getStranica().getBrojStranice()));
			init3();
		}*/
		
		
	}
	
	public void init1()
	{
		setLocationRelativeTo(null);
		
		JPanel p2= new JPanel();
		p2.setLayout(new GridLayout(1, 2));
		p2.add(lblNazivK);
		p2.add(txtNaziv);
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(1, 1));
		p1.add(p2);
		
		JPanel p3= new JPanel();
		p3.setLayout(new GridLayout(1, 2));
		izmeniK = new JButton("Izmeni");
	    izmeniK.addActionListener(new EditController(this));
		cancelK = new JButton("Odustani");
		cancelK.addActionListener(new CancelButton(this));
		p3.add(izmeniK);
		p3.add(cancelK);
		
		setLayout(new BorderLayout());
		add(p1,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		pack();
	}
	
	public void init2()
	{
        setLocationRelativeTo(null);
		
		JPanel p2= new JPanel();
		p2.setLayout(new GridLayout(1, 2));
		p2.add(lblNazivD);
		p2.add(txtNaziv);
		
		JPanel p4= new JPanel();
		p4.setLayout(new GridLayout(1, 2));
		p4.add(lblAutorD);
		p4.add(txtAutor);
		
		
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(2, 1));
		p1.add(p2);
		p1.add(p4);
		
		JPanel p3= new JPanel();
		p3.setLayout(new GridLayout(1, 2));
		izmeniD = new JButton("Izmeni");
		izmeniD.addActionListener(new EditController(this));
		cancelD = new JButton("Odustani");
		cancelD.addActionListener(new CancelButton(this));
		p3.add(izmeniD);
		p3.add(cancelD);
		
		setLayout(new BorderLayout());
		add(p1,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		pack();
	}
	
	public void init3()
	{
		setLocationRelativeTo(null);
		
        txtBroj.addKeyListener(new MyKeyListener());
		
		JPanel p2= new JPanel();
		p2.setLayout(new GridLayout(1, 2));
		p2.add(lblBrojS);
		p2.add(txtBroj);
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(1, 1));
		p1.add(p2);
		
		JPanel p3= new JPanel();
		p3.setLayout(new GridLayout(1, 2));
		izmeniS = new JButton("Izmeni");
		izmeniS.addActionListener(new EditController(this));
		cancelS = new JButton("Odustani");
		cancelS.addActionListener(new CancelButton(this));
		p3.add(izmeniS);
		p3.add(cancelS);
		
		setLayout(new BorderLayout());
		add(p1,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		pack();
	}

	public String getTxtNaziv() {
		return txtNaziv.getText();
	}

	public String getTxtAutor() {
		return txtAutor.getText();
	}

	public String getTxtBroj() {
		return txtBroj.getText();
	}
	
	

}
