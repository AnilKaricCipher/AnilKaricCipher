package anilkaric;
/**
 * 
 * @author Adin Karic
 *
 */
public class ShiftCipher extends MonoAlphabeticCipher {

	public ShiftCipher(int verschiebung) throws MyException {
		this.setShiftAmount(verschiebung);

	}

	public void setShiftAmount(int verschiebung) throws MyException{
		if(verschiebung <=30 && verschiebung >=0){
			String alph=this.getSecretAlphabet();
			String newalph="";
			char[] veralph=new char[30];
			int x = 0;
			for(int i = 0;i<alph.length();i++){
				try{
					veralph[verschiebung+i]=alph.charAt(i);
				}catch(IndexOutOfBoundsException e){
					veralph[x]= alph.charAt(i);
					x++;
				}


			}

		

		for(int k=0;k<veralph.length;k++){
			newalph+=veralph[k];
		}
		super.setSecretAlphabet(newalph);
		}else{
			throw new MyException("Bitte einen Wert von 0 bis 30 nehmen");
		}
	}


}
