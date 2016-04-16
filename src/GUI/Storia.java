package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//import java.awt.event.*;
import javax.swing.*;


public class Storia extends Pannello{
	/**
	 *La classe <code>Storia</code> realizza un tipo di Pannello particolare, utilizzato per interrogare i cifrari sulla loro storia.
	 *@author Nicola Landro
	 *@version 0.0
	 */

	/**
	 * Crea il Pannello storia.
	 * @param t = JTabbedPane
	 */
	public Storia(JTabbedPane t) {
		super(t, "Breve Descrizione della Criptologia", "Spiegazioni sul Cifrario selezionato");
		
		super.getBtnOk().setVisible(false);
		super.getBtnOk().setEnabled(false);
		
		super.getBtnOption().setVisible(false);
		super.getBtnOption().setEnabled(false);
		
		super.getUpperTextArea().setEditable(false);
		super.getUpperTextArea().setLineWrap(true);
		super.getUpperTextArea().setWrapStyleWord(true);
		super.getUpperTextArea().setText("La crittografia, ossia l'arte di scrivere in chiave, è nata con la scrittura"
				+ " stessa. Anche se gli egiziani ed i mesopotamici facevano già uso di metodi di"
				+ " cifratura, i primi a ssfruttarli appieno furono i greci ed i romani, culture"
				+ " bellicose, per le quali comunicare in segreto era un elemento fondamentale per il"
				+ " successo militare. Con loro si accese un conflitto nuovo: fra coloro che si"
				+ " dichiarano guardiani del segreto, i crittografi, e quelli che vogliono scoprirlo"
				+ " i crittanalisti. Si tratta di una lotta nell'ombra della quale, a seconda dell'epoca,"
				+ " hanno la meglio gli uni o gli altri, senza risolversi mai. \nTutta la crittografia è un"
				+ " un mondo infinito di creazione di nuovi codici sempre più complessi, e la ricerca "
				+ " di metodi per infrangere la loro sicurezza. Una sorta di gloriosa battaglia silenziosa.");
		
		super.getCodice().setStato("Cifrario Cesare");
		super.getLowerTextArea().setText(super.getCodice().getStoria());
		
		super.getLowerTextArea().setEditable(false);
		super.getLowerTextArea().setLineWrap(true);
		super.getLowerTextArea().setWrapStyleWord(true);
		
		super.getComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCodice().setStato((String)getComboBox().getSelectedItem());
				getLowerTextArea().setText(getCodice().getStoria());
			}
		});
		
	}


	
}
