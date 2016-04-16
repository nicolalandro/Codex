package Util;


public abstract class Cifrario {
	/**
	 *La classe <code>Cifrario</code> è la classe padre di tutti i cifrari.
	 *@param storia = String che contiene la storia del cifrario
	 *@author Nicola Landro
	 *@version 0.0
	 */
	private String storia;
	
	/**
	 * metodo che restituisce la storia del cifrario
	 * @return storia = String che contiene la storia
	 */
	public String getStoria(){
		return this.storia;
	}
	/**
	 * metodo che setta la storia del cifrario
	 * @param s = String che contiene la storia
	 * @return void
	 */
	protected void setStoria(String s){
		this.storia = s;
	}
	/**
	 * metodo astratto 
	 * @param daCriptare = String da criptare
	 * @return String = criptata
	 */
	abstract public String cript(String daCriptare);
	/**
	 * metodo astratto 
	 * @param criptata = String criptata
	 * @return String = deCriptata
	 */
	abstract public String deCript(String daDeCriptare);
	

}
