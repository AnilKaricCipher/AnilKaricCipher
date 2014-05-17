package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.MyException;
import anilkaric.SubstitutionCipher;
/**
 * Testklasse f�r SubstitutionCipher
 * @author Adin Karic
 * @version 2014-05-17
 */
public class TestSubstitutionCipher {
	/**
	 * TestMethode f�r den Konstruktor sowie setterMethode und encrypt
	 * @throws MyException
	 */
	@Test
	public void KonstTest() throws MyException {
		//Objekt wird erzeugt
		SubstitutionCipher d = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyz����");
		//geheimalphabet wird gesetzt
		d.setSecretAlphabet("bacdefghijklmnopqrstuvwxyz����");
		//encrypt wird �berpr�ft
		if(!d.encrypt("ABCD").equals("bacd")){
			throw new RuntimeException("Fail setSubst");
		}
	}

}
