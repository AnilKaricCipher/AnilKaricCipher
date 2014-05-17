
package anilkaric;
/**
 * Die Superklasse in der die Methoden encrypt und decrypt vom Interface Cipher implementiert und überschrieben werden
 * @author Adin Karic
 * @version 2014-04-08
 *
 */
public class MonoAlphabeticCipher implements Cipher {
	// das geheimalphabet
	private String secretAlphabet;
	/**
	 * Der Konstruktor der das geheimalphabet auf das klaralphabet setzt(also noch keine Verschlüsselung)
	 */
	public MonoAlphabeticCipher(){
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}
	/**
	 * getter Methode für das secretAlphabet
	 * @return das secretalphabet als String
	 */
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}
	/**
	 * Settermethode für das secretAlphabet
	 * @param text das neue secretAlphabet
	 * @throws MyException
	 */
	public void setSecretAlphabet(String text) throws MyException {
		//wenn das neue secretalphabet 30 zeichen hat
		if(text.length()==30){
			this.secretAlphabet=text;
			//ansonsten wird eine MyException geworfen
		}else{
			throw new MyException("Bitte einen gueltigen Wert eingeben");
		}
	}
	/**
	 * Die encrypt Methode die überschrieben wird und zum Verschlüsseln dient
	 * @param text den Text den man verschlüsseln will
	 * @return der verschlüsselte String
	 */
	@Override
	public String encrypt(String text) {
		//Klaralphabet
		String klar="abcdefghijklmnopqrstuvwxyzäöüß";
		String versch="";
		boolean wf;
		//solange i kleiner als die Länge des zu verschlüsselnden Textes
		for(int i = 0;i<text.length();i++){
			wf=true;
			//solange j kleiner als die Länge des Klartextes
			for(int j = 0;j<klar.length();j++){
				//wenn das Zeichen an i von text gleich dem Zeichen an i von klar
				//dann wird versch um das zeichen an i von secretAlphabet erweitert
				if(text.toLowerCase().charAt(i)==klar.charAt(j)){
					versch+=this.secretAlphabet.toLowerCase().charAt(j);
					wf=false;
				}
			}
			//Falls das Zeichen nicht im Klaralphabet enthalten ist wird es beibehalten
			if(wf){
				versch+=text.charAt(i);
				wf=false;
			}
		}
		//der verschlüsselte String wird zurückgegeben
		return versch;
		
	}
	/**
	 * Die methode decrypt zum entschlüsseln
	 * @param text der zu entschlüsselnde Text
	 * @return der entschlüsselte String
	 */
	@Override
	public String decrypt(String text) {
		//Klaralphabet
		String klar="abcdefghijklmnopqrstuvwxyzäöüß";
		String entsch="";
		boolean wf;
		//solange i kleiner als die Länge des zu entschlüsselnden Textes
		for(int i = 0;i<text.length();i++){
			wf=true;
			//solange j kleiner als die Länge des Klartextes
			for(int j = 0;j<klar.length();j++){
				//wenn das Zeichen an i von text gleich dem Zeichen an i von secretAlphabet
				//dann wird versch um das zeichen an i von klar erweitert
				if(text.toLowerCase().charAt(i)==this.secretAlphabet.toLowerCase().charAt(j)){
					entsch+=klar.charAt(j);
					wf=false;
				}
			}
			//Falls das Zeichen nicht im secretAlphabet enthalten ist wird es beibehalten
			if(wf){
				entsch+=text.charAt(i);
				wf=false;
			}
		}
		//der entschlüsselte String wird zurückgegeben
		return entsch;
	}
}



