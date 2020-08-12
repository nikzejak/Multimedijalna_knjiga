package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CancelButton;
import controller.NovaKolekcija;

public class KolekcijaDijalog extends JDialog {
	
	private JLabel lblNaziv;
	private JTextField txtNaziv= new JTextField();
	
	private JButton dodaj;
	private JButton cancel;
	
	public KolekcijaDijalog(JFrame owner,boolean modal)
	{
		super(owner, modal);
		lblNaziv = new JLabel("Naziv: ");
		
		setTitle("Dodavanje kolekcije");		
		setLocationRelativeTo(null);
		
		JPanel p2= new JPanel();
		p2.setLayout(new GridLayout(1, 2));
		p2.add(lblNaziv);
		p2.add(txtNaziv);
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(1, 1));
		p1.add(p2);
		
		JPanel p3= new JPanel();
		p3.setLayout(new GridLayout(1, 2));
		dodaj = new JButton("Dodaj");
		dodaj.addActionListener(new NovaKolekcija(this));
		cancel = new JButton("Odustani");
		cancel.addActionListener(new CancelButton(this));
		p3.add(dodaj);
		p3.add(cancel);
		
		setLayout(new BorderLayout());
		add(p1,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		pack();
		
	}
	
	public String getNaziv() {

		return txtNaziv.getText();
	}
	

}
