package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.MyException;
import anilkaric.ShiftCipher;
/**
 * Testklasse für ShiftCipher
 * @author Adin Karic
 * @version 2014-05-17
 */
public class TestShiftCipher {
	/**
	 * Testmethode für die setterMethode
	 * @throws MyException
	 */
	@Test
	public void setShiftTest() throws MyException {
		//Objekt wird erzeugt
		ShiftCipher b = new ShiftCipher(1);
		//shiftAmount wird gesetzt
		b.setShiftAmount(2);
		//encrypt wird überprüft
		if(!b.encrypt("adin").equals("übgl")){
			throw new RuntimeException();
		}

	}

}
