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

public class CipherController implements ActionListener,ItemListener {

	private TranspositionCipher trans;
	private SubstitutionCipher subst;
	private ShiftCipher shift;
	private KeyWordCipher key;
	private CipherView view;
	private String ausgab="";
	private String meth="SubstitutionCipher";
	private int ver;
	private int load;

	public CipherController() throws MyException{
		trans = new TranspositionCipher(2);
		subst = new SubstitutionCipher("ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß");
		shift = new ShiftCipher(1);
		key = new KeyWordCipher("WORLD");
		view = new CipherView(this);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton b = (JButton)arg0.getSource();
		try{
			switch(b.getActionCommand()){
			case "ver":
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
			case "ent":
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
		this.view.refresh(load,ausgab);
		}
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			JComboBox a = (JComboBox) arg0.getSource();
			switch(a.getActionCommand()){
			case "vmethode":
				meth =(String) a.getSelectedItem();
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
			case "versch":
				ver = Integer.parseInt((String)a.getSelectedItem());
				System.out.println(ver);
				break;
			}



		}
	}
