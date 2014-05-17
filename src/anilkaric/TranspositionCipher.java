package anilkaric;
/**
 * Die Klasse TranspositionCipher die den Text mittels Gartenzaun Transposition verschlüsselt
 * @author Rohat Anil
 * @version 2014-05-11
 */
public class TranspositionCipher implements Cipher {
	//das transpositionslevel als attribut
	private int tlevel;
	//weiterleitung an die setter-Methode
	public TranspositionCipher(int transpositionLevel) throws MyException{
		this.setTranspositionLevel(transpositionLevel);
	}
	/**
	 * Die Setter-Methode von TranspositionCipher
	 * @param level	das gewünschte Transpositionslevel
	 * @throws MyException	wird geworfen wenn das transpositionslevel ungültig ist
	 */
	public void setTranspositionLevel(int level) throws MyException{
		//wenn das transpositionslevel kleiner gleich 1 ist wird die exception geworfen
		if(level<=1){
			throw new MyException("Bitte ein hoeheres Transpositionlevel waehlen");
		}else{
			this.tlevel=level;
		}
	}
	/**
	 * Die Encrypt-Methode die einen Text mittels der Gartenzaun-Transposition verschlüsselt
	 * @param text 		den text den man verschlüsseln will
	 * @return versch 	der verschluesselte Text der dann zurueckgegebn wird
	 */
	@Override
	public String encrypt(String text) {
		//Zunaechst deklariere und initialisiere ich die Variable die später 
		//als verschluesselter Text zurueckgegeben wird
		String versch="";
		//ich mache jedes Zeichen groß und lösche die Leerzeichen heraus
		String kompr=text.toUpperCase().replaceAll(" ","");
		//Nun erstelle ich ein String Array mit der groeße des gewaehlten transpositionslevels
		String[] array = new String[this.tlevel]; 
		//Ich intialisiere das String Array mittels einer for-Schleife
		for(int i=0; i<array.length;++i){
			array[i]="";
		}
		//Ich gehe alle Elemente von kompr durch
		for(int i=0; i<kompr.length();++i){
			//Je nachdem welcher Modulowert zurueckgegeben wird der Buchstabe auf eine andere Ebene gespeichert
			int a=i%array.length; 
			//nun werden die einzelnen Zeichen in das Array eingefügt
			array[a]+=""+kompr.charAt(i);
		}
		//Der Inhalt des Arrays wird in versch gespeichert
		for(int i=0; i<array.length;++i){
			versch=versch+array[i]; //wird in ein String zusammengefasst
		}
		//versch wird zurueckgegebn
		return versch;
	}

	/**
	 * Die Decrypt-Methode zur Entschlüsselung mittels der Gartenzaun-Transposition
	 * @param versch	der verschluesselte Text
	 * @return dever	der entschluesselte Text
	 */
	@Override
	public String decrypt(String versch) {
		//Erstellen der Variable mit dem entschluesselten Text
		String dever="";
		int groesse = 1;
		int anzahlcount=0;
		versch=versch.toUpperCase();
		//Es wird ein Array erstellt das so groß ist wie das transpositionslevel
		String [] dearray= new String [tlevel];
		// es wird ein genauso großes int array erstellt in das die Anzahl der buchstaben 
		//in der jeweiligen Zeile gespeichert wird
		int [] a = new int [tlevel];
		//Ich speichere zunächste leere Strings in das Array
		for(int i = 0; i< dearray.length; i++){
			dearray[i] = "";
		}
		//Nun berechne ich mir die Anzahl der Buchstaben in einer Zeile sowie die restlichen Buchstaben
		int zahl = versch.length()/tlevel;
		int r = versch.length()%tlevel;
		//Die Anzahl wird nun in das Array gespeichert
		for(int i=0; i<a.length ;i++){	
			a[i] = zahl;
		}
		//solange rest noch übrig ist wird er dazugezählt
		for(int i = 0 ; i < r; i++){
			a[i]++;
		}
		//der verschlüsselte Text wird jetzt auf den verschiedenen Ebenen bzw. indizes aufgeteilt
		//um ihn wieder in die richtige konstellation zu bringen
		for(int i = 0; i < versch.length(); i++){
			dearray[anzahlcount] += "" + versch.charAt(i);
			//groesse wird wieder auf 0 gesetzt wenn die Länge der Zeile erreicht ist
			if(groesse == a[anzahlcount]){
				anzahlcount++;
				groesse=0; 
			}
			//groesse wird um 1 erhöht
			groesse++;
		}
		for(int j = 0; j < a[0]; j++){
			//solange i kleiner als die laenge
			for(int i=0; i<dearray.length ;i++){
				//wenn die laenge groesser als j ist
				if(dearray[i].length()>j){
					//die einzelnen chars werden zum string der dann zurückgegeben wird zusammgefügt
					dever+=dearray[i].charAt(j);
				}
			}
		}
		//der entschlüsselte text wird zurueckgegeben
		return dever;
	}
}