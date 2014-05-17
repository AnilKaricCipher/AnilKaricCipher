package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.MyException;
import anilkaric.ShiftCipher;

public class TestShiftCipher {

	@Test
	public void setShiftTest() throws MyException {
		ShiftCipher b = new ShiftCipher(1);
		b.setShiftAmount(2);
		if(!b.encrypt("adin").equals("übgl")){
			throw new RuntimeException();
		}
		
	}

}
