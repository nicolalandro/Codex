package Util_GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Util.CifrarioPerSostituzione;

public class OpzioniCifrarioPerSostituzione extends Opzioni{
	/**
	 *La classe <code>OpzioniCifrarioPerSostituzione</code> è la classe che realizza delle opzioni per un apposito cifrario, quello per sostituzione.
	 *@param cifrario = CifrarioPerSostituzione che indica il cifrario di cui si vuole settare le opzioni
	 *@param caratteri = ArrayList<SetCharCifrarioPerSostituzione> elenco di tutti i pannelli di opzioni presenti
	 *@param add = JButton per aggiungere pannello di opzioni
	 *@param settaggi = JPanel che contiene tutti i pannelli di opzioni
	 *@param xSettaggi = int che indica quanto è grande il grid layout
	 *@author Nicola Landro
	 *@version 0.0
	 */
	
	
	private CifrarioPerSostituzione cifrario;
	private ArrayList<SetCharCifrarioPerSostituzione> caratteri;
	private JButton add;
	private JPanel settaggi;
	private int xSettaggi;
	
	
	/**
	 *Costruisce l'oggetto Opzioni per il cifrarioPerSostituzione
	 *@param c = cifrarioPerSostituzione interessato ai cambiamenti
	 */
	public OpzioniCifrarioPerSostituzione(CifrarioPerSostituzione c){
		super();
		caratteri = new ArrayList<SetCharCifrarioPerSostituzione>();
		cifrario = c;
		
		
		JPanel panel = super.getPanel();
		BorderLayout layout = new BorderLayout();
		panel.setLayout(layout);
		
		xSettaggi=1;
		settaggi = new JPanel();
		settaggi.setLayout(new GridLayout(xSettaggi++,0));
		
		add = new JButton("add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settaggi.setLayout(new GridLayout(xSettaggi++,0));
				SetCharCifrarioPerSostituzione set = new SetCharCifrarioPerSostituzione(settaggi, caratteri, getWindow(), cifrario);
				caratteri.add(set);
				settaggi.add(set.getPanel());
				getWindow().pack();
			}
		});
		panel.add(add,BorderLayout.NORTH);
		panel.add(settaggi,BorderLayout.CENTER);
		
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
		for(int i=0; i<caratteri.size();i++){
			if(!caratteri.get(i).isCharEmpty()){
				if(caratteri.get(i).isStringWithoutSpace()){
					cifrario.setLettera(caratteri.get(i).getChar(), caratteri.get(i).getString());
					
				}
				else{
					JOptionPane.showMessageDialog(null
							, "Il carattere \"spazio\" non può essere usato nella stringa criptata."
							, "Errore",JOptionPane.ERROR_MESSAGE);	
				}
			}
		}
		super.setVisible(false);
	}

}
