package Util_GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Util.CifrarioPerSpostamento;

public class OpzioniCifrarioPerSpostamento extends Opzioni{
	/**
	 *La classe <code>OpzioniCifrarioPerSostituzione</code> è la classe che realizza delle opzioni per un apposito cifrario, quello per spostamento.
	 *@param cifrario = CifrarioPerSostituzione che indica il cifrario di cui si vuole settare le opzioni
	 *@param specifica = JLabel che indica la specifica dello spinner
	 *@param spinner = JSpinner che indica il settaggio
	 *@author Nicola Landro
	 *@version 0.0
	 */
	
	private CifrarioPerSpostamento cifrario;
	private JLabel specifica;
	private JSpinner spinner;
	
	
	/**
	 *Costruisce l'oggetto Opzioni per il cifrarioPerSpostamento
	 *@param c = cifrarioPerSpostamento interessato ai cambiamenti
	 */
	public OpzioniCifrarioPerSpostamento(CifrarioPerSpostamento c){
		super();
		
		cifrario = c;
		
		specifica = new JLabel("Specifica il vaolore di trasposizione");
		
		SpinnerNumberModel number = new SpinnerNumberModel(1, 0, Character.MAX_VALUE, 1); 
		spinner = new JSpinner(number);
		
		
		JPanel panel = super.getPanel();
		FlowLayout layout = new FlowLayout();
		panel.setLayout(layout);
		
		panel.add(specifica);
		panel.add(spinner);
		
		super.getConfirmButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickButton();
			}
		});
		
	}
	/**
	 * Metodo che implementa cosa accade quando viene cliccato il bottone Ok
	 * @return void
	 */
	public void clickButton() {
		cifrario.setTrasposizione((int) spinner.getValue());
		super.setVisible(false);
	}

}
