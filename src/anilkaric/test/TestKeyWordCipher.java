package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.KeyWordCipher;
import anilkaric.MyException;
/**
 * Klasse die KeyWordCipher testet
 * @author Adin Karic
 * @version 2014-05-17
 */
public class TestKeyWordCipher {
	/**
	 * Methode die setkeyword und encrypt testet von keywordcipher
	 * @throws MyException
	 */
	@Test
	public void setTest() throws MyException {
		//KeyWordCipher Objekt wird erzeugt
		KeyWordCipher c = new KeyWordCipher("WORLD");
		//keyword wird gesetzt
		c.setKeyword("Adin");
		//überprüfung ob encrypt funktioniert
		if(!c.encrypt("ABCD").equals("adin")){
			throw new RuntimeException("Fail setKeyword");
		}
	}

}
