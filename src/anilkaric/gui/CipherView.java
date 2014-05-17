package anilkaric.gui;

import java.awt.GridLayout;

import javax.swing.*;

public class CipherView extends JFrame {
	JTextField eingabe,ausgabe;
	JTextField keyword,tlevel;
	JComboBox vmethode,verschiebung;
	JLabel[] labels;
	JButton ver,ent;
	CipherController c;
	public CipherView(CipherController c){
		this.c =c;
		String[] namen = {"Eingabe","Verschlüsselungsmethode","Keyword/Geheimalphabet","Verschiebung","Level","Ausgabe"};
		labels = new JLabel[namen.length];
		for(int i=0;i<namen.length;i++){
			labels[i]= new JLabel(namen[i]);
		}
		eingabe = new JTextField(7);
		ausgabe = new JTextField(7);
		ausgabe.setEditable(false);
		keyword = new JTextField(6);
		tlevel = new JTextField(3);
		String[] meth = {"SubstitionCipher","ShiftCipher","KeywordCipher","TranspositionCipher"};
		vmethode = new JComboBox<String>(meth);
		vmethode.setActionCommand("vmethode");
		vmethode.addItemListener(this.c);
		String[] v = new String[30];
		for(int i = 1;i<30;i++){
		v[i]=i+"";
		}
		verschiebung = new JComboBox<String>(v);
		verschiebung.setSelectedIndex(1);
		verschiebung.setActionCommand("versch");
		verschiebung.addItemListener(this.c);
		ver = new JButton("Verschlüsseln");
		ent = new JButton("Entschlüsseln");
		ver.setActionCommand("ver");
		ent.setActionCommand("ent");
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(9,1));
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(2,3));
		p2.add(labels[2]);
		p2.add(labels[3]);
		p2.add(labels[4]);
		p2.add(keyword);
		p2.add(verschiebung);
		p2.add(tlevel);
		p1.add(labels[0]);
		p1.add(eingabe);
		p1.add(labels[1]);
		p1.add(vmethode);
		p1.add(p2);
		p1.add(labels[5]);
		p1.add(ausgabe);
		p1.add(ver);
		p1.add(ent);
		this.add(p1);
		setSize(550,450);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public void refresh(int a){
		
	}
}
