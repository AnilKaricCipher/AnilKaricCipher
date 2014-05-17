package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.MyException;
import anilkaric.SubstitutionCipher;

public class TestSubstitutionCipher {

	@Test
	public void KonstTest() throws MyException {
		SubstitutionCipher d = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyz����");
		d.setSecretAlphabet("bacdefghijklmnopqrstuvwxyz����");
		if(!d.encrypt("ABCD").equals("bacd")){
			throw new RuntimeException("Fail setSubst");
		}
	}

}
