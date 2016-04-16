package Util;


public class CifrarioPerSpostamento extends Cifrario{
	/**
	 *La classe <code>CifrarioPerTrasposizione</code> è la classe che concretizza Cifrario realizzando la codifica per trasposizione.
	 *@param n = int che indica di quanto vengono trasposti i caratteri 
	 *@param maxValue = int che indica il massimo valore che un char da trasporre può avere (potra essere modificato dalle sue sottoclassi)
	 *@param minValue = int che indica il minimo valore che un char da trasporre può avere (potra essere modificato dalle sue sottoclassi)
	 *@author Nicola Landro
	 *@version 0.0
	 */
	private int n;
	private int maxValue = Character.MAX_VALUE+1;
	private int minValue = 0;
	
	/**
	 *Costruisce un oggetto che è in grado di criptare e decriptare per trasposizione 
	 */
	public CifrarioPerSpostamento(){
		setStoria("In parallelo ai cifrari per trasposizione (probabilmente nati ai tempi"
				+ " della guerra del Peloponneso) nascono i codici per spostamento. Questo"
				+ " codice consiste nell'effettuare una sostituzione rigorosa di un simbolo"
				+ " con un altro successivo rispetto a quello di partenza di un certo numero."
				+ "\nQuesto cifrario nasce per scopi bellici, e rimase quello più utilizzato per parecchio tempo."
				+ "\nQuesto codice può essere facilmente trattato grazie all'aritmetica modulare.");
		n=0;
	}
	
	/**
	 * metodo che setta il massimo valre di char da prendere in considerazione
	 * @param maxvalue = int setta il massimo valore
	 * @return void
	 */
	protected void setMaxValue(int maxvalue){
		maxValue = maxvalue ;
	}
	
	/**
	 * metodo che setta il minimo valre di char da prendere in considerazione
	 * @param minvalue = int setta il minimo valore
	 * @return void
	 */
	protected void setMinValue(int minvalue){
		minValue = minvalue ;
	}
	private int renge(){
		return maxValue-minValue;
	}
	
	
	/**
	 * metodo che setta la trasposizione
	 * @param numero = int il numero che indica quanto si intende trasporre
	 * @return void
	 */
	public void setTrasposizione(int numero){
		n = numero;
	}
	/**
	 * Metodo Privato che traspone un carattere
	 * @param c = char da criptare
	 * @return char = criptato
	 */
	protected char trasposeChar(char c){
		int toZero= c-minValue;
		return (char) (((toZero+n)%renge())+minValue);
	}
	
	/**
	 * Metodo Privato che traspone un carattere
	 * @param c = char da criptare
	 * @return char = criptato
	 */
	protected char detrasposeChar(char c){
		int toZero= c-minValue;
		return (char) (((toZero+renge()-n)%renge())+minValue);
	}
	
	/**
	 * Cripta
	 * @param daCriptare = String la stringa che si desidera criptare
	 * @return String = la stringa criptata
	 */
	@Override
	public String cript(String daCriptare) {
		String criptata="";
		
		for(int i=0; i<daCriptare.length();i++){
			criptata = criptata + trasposeChar(daCriptare.charAt(i));
		}
		
		return criptata;
	}
	
	/**
	 * DeCripta
	 * @param daCriptare = String la stringa che si desidera decriptare
	 * @return String = la stringa decriptata
	 */
	@Override
	public String deCript(String daDeCriptare) {
		String decriptata="";
		
		for(int i=0; i<daDeCriptare.length();i++){
			decriptata = decriptata + detrasposeChar(daDeCriptare.charAt(i));
		}
		return decriptata;
	}

}
