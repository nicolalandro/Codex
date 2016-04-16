package Util;

public class CodiceMorse extends CifrarioPerSostituzione {
	/**
	 *La classe <code>CodiceMorse</code> è la classe che realizza l'omonima codifica.
	 *@author Nicola Landro
	 *@version 0.0
	 */
	
	/**
	 *Costruisce un oggetto che è in grado di criptare e decriptare secondo le regole del Codice Morse
	 */
	public CodiceMorse(){
		super();
		super.setLettera(' ', ".......");
		super.setLettera('a', ".-");
		super.setLettera('b', "-...");
		super.setLettera('c', "-.-.");
		super.setLettera('d', "-..");
		super.setLettera('e', ".");
		super.setLettera('f', "..-.");
		super.setLettera('g', "--.");
		super.setLettera('h', "....");
		super.setLettera('i', "..");
		super.setLettera('j', ".---");
		super.setLettera('k', "-.-");
		super.setLettera('l', ".-..");
		super.setLettera('m', "--");
		super.setLettera('n', "-.");
		super.setLettera('o', "---");
		super.setLettera('p', ".--.");
		super.setLettera('q', "--.-");
		super.setLettera('r', ".-.");
		super.setLettera('s', "...");
		super.setLettera('t', "-");
		super.setLettera('u', "..-");
		super.setLettera('v', "...-");
		super.setLettera('w', ".--");
		super.setLettera('x', "-..-");
		super.setLettera('y', "-.--");
		super.setLettera('z', "--..");
		
		super.setLettera('0', "-----");
		super.setLettera('1', ".----");
		super.setLettera('2', "..---");
		super.setLettera('3', "...--");
		super.setLettera('4', "....-");
		super.setLettera('5', ".....");
		super.setLettera('6', "-....");
		super.setLettera('7', "--...");
		super.setLettera('8', "---..");
		super.setLettera('9', "----.");
		
		super.setLettera('.', ".-.-.-");
		super.setLettera(',', "--..--");
		super.setLettera(':', "---...");
		super.setLettera('?', "..--..");
		super.setLettera('=', "-...-");
		super.setLettera('-', "-....-");
		super.setLettera('(', "-.--.");
		super.setLettera(')', "-.--.-");
		super.setLettera('"', ".-..-.");
		super.setLettera('\'', ".----.");
		super.setLettera('/', "-..-.");
		super.setLettera('@', ".--.-.");
		super.setLettera('!', "-.-.--");
		
		super.setStoria("Il codice Morse rappresenta le lettere dell'alfabeto, i numeri ed altri segni"
				+ " attraverso una combinazione di punti, linee e spazi."
				+ " Inizialmente a Morse fu negato il brevetto sia negli Stati Uniti che in Europa"
				+ " finché nel 1843, ricevette un finaziamento da parte del governo, per la costruzione"
				+ " di una linea telegrafica tra Whashington D.C. e Baltimora."
				+ " Nel 1884 venne effettuata la prima trasmissione, e succesivamente nacque una compagnia"
				+ " con lo scopo di coprire tutta l'America del Nord di linee telegrafiche."
				+ " \nMorse morì nel 1872 e il continente Americano era già attraversato da più di 300.000"
				+ " chilometri di linee.");
	}
	
	/**
	 * Cripta
	 * @param daCriptare = String la stringa che si desidera criptare
	 * @return String = la stringa criptata
	 */
	//Controllare se e null... se e null ci sono caratteri non validi
	@Override
	public String cript(String daCriptare) {
		
		String daCriptareToLowerCase = daCriptare.toLowerCase();
		//boolean correct = true;
		
		for(int i=0;i<daCriptare.length();i++){
			char daConfrontare = daCriptareToLowerCase.charAt(i);
			boolean compresoTraAeZ = daConfrontare>='a' && daConfrontare<='z';
			boolean numeri = daConfrontare>='0' && daConfrontare<='9'; 
			boolean caratteriSpeciali = 
						daConfrontare=='.'
						||daConfrontare==','
						||daConfrontare==':'
						||daConfrontare=='?'
						||daConfrontare=='='
						||daConfrontare=='-'
						||daConfrontare=='('
						||daConfrontare==')'
						||daConfrontare=='"'
						||daConfrontare=='\''
						||daConfrontare=='/'
						||daConfrontare=='@'
						||daConfrontare=='?'
						||daConfrontare==' '
						;
			if(!(compresoTraAeZ||numeri||caratteriSpeciali)){
				return null;
			}
		}
		
		return super.cript(daCriptareToLowerCase);
	}
	
	/**
	 * DeCripta
	 * @param daCriptare = String la stringa che si desidera decriptare
	 * @return String = la stringa decriptata
	 */
	@Override
	public String deCript(String daDeCriptare) {
		String daDeCriptareToLowerCase=daDeCriptare.toLowerCase();
		
		for(int i=0;i<daDeCriptare.length();i++){
			char daConfrontare = daDeCriptareToLowerCase.charAt(i);
			
			if(!(daConfrontare=='.'||daConfrontare=='-'||daConfrontare==' ')){
				return null;
			}
		}
		
		return super.deCript(daDeCriptareToLowerCase);
	}
	
}
