package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.MyException;
import anilkaric.TranspositionCipher;
/**
 * Die Testklasse für TranspositionCipher
 * @author Adin Karic
 * @version 2014-05-17
 *
 */
public class TestTranspositionCipher {
	/**
	 * testet die Transposition
	 * @throws MyException eigene Exception
	 */
	@Test
	public void transpoTest() throws MyException {
		TranspositionCipher e = new TranspositionCipher(2);
		//setzen des Transpositionslevels
		e.setTranspositionLevel(3);
		//Überprüfung ob encrypt und decrypt funktionieren
		if(!e.encrypt("Adin kann am Samstag Abend nicht raus und macht SEW").equals("ANNMMABDCRSDCSDKNSSGENHAUMHEIAAATANITUNATW")){
			throw new RuntimeException("fail transpo");
		}
		if(!e.decrypt("ANNMMABDCRSDCSDKNSSGENHAUMHEIAAATANITUNATW").equals("ADINKANNAMSAMSTAGABENDNICHTRAUSUNDMACHTSEW")){
			throw new RuntimeException("fail transpo");

		}
	}

}
