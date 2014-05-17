package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.MonoAlphabeticCipher;
import anilkaric.MyException;
/**
 * Testklasse für MonoAlphabeticCipher
 * @author Adin Karic
 * @version 2014-05-17
 */
public class TestMonoAlphabeticCipher {
	/**
	 * Methode die den Konstruktor testet
	 */
	@Test
	public void konstTest() {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		//standard alphabet wird gesetzt
		if(!a.getSecretAlphabet().equals("abcdefghijklmnopqrstuvwxyzäöüß")){
			throw new RuntimeException("Fail MonoKonst");
		}
	}
	/**
	 * Methode die die setter-Methode testet
	 * @throws MyException
	 */
	@Test(expected = MyException.class)
	public void setTest() throws MyException {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		try {
			//zu wenig als alphabet
			a.setSecretAlphabet("Zu wenig als Alphabet");
		} catch (MyException e) {
			throw e;
		}
	}
	/**
	 * Methode die die setter-Methode testet (positiv)
	 * @throws MyException
	 */
	@Test
	public void setTest2() throws MyException {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		try {
			//geheimalphabet wird gesetzt
			a.setSecretAlphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß");
		} catch (MyException e) {
			throw e;
		}
	}
	@Test
	/**
	 * Testmethode für encrypt und decrypt
	 * @throws MyException
	 */
	public void encryptDecryptTest() throws MyException {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		try {
			a.setSecretAlphabet("BACDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß");
		} catch (MyException e) {
			throw e;
		}
		//encrypt und decrypt werden überprüft
		if(!a.encrypt("Adin").equals("bdin")){
			throw new RuntimeException();
		}
		if(!a.decrypt("bdin").equals("adin")){
			throw new RuntimeException();
		}

	}

}
