package Util_GUI;

import Exception.InvalidCaracterCodiceMorseException;
import Util.*;

public class StateUtil {
	/**
	 *La classe <code>StateUtil</code> è la classe che gestisce i cifrari e le relative opzioni.
	 *@param opzioni = array di Opzioni una per ogni cifrario
	 *@param cifrari = array di Cifrario uno per ogni tipo di cifrario
	 *@param stato = String che ricorda qual'è il cifrario corrente
	 *@author Nicola Landro
	 *@version 0.0
	 */
	
	private Opzioni [] opzioni;
	private Cifrario [] cifrari;
	private String stato;
	
	/**
	 *Costruisce l'oggetto che gestisc ei cifrari e le relative opzioni
	 */
	public StateUtil(){
		opzioni = new Opzioni[4];
		cifrari = new Cifrario[4];
		
		setStato("Cifrario Cesare");
		
	}
	
	/**
	 * Metodo che consente di specificare lo stato attuale
	 * @param stato = String specifica lo stato
	 * @return void
	 */
	public void setStato(String stato){
		this.stato = stato;
	}
	
	/**
	 * Metodo che consente di specificare lo stato attuale
	 * @param stato = String specifica lo stato
	 * @return void
	 */
	public void setCifrarioCesare(int posizione){
		cifrari[posizione] = new CifrarioCesare();
		opzioni[posizione] = new Opzioni();
		opzioni[posizione].noOption();
	}
	
	private void setCifrarioPerSpostamento(int posizione){
		cifrari[posizione] = new CifrarioPerSpostamento();
		opzioni[posizione] = new OpzioniCifrarioPerSpostamento((CifrarioPerSpostamento)cifrari[posizione]);
	}
	private void setCifrarioPerSostituzione(int posizione){
		cifrari[posizione] = new CifrarioPerSostituzione();
		opzioni[posizione] = new OpzioniCifrarioPerSostituzione((CifrarioPerSostituzione)cifrari[posizione]);
	}
	private void setCodiceMorse(int posizione){
		cifrari[posizione] = new CodiceMorse();
		opzioni[posizione] = new Opzioni();
		opzioni[posizione].noOption();
	}
	
	private String cript(String tipo, String daCriptare) throws InvalidCaracterCodiceMorseException{
		String ret = null;
		switch(tipo){
			case "Cifrario Cesare":
				if(!(cifrari[0] instanceof CifrarioCesare)){
					setCifrarioCesare(0);
				}
				ret = cifrari[0].cript(daCriptare);
				break;
			case "Cifrario Per Spostamento":
				if(!(cifrari[1] instanceof CifrarioPerSpostamento)){
					setCifrarioPerSpostamento(1);
				}
				ret = cifrari[1].cript(daCriptare);
				break;
			case "Cifrario Per Sostituzione":
				if(!(cifrari[2] instanceof CifrarioPerSostituzione)){
					setCifrarioPerSostituzione(2);
				}
				ret = cifrari[2].cript(daCriptare);
				break;
			case "Codice Morse":
				if(!(cifrari[3] instanceof CodiceMorse)){
					setCodiceMorse(3);
				}
				ret = cifrari[3].cript(daCriptare);
				break;
		}
		
		if(ret==null){
			throw new InvalidCaracterCodiceMorseException(); 
		}
		
		return ret;
	}
	/**
	 * Metodo che consente di criptare una stringa
	 * @param daCriptare = String da criptare
	 * @return String criptata
	 */
	public String cript(String daCriptare) throws InvalidCaracterCodiceMorseException{
		return cript(stato, daCriptare);
	}
	
	private String deCript(String tipo, String daDeCriptare) throws InvalidCaracterCodiceMorseException{
		String ret = null;
		switch(tipo){
			case "Cifrario Cesare":
				if(!(cifrari[0] instanceof CifrarioCesare)){
					setCifrarioCesare(0);
				}
				ret = cifrari[0].deCript(daDeCriptare);
				break;
			case "Cifrario Per Spostamento":
				if(!(cifrari[1] instanceof CifrarioPerSpostamento)){
					setCifrarioPerSpostamento(1);
				}
				ret = cifrari[1].deCript(daDeCriptare);
				break;
			case "Cifrario Per Sostituzione":
				if(!(cifrari[2] instanceof CifrarioPerSostituzione)){
					setCifrarioPerSostituzione(2);
				}
				ret = cifrari[2].deCript(daDeCriptare);
				break;
			case "Codice Morse":
				if(!(cifrari[3] instanceof CodiceMorse)){
					setCodiceMorse(3);
				}
				ret = cifrari[3].deCript(daDeCriptare);
				break;
		}
		
		if(ret==null){
			throw new InvalidCaracterCodiceMorseException(); 
		}
		
		return ret;
	}
	/**
	 * Metodo che consente di decriptare una stringa
	 * @param daDeCriptare = String da decriptare
	 * @return String decriptata
	 */
	public String deCript(String daDeCriptare) throws InvalidCaracterCodiceMorseException{
		return deCript(stato, daDeCriptare);
	}
	
	private Opzioni getOpzioni(String tipo) {
		Opzioni ret = null;
		switch(tipo){
			case "Cifrario Cesare":
				if(!(cifrari[0] instanceof CifrarioCesare)){
					setCifrarioCesare(0);
				}
				ret = opzioni[0];
				break;
			case "Cifrario Per Spostamento":
				if(!(cifrari[1] instanceof CifrarioPerSpostamento)){
					setCifrarioPerSpostamento(1);
				}
				ret = opzioni[1];
				break;
			case "Cifrario Per Sostituzione":
				if(!(cifrari[2] instanceof CifrarioPerSostituzione)){
					setCifrarioPerSostituzione(2);
				}
				ret = opzioni[2];
				break;
			case "Codice Morse":
				if(!(cifrari[3] instanceof CodiceMorse)){
					setCodiceMorse(3);
				}
				ret = opzioni[3];
				break;
		}
		
		return ret;
	}
	
	/**
	 * Metodo che restituisce le opzioni del cifrario corrente
	 * @return Opzioni
	 */
	public Opzioni getOpzioni(){
		return getOpzioni(stato);
	}
	
	private String getStoria(String tipo) {
		String ret = null;
		switch(tipo){
			case "Cifrario Cesare":
				if(!(cifrari[0] instanceof CifrarioCesare)){
					setCifrarioCesare(0);
				}
				ret = cifrari[0].getStoria();
				break;
			case "Cifrario Per Spostamento":
				if(!(cifrari[1] instanceof CifrarioPerSpostamento)){
					setCifrarioPerSpostamento(1);
				}
				ret = cifrari[1].getStoria();
				break;
			case "Cifrario Per Sostituzione":
				if(!(cifrari[2] instanceof CifrarioPerSostituzione)){
					setCifrarioPerSostituzione(2);
				}
				ret = cifrari[2].getStoria();
				break;
			case "Codice Morse":
				if(!(cifrari[3] instanceof CodiceMorse)){
					setCodiceMorse(3);
				}
				ret = cifrari[3].getStoria();
				break;
		}
		
		return ret;
	}
	/**
	 * Metodo che restituisce la storia del cifrario corrente
	 * @return String
	 */
	public String getStoria(){
		return getStoria(stato);
	}


}
