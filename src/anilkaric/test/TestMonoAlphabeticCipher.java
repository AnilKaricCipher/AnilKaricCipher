package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.MonoAlphabeticCipher;
import anilkaric.MyException;

public class TestMonoAlphabeticCipher {

	@Test
	public void konstTest() {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		if(!a.getSecretAlphabet().equals("abcdefghijklmnopqrstuvwxyz����")){
			throw new RuntimeException("Fail MonoKonst");
		}
	}
	@Test(expected = MyException.class)
	public void setTest() throws MyException {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		try {
			a.setSecretAlphabet("Zu wenig als Alphabet");
		} catch (MyException e) {
			throw e;
		}
	}
	@Test
	public void setTest2() throws MyException {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		try {
			a.setSecretAlphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ����");
		} catch (MyException e) {
			throw e;
		}
	}
	@Test
	public void encryptDecryptTest() throws MyException {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		try {
			a.setSecretAlphabet("BACDEFGHIJKLMNOPQRSTUVWXYZ����");
		} catch (MyException e) {
			throw e;
		}
		if(!a.encrypt("Adin").equals("bdin")){
			throw new RuntimeException();
		}
		if(!a.decrypt("bdin").equals("adin")){
			throw new RuntimeException();
		}
		
	}

}
