package Util_GUI;

//import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Opzioni {
	/**
	 *La classe <code>Opzioni</code> è la classe padre di tutte le Opzioni dei cifrari particolari.
	 *@param window = JDialog che rappresenta le opzioni
	 *@param btnOk = JButton che realizza le operazioni e chiude la finestra
	 *@param panel = JPanel il pannello in cui verranno inserite le opzioni particolari
	 *@author Nicola Landro
	 *@version 0.0
	 */
	private JDialog window;
	private JButton btnOk;
	private JPanel panel;
	
	/**
	 *Costruisce l'oggetto Opzioni, che realizza una finestra GUI per settare delle opzioni
	 */
	public Opzioni(){
		window = new JDialog();
		
		//OnClose
		window.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		window.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		       setVisible(false); 
		    }
		});
		window.setResizable(false);
		window.setSize(429,258);

		//In centro allo schermo
		window.setLocationRelativeTo(null);
		
		btnOk = new JButton("OK");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOk)
					.addGap(14))
		);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		window.getContentPane().setLayout(groupLayout);
		
		
		
	}
	
	/**
	 * Metodo che inizializza la finestra per specificare che nessuna opzione deve essere settata
	 * @return void
	 */
	public void noOption(){
		panel.add(new JLabel("Nessuna Opzione deve essere settata."));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
			}
		});
	}
	
	/**
	 * Metodo che restituisce la JDialog
	 * @return window = JDialog
	 */
	public JDialog getWindow(){
		return window;
	}
	
	/**
	 * Metodo che rende visibile o meno la finestra
	 * @param b = boolean che indica la visibilità
	 * @return void
	 */
	public void setVisible(boolean b){
		window.setVisible(b);
	}
	
	/**
	 * Metodo che restituisce il pannello
	 * @return panel = JPanel
	 */
	protected JPanel getPanel(){
		return panel;
	}
	
	/**
	 * Metodo che restituisce il bottone Ok
	 * @return btnOk = JButton
	 */
	protected JButton getConfirmButton(){
		return btnOk;
	}

}
