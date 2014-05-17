package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.KeyWordCipher;
import anilkaric.MyException;

public class TestKeyWordCipher {

	@Test
	public void setTest() throws MyException {
		KeyWordCipher c = new KeyWordCipher("WORLD");
		c.setKeyword("Adin");
		if(!c.encrypt("ABCD").equals("adin")){
			throw new RuntimeException("Fail setKeyword");
		}
	}

}
