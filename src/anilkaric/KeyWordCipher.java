package anilkaric;
/**
 * Die KeyWordCipher-Klasse zur verschl�sselung mittels Schl�sselwortes
 * @author Adin Karic
 * @version 2014-05-17
 */
public class KeyWordCipher extends MonoAlphabeticCipher {
	/**
	 * Der Konstruktor von KeyWordCipher
	 * @param keyword	das Schl�sselwort
	 * @throws MyException
	 */
	public KeyWordCipher(String keyword) throws MyException{
		//Schl�sselwort wird gesetzt
		this.setKeyword(keyword);
	}
	public void setKeyword(String keyword) throws MyException{
		//Es duerfen keine Buchstaben doppelt vorkommen im Keyword
		char[] alph = new char[30];
		String gehalph="";
		//�berpr�fung ob ein Zeichen doppelt vorkommt
		for(int i = 0; i< this.getSecretAlphabet().length();i++){
			alph[i]=this.getSecretAlphabet().charAt(i);
		}
		for(int j=0;j<keyword.length();j++){
			for(int k = 0; k<alph.length;k++){
				if(keyword.toLowerCase().charAt(j)==alph[k]){
					if(alph[k] == '.'){
						throw new MyException("Im Keyword d�rfen keine Buchstaben doppelt vorkommen!");

					}else{
						alph[k]='.';
					}
				}
			}
		}
		//geheimalphabet wird generiert
		for(int m=0;m<keyword.length();m++) {
			gehalph+=keyword.toLowerCase().charAt(m);

		}
		for(int n=0;n<alph.length;n++){
			if(alph[n] != '.'){
				gehalph+=alph[n];
			}
		}
		//geheimalphabet wird gesetzt
		this.setSecretAlphabet(gehalph);

	}
}
