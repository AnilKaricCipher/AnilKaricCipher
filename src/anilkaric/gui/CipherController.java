package anilkaric.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import anilkaric.Cipher;
import anilkaric.KeyWordCipher;
import anilkaric.MonoAlphabeticCipher;
import anilkaric.MyException;
import anilkaric.ShiftCipher;
import anilkaric.SubstitutionCipher;
import anilkaric.TranspositionCipher;
import anilkaric.gui.CipherView;
/**
 * Controller-Klasse für Cipher
 * @author Adin Karic
 * @version 2014-05-17
 */
public class CipherController implements ActionListener,ItemListener {
	//Attribute mit den verschiedenen Cipher-Arten
	private TranspositionCipher trans;
	private SubstitutionCipher subst;
	private ShiftCipher shift;
	private KeyWordCipher key;
	private CipherView view;
	private String ausgab="";
	private String meth="SubstitutionCipher";
	private int ver;
	private int load;
	/**
	 * Konstruktor des Controllers
	 * @throws MyException
	 */
	public CipherController() throws MyException{
		//Attribute werden initialisert
		trans = new TranspositionCipher(2);
		subst = new SubstitutionCipher("ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß");
		shift = new ShiftCipher(1);
		key = new KeyWordCipher("WORLD");
		view = new CipherView(this);
	}
	/**
	 * Die methode die ausgeführt wird wenn einer der beiden Jbuttons geklickt wird
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton b = (JButton)arg0.getSource();
		try{
			switch(b.getActionCommand()){
			//wenn es der verschlüsseln button ist
			case "ver":
				//Je nachdem welche methode in der ComboBox ausgewählt ist wird eine andere encrypt methode verwendet und in die ausgabe gespeichert
				switch(meth){
				case "SubstitutionCipher":
					subst.setSecretAlphabet(this.view.getKeyWordGeheimAlphabet());
					this.ausgab = subst.encrypt(this.view.getEingabe());
					break;
				case "ShiftCipher":
					shift.setShiftAmount(ver);
					this.ausgab = shift.encrypt(this.view.getEingabe());

					break;
				case "KeywordCipher":
					key.setKeyword(this.view.getKeyWordGeheimAlphabet());
					this.ausgab = key.encrypt(this.view.getEingabe());

					break;
				case "TranspositionCipher":
					trans.setTranspositionLevel(Integer.parseInt(this.view.getLevel()));
					this.ausgab = trans.encrypt(this.view.getEingabe());

					break;
				}
				break;
				//wenn der entschlüsseln JButton geklickt wird
			case "ent":
				//je nachdem welche Chipher Art in der ComboBox ausgewählt wurde wird eine andere decrypt methode verwendet
				switch(meth){
				case "SubstitutionCipher":
					subst.setSecretAlphabet(this.view.getKeyWordGeheimAlphabet());
					this.ausgab = subst.decrypt(this.view.getEingabe());
					break;
				case "ShiftCipher":
					shift.setShiftAmount(ver);
					this.ausgab = shift.decrypt(this.view.getEingabe());
					break;
				case "KeywordCipher":
					key.setKeyword(this.view.getKeyWordGeheimAlphabet());
					this.ausgab = key.decrypt(this.view.getEingabe());
					break;
				case "TranspositionCipher":
					trans.setTranspositionLevel(Integer.parseInt(this.view.getLevel()));
					this.ausgab = trans.decrypt(this.view.getEingabe());
					break;
				}
				break;
			}
		}catch(MyException e){
			load=4;
		}
		//die refresh methode der view-Klasse wird ausgeführt
		this.view.refresh(load,ausgab);
	}
	/**
	 * Die Methode die ausgeführt wird wenn der Benutzer die Auswahl einer ComboBox ändert
	 */
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		JComboBox a = (JComboBox) arg0.getSource();
		//Je nachdem ob entweder dei ComboBox mit den Verschlüsselungsarten oder die mit den shiftStufen ausgewählt wird
		switch(a.getActionCommand()){
		case "vmethode":
			meth =(String) a.getSelectedItem();
			//abhängig von der Cipher-Art werden bestimmte Werte an load übergeben welches dann später an refresh übergeben wird um bestimme elemente zu enablen oder nicht
			switch(meth){
			case "SubstitutionCipher":
				load=1;
				break;
			case "ShiftCipher":
				load=2;
				break;
			case "KeywordCipher":
				load=1;
				break;
			case "TranspositionCipher":
				load=3;
				break;
			}
			this.view.refresh(load,ausgab);
			break;
			//
		case "versch":
			//shiftStufe wird gespeichert
			ver = Integer.parseInt((String)a.getSelectedItem());
			System.out.println(ver);
			break;
		}



	}
}
