package anilkaric.test;

import org.junit.runner.*;
import org.junit.runners.*;
/**
 * Die TestSuite mit allen Testklassen für Cipher
 * @author Adin Karic
 * @version 2014-05-17
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TestShiftCipher.class, TestMonoAlphabeticCipher.class,TestKeyWordCipher.class,TestSubstitutionCipher.class,TestTranspositionCipher.class,TestCipherController.class})
public class TestSuite {

}
