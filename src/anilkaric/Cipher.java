package anilkaric;
/**
 * Das Cipher Interface mit den Methode encrypt und decrypt zum Verschlüsseln
 * @author Adin Karic
 * @version 2014-04-08
 *
 */
public interface Cipher  {
	/**
	 * Die Methode encrypt die verschlüsselt
	 * @param text der uebergebene String zum Verschlüsseln
	 * @return der verschlüsselte String
	 */
	
	public String encrypt(String text);
	/**
	 * Die Methode decrypt die entschlüsselt
	 * @param text der uebergebene String zum Entschlüsseln
	 * @return der entschlüsselte String
	 */
	public String decrypt(String text);

}
