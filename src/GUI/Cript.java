package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




//import java.awt.event.*;
import javax.swing.*;

import _GUI_Test.Pannello_mod;
import Exception.InvalidCaracterCodiceMorseException;


public class Cript extends Pannello_mod{
	/**
	 *La classe <code>Cript</code> realizza un tipo di Pannello particolare, utilizzato per criptare.
	 *@author Nicola Landro
	 *@version 0.0
	 */
	

	/**
	 * Crea il Pannello cript.
	 * @param t = JTabbedPane
	 */
	public Cript(JTabbedPane t) {
		super(t, "Testo da Criptare", "Testo Criptato");
		
		super.getBtnOk().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getLowerTextArea().setText(getCodice().cript(getUpperTextArea().getText()));
				} catch (InvalidCaracterCodiceMorseException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Caratteri non supportati", 
							"Error",JOptionPane.ERROR_MESSAGE);			
				}
			}
		});
		
	}
	
}
