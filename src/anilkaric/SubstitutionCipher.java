package anilkaric;

/**
 * Klasse die von MonoAlphabeticCipher erbt
 * @author Adin Karic
 * @version 2014-04-08
 *
 */
public class SubstitutionCipher extends MonoAlphabeticCipher {
	/**
	 * Konstruktor dem ein geheimalphabet übergeben wird
	 * @param secretAlphabet das geheimalphabet als string
	 * @throws MyException
	 */
	public SubstitutionCipher(String secretAlphabet) throws MyException{
		//Methode von Superklasse wird aufgerufen
		super.setSecretAlphabet(secretAlphabet);
	}
	/**
	 * Überschriebene Methode der Superklasse zum Setzen eines geheimalpahbets
	 */
	@Override
	public void setSecretAlphabet(String secretAlphabet) throws MyException{
		//Methode von Superklasse wird aufgerufen
		super.setSecretAlphabet(secretAlphabet);
	}

}
