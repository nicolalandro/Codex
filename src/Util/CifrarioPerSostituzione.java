package Util;

import java.util.StringTokenizer;

public class CifrarioPerSostituzione extends Cifrario{
	/**
	 *La classe <code>CifrarioPerSOstituzione</code> è la classe che realizza l'omonima codifica.
	 *@param sostituito = String[] array che ha nell'indice il carattere da criptare e come valore la stringa criptata
	 *@author Nicola Landro
	 *@version 0.0
	 */
	private String[] sostituto;
	
	/**
	 *Costruisce un oggetto che è in grado di criptare e decriptare secondo le regole del cifrario per sostituzione
	 */
	public CifrarioPerSostituzione(){
		super.setStoria("In parallelo ai cifrari per trasposizione (probabilmente nati ai tempi"
				+ " della guerra del Peloponneso) nascono i codici per spostamento. Questo"
				+ " codice consiste nell'effettuare una sostituzione rigorosa di un simbolo"
				+ " con un altro scelto secondo una convenzione comune agli utilizzatori."
				+ "\nQuesto cifrario ha avuto un grande uso, tra i tanti principale sicuramente è quello bellico.");
		
		sostituto = new String[Character.MAX_VALUE+1];
		for(int i=0;i<Character.MAX_VALUE+1;i++){
			sostituto[i]=""+(char)i;
		}
		sostituto[(int)' ']="space";
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
			criptata = criptata + sostituto[(int) daCriptare.charAt(i)]+" "; //il cast a int non è necessario ma rende più chiaro
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
		StringTokenizer tokenizzatore = new StringTokenizer(daDeCriptare, " ");
		String attuale;
		while(tokenizzatore.hasMoreTokens()){
			attuale = tokenizzatore.nextToken();
			if(attuale!=""){
				for(int i=0; i<sostituto.length;i++){
					if(sostituto[i].equals(attuale)){
						decriptata = decriptata + (char) i;
					}
				}
			}
			else{
				decriptata = decriptata + " ";
			}
		}
		
		return decriptata;
	}
	
	/**
	 * setta una determinata lettera
	 * @param letteraDaTrasformare = char che specifica un carattere
	 * @param letteraTrasformata= String la stringa che indica come viene trasformato
	 * @return void
	 */
	public void setLettera(char letteraDaTrasformare, String letteraTrasformata){
		sostituto[(int)letteraDaTrasformare] = letteraTrasformata;
	}


}
