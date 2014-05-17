package anilkaric.gui;

import java.awt.GridLayout;

import javax.swing.*;
/**
 * View-Klasse von Cipher
 * @author Adin Karic
 * @author Rohat Anil
 * @version 2014-05-17
 */
public class CipherView extends JFrame {
	//verschiedene Grafikelemente als Attribute
	JTextField eingabe,ausgabe;
	JTextField keyword,tlevel;
	JComboBox vmethode,verschiebung;
	JLabel[] labels;
	JButton ver,ent;
	//CipherController
	CipherController c;
	/**
	 * Der Konstruktor der CipherView-Klasse
	 * @param c ein CipherController-Objekt
	 */
	public CipherView(CipherController c){
		//Attribute werden intialisert
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
		String[] meth = {"SubstitutionCipher","ShiftCipher","KeywordCipher","TranspositionCipher"};
		vmethode = new JComboBox<String>(meth);
		//Listener werden geaddet
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
		ver.addActionListener(this.c);
		ent.addActionListener(this.c);
		this.tlevel.setEditable(false);
		this.verschiebung.setEnabled(false);
		this.keyword.setEditable(true);
		//den Paneln werden die Elemente hinzugefügt
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
		//das panel wird dem jframe hinzugefügt
		this.add(p1);
		//größe,sichtbarkeit,position etc. wird gesetzt
		setSize(550,450);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


	}
	/**
	 * refresh-Methode um grafikelemente der gui zu aktualisieren
	 * @param a bestimmt was enabled wird und was nicht
	 * @param ausgab verschlüsselter oder entschlüsselter text
	 */
	public void refresh(int a,String ausgab){
		switch(a){
		//wenn keywordcipher oder substitutioncipher ausgewählt werden
		case 1:
			this.tlevel.setEditable(false);
			this.verschiebung.setEnabled(false);
			this.keyword.setEditable(true);
			break;
			//wenn shiftcipher ausgewählt wird
		case 2:
			this.tlevel.setEditable(false);
			this.keyword.setEditable(false);
			this.verschiebung.setEnabled(true);
			break;
			//wenn transpositioncipher ausgewählt wird
		case 3:
			this.verschiebung.setEnabled(false);
			this.keyword.setEditable(false);
			this.tlevel.setEditable(true);
			break;
			//wenn ein fehler auftritt
		case 4:
			JOptionPane.showMessageDialog(null,"Ein Fehler ist aufgetreten!\nBitte überprüfen Sie ihre Eingaben!");
		}
		//ausgabetext wird geändert
		this.ausgabe.setText(ausgab);
	}
	/**
	 * getter-Methode für das Keyword/geheimalphabet textfeld
	 * @return der text im textfeld
	 */
	public String getKeyWordGeheimAlphabet(){
		return this.keyword.getText();
	}
	/**
	 * getter-Methode für das level textfeld
	 * @return der text im textfeld
	 */
	public String getLevel(){
		return this.tlevel.getText();
	}
	/**
	 * getter-Methode für das Eingabetextfeld
	 * @return der text im textfeld
	 */
	public String getEingabe(){
		return eingabe.getText();
	}
}
