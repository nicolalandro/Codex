package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//import java.awt.event.*;
import javax.swing.*;

import _GUI_Test.Pannello_mod;
import Exception.InvalidCaracterCodiceMorseException;


public class DeCript extends Pannello_mod{
	/**
	 *La classe <code>DeCript</code> realizza un tipo di Pannello particolare, utilizzato per decriptare.
	 *@author Nicola Landro
	 *@version 0.0
	 */

	/**
	 * Crea il Pannello decript.
	 * @param t = JTabbedPane
	 */
	public DeCript(JTabbedPane t) {
		super(t, "Testo Criptato", "Testo da Criptare");
		
		super.getBtnOk().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getLowerTextArea().setText(getCodice().deCript(getUpperTextArea().getText()));
				} catch (InvalidCaracterCodiceMorseException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Caratteri non supportati", 
							"Error",JOptionPane.ERROR_MESSAGE);			
				}
			}
		});
	}
}
