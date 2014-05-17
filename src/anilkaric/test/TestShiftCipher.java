package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.MyException;
import anilkaric.ShiftCipher;
/**
 * Testklasse f�r ShiftCipher
 * @author Adin Karic
 * @version 2014-05-17
 */
public class TestShiftCipher {
	/**
	 * Testmethode f�r die setterMethode
	 * @throws MyException
	 */
	@Test
	public void setShiftTest() throws MyException {
		//Objekt wird erzeugt
		ShiftCipher b = new ShiftCipher(1);
		//shiftAmount wird gesetzt
		b.setShiftAmount(2);
		//encrypt wird �berpr�ft
		if(!b.encrypt("adin").equals("�bgl")){
			throw new RuntimeException();
		}

	}

}
