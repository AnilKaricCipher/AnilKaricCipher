package anilkaric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import anilkaric.MyException;
import anilkaric.TranspositionCipher;

public class TestTranspositionCipher {

	@Test
	public void transpoTest() throws MyException {
		TranspositionCipher e = new TranspositionCipher(2);
		e.setTranspositionLevel(3);
		if(!e.encrypt("Adin kann am Samstag Abend nicht raus und macht SEW").equals("ANNMMABDCRSDCSDKNSSGENHAUMHEIAAATANITUNATW")){
			throw new RuntimeException("fail transpo");
			
		}
		if(!e.decrypt("ANNMMABDCRSDCSDKNSSGENHAUMHEIAAATANITUNATW").equals("ADINKANNAMSAMSTAGABENDNICHTRAUSUNDMACHTSEW")){
			throw new RuntimeException("fail transpo");
			
		}
	}

}
