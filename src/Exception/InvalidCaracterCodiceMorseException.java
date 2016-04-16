package Exception;

public class InvalidCaracterCodiceMorseException extends Exception{
	//Auto-generato (avrebbe dato un warning altrimenti)
	private static final long serialVersionUID = -2402362673720934782L;

	/**
	 * La classe <code>InvalidCaracterCodiceMorseException</code> realizza l'eccezione caratteri non validi per il codice morse.
	 *@author Nicola Landro
	 *@version 0.0
	 */
	
	private void catchException(){
		System.out.println("Il codice morse non accetta questi caratteri");
	}
	
	public void printStackTrace(){
		super.printStackTrace();
		this.catchException();
	}
	
}
