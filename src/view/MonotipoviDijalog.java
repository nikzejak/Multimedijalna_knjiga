package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CancelButton;

public class MonotipoviDijalog extends JDialog {
	
	private JLabel labeltext;
	private JButton buttonOk;
	private JCheckBox audio;
	private JCheckBox tekst;
	private JCheckBox slika;
	private JCheckBox animacija;
	private JCheckBox video;
		
	
	public MonotipoviDijalog(JFrame owner, boolean modal)
	{
		labeltext = new JLabel("Izaberite monotipove koje ce koristiti dokument   ");
		setTitle("Odabir monotipova");
		setLocationRelativeTo(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 1));
		p1.add(labeltext);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 1));
		audio = new JCheckBox("Audio",false);
		p2.add(audio);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1, 1));
		tekst = new JCheckBox("Tekst",false);
		p3.add(tekst);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1, 1));
		slika = new JCheckBox("Slika",false);
		p4.add(slika);
		
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(1, 1));
		animacija = new JCheckBox("Animacija",false);
		p5.add(animacija);
		
		JPanel p6 = new JPanel();
		p6.setLayout(new GridLayout(1, 1));
		video = new JCheckBox("Video",false);
		p6.add(video);
		
		JPanel p8 = new JPanel();
		p8.setLayout(new GridLayout(1, 1));
		buttonOk = new JButton("Ok");
		buttonOk.addActionListener(new CancelButton(this));
		p8.add(buttonOk);
		
		JPanel p7 = new JPanel();
		p7.setLayout(new GridLayout(6, 1));
		p7.add(p1);
		p7.add(p2);
		p7.add(p3);
		p7.add(p4);
		p7.add(p5);
		p7.add(p6);
		
		setLayout(new BorderLayout());
		add(p7,BorderLayout.CENTER);
		add(p8,BorderLayout.SOUTH);
		pack();
	}

}
