package anilkaric;
/**
 * 
 * @author Adin Karic
 *
 */
public class KeyWordCipher extends MonoAlphabeticCipher {

		public KeyWordCipher(String keyword) throws MyException{
			this.setKeyword(keyword);
		}
		public void setKeyword(String keyword) throws MyException{
			//Es duerfen keine Buchstaben doppelt vorkommen im Keyword
			char[] alph = new char[30];
			String gehalph="";
			for(int i = 0; i< this.getSecretAlphabet().length();i++){
				alph[i]=this.getSecretAlphabet().charAt(i);
			}
			for(int j=0;j<keyword.length();j++){
				for(int k = 0; k<alph.length;k++){
					if(keyword.toLowerCase().charAt(j)==alph[k]){
						if(alph[k] == '.'){
							throw new MyException("Im Keyword dürfen keine Buchstaben doppelt vorkommen!");
							
						}else{
							alph[k]='.';
						}
					}
				}
			}
			for(int m=0;m<keyword.length();m++) {
				gehalph+=keyword.toLowerCase().charAt(m);
			
			}
			for(int n=0;n<alph.length;n++){
				if(alph[n] != '.'){
					gehalph+=alph[n];
				}
			}
			this.setSecretAlphabet(gehalph);
			
		}
}
