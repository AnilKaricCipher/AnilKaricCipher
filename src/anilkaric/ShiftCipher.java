package anilkaric;
/**
 * Die ShiftCipher-Klasse zur Verschlüsselung mittels Verschiebung
 * @author Adin Karic
 * @version 2014-05-17
 */
public class ShiftCipher extends MonoAlphabeticCipher {
	/**
	 * Konstruktor der ShiftCipher-Klasse
	 * @param verschiebung die verschiebungsstufe
	 * @throws MyException
	 */
	public ShiftCipher(int verschiebung) throws MyException {
		//verschiebungsstufe wird gesetzt
		this.setShiftAmount(verschiebung);

	}
	/**
	 * Die Methode zum Setzen der verschiebestufe
	 * @param verschiebung die verschiebestufe
	 * @throws MyException
	 */
	public void setShiftAmount(int verschiebung) throws MyException{
		//wenn die verschiebungsstufe gültig ist
		if(verschiebung <=30 && verschiebung >=0){
			String alph="abcdefghijklmnopqrstuvwxyzäöüß";
			String newalph="";
			char[] veralph=new char[30];
			int x = 0;
			//neues secretAlphabet wird generiert
			for(int i = 0;i<alph.length();i++){
				try{
					veralph[verschiebung+i]=alph.charAt(i);
				}catch(IndexOutOfBoundsException e){
					veralph[x]= alph.charAt(i);
					x++;
				}


			}



			for(int k=0;k<veralph.length;k++){
				newalph+=veralph[k];
			}
			//neues secretalphabet wird gesetzt
			super.setSecretAlphabet(newalph);

		}else{
			throw new MyException("Bitte einen Wert von 0 bis 30 nehmen");
		}
	}


}
