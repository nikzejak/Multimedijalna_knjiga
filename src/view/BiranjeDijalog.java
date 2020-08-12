package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.DugmeDokument;
import controller.DugmeKolekcija;

public class BiranjeDijalog extends JDialog {
	
	private JLabel lblTekst;
	
	private JButton dodajKolekciju;
	private JButton dodajDokument;
	
	private static BiranjeDijalog instance;
	
    public BiranjeDijalog() {
    	
    }
	
	public BiranjeDijalog(JFrame owner,boolean modal) {
		
		super(owner, modal);
		instance = this;
		
		setTitle("Biranje");		
		setLocationRelativeTo(null);
		
		
		
		lblTekst = new JLabel("Izaberite sta zelite da dodate: ");
		
		JPanel p2= new JPanel();
		p2.setLayout(new GridLayout(1, 2));
		p2.add(lblTekst);
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(1, 1));
		p1.add(p2);
		
		JPanel p3= new JPanel();
		p3.setLayout(new GridLayout(1, 2));
		dodajKolekciju = new JButton("Kolekcija");
		dodajDokument = new JButton("Dokument");
		dodajKolekciju.addActionListener(new DugmeKolekcija());
		dodajDokument.addActionListener(new DugmeDokument());
		
		
		p3.add(dodajKolekciju);
		p3.add(dodajDokument);
		
		setLayout(new BorderLayout());
		add(p1,BorderLayout.CENTER);
		add(p3,BorderLayout.SOUTH);
		pack();
		
		
	}
	
	 public static BiranjeDijalog getInstance(){
			
		 if(instance==null){
			 instance = new BiranjeDijalog();
		 
		 }
		 
		 return instance; 
	 }

}
