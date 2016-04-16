package Util;

public class CifrarioCesare extends CifrarioPerSpostamento{
	/**
	 *La classe <code>CifrarioCesare</code> è la classe che realizza l'omonima codifica.
	 *@author Nicola Landro
	 *@version 0.0
	 */
	
	/**
	 *Costruisce un oggetto che è in grado di criptare e decriptare secondo le regole del Cifrario di Cesare 
	 */
	public CifrarioCesare(){
		setStoria("Caio Giulio Cesare 100-44 AC. Militare e Politico che calco il palco"
				+ " della storia romana lasciandone iu impronta indelebile. Famoso per il primo Triumvirato"
				+ ", alleandosi con Crasso e Pompeo, e ancora più famoso per la conquista della gallia"
				+ ", Cesare era solito utilizzare, più che per la guierra, nei messaggi privati un metodo"
				+ " di crittografia nato nel I secolo a.C. , quattro anni dopo del codice Polibio."
				+ "  Questo metodo passa alla storia come 'Cifrario Cesare'. \nIl cifrario di Cesare consiste"
				+ " nel riassegnare ad ogni lettera dell'alfabeto una nuova ottenuta spostandola di un"
				+ " determinato numero di posizioni. Dunque è un particolare tipo di codice per spostamento.");
		setTrasposizione(1);
	}
	

	/**
	 * Cripta
	 * @param daCriptare = String la stringa che si desidera criptare
	 * @return String = la stringa criptata
	 */
	@Override
	public String cript(String daCriptare){
		String criptata="";
		
		for(int i=0; i<daCriptare.length();i++){
			if(daCriptare.charAt(i)>='a'&&daCriptare.charAt(i)<='z'){
				setMaxValue('z');
				setMinValue('a');
				criptata = criptata + trasposeChar(daCriptare.charAt(i));
			}
			else if(daCriptare.charAt(i)>='A'&&daCriptare.charAt(i)<='z'){
				setMaxValue('Z');
				setMinValue('A');
				criptata = criptata + trasposeChar(daCriptare.charAt(i));
			}
			else{
				criptata = criptata + daCriptare.charAt(i);
			}
		}
		
		return criptata;
	}
	
	/**
	 * DeCripta
	 * @param daCriptare = String la stringa che si desidera decriptare
	 * @return String = la stringa decriptata
	 */
	@Override
	public String deCript(String daDeCriptare){
		String criptata="";
		
		for(int i=0; i<daDeCriptare.length();i++){
			if(daDeCriptare.charAt(i)>='a'&&daDeCriptare.charAt(i)<='z'){
				setMaxValue('z');
				setMinValue('a');
				criptata = criptata + detrasposeChar(daDeCriptare.charAt(i));
			}
			else if(daDeCriptare.charAt(i)>='A'&&daDeCriptare.charAt(i)<='z'){
				setMaxValue('Z');
				setMinValue('A');
				criptata = criptata + detrasposeChar(daDeCriptare.charAt(i));
			}
			else{
				criptata = criptata + daDeCriptare.charAt(i);
			}
		}
		
		return criptata;
	}
	
}
