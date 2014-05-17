package anilkaric.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import anilkaric.Cipher;
import anilkaric.KeyWordCipher;
import anilkaric.MyException;
import anilkaric.ShiftCipher;
import anilkaric.SubstitutionCipher;
import anilkaric.TranspositionCipher;

public class CipherController implements ActionListener,ItemListener {
	
	private Cipher[] cipher = new Cipher[4];
	private CipherView view = new CipherView(this);
	private String text="";
	private String meth="";
	private int ver;
	
	public CipherController() throws MyException{
		cipher[0] = new SubstitutionCipher("ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß");
		cipher[1] = new ShiftCipher(1);
		cipher[2] = new KeyWordCipher("WORLD");
		cipher[3] = new TranspositionCipher(2);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton b = (JButton)arg0.getSource();
		switch(b.getText()){
		case "Verschlüsseln":
			switch(meth){
			case "SubstitutionCipher":
				
			
			}
		}
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		JComboBox a = (JComboBox) arg0.getSource();
		switch(a.getActionCommand()){
		case "vmethode":
			meth =(String) a.getSelectedItem();
			
			break;
		case "versch":
			ver = (Integer)a.getSelectedItem();
			
			
			break;
		}
		
		
		
	}
	public static void main(String[] args) throws MyException{
		CipherController c = new CipherController();
	}
}
