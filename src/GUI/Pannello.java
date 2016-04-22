package GUI;



import java.awt.event.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Util_GUI.StateUtil;


public class Pannello{
	
	/**
	 *La classe <code>Pannello</code> è la classe padre delle altre GUI che rappresentano i pannelli di quella principale.
	 *@param panel = JPanel che rappresenta il corpo del pannello
	 *@param tabbedPane = JTabbedPane che è dove viene inserito il pannello
	 *@param btnX = JButton elimina il pannello dalla tabbedPane
	 *@param btnOption = JButton realizza un bottone che verrà poi implementato nelle sue sottoclassi
	 *@param btnOk = JButton realizza un bottone che verrà poi implementato nelle sue sottoclassi
	 *@param comboBox = JComboBox<String> è una combo box con l'elencco dei cifrari
	 *@param codice = StateUtil è l'oggetto che gestisce lo stato del cifrario corrente
	 *@param upperlabel = JLabel indica cosa conterrà l'uppteTextArea
	 *@param upperScrollPane = JScrollPane che contiene l'upperTextArea
	 *@param upperTextArea = JTextArea che verrà utilizzata dalle sottoclassi
	 *@param lowerLabel = JLabel indica cosa conterrà la lowerTextArea
	 *@param lowerScrollPane = JScrollPane che contiene la lowerTextArea
	 *@param lowerTextArea = JTextArea che verrà utilizzata dalle sottoclassi
	 *@author Nicola Landro
	 *@version 0.0
	 */

	private JPanel panel;
	
	private JTabbedPane tabbedPane;
	
	private JButton btnX;
	private JButton btnOption;
	private JButton btnOk;
	
	private JComboBox<String> comboBox;
	private StateUtil codice;
	
	private JLabel upperlabel;
	private JScrollPane upperScrollPane;
	private JTextArea upperTextArea;
	
	private JLabel lowerLabel;
	private JScrollPane lowerScrollPane;
	private JTextArea lowerTextArea;

	
	
	
	
	/**
	 * Crea il Pannello.
	 * @param t = JTabbedPane
	 * @param upperLabelName = String nome del label riferito alla upperTextArea
	 * @param lowerLabelName = String nome del label riferito alla lowerTextArea
	 */
	public Pannello(JTabbedPane t, String upperLabelName, String lowerLabelName) {
		tabbedPane =t;
		
		
			
		btnX = new JButton("x");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(tabbedPane, "Sei sicuro di voler uscire? "
						, "Exit", JOptionPane.YES_NO_OPTION
						, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
				
					tabbedPane.remove(panel);
				}
			}
		});
		
		//Panel and Layout
		panel = new JPanel();

		panel.add(btnX);
		
		
		codice = new StateUtil();
		
		comboBox = new JComboBox<String>();		
		comboBox.addItem("Cifrario Cesare");
		comboBox.addItem("Cifrario Per Spostamento");
		comboBox.addItem("Cifrario Per Sostituzione");
		comboBox.addItem("Codice Morse");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codice.setStato((String)comboBox.getSelectedItem());
			}
		});
		
		btnOption = new JButton("Option");
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codice.getOpzioni().setVisible(true);
			}
		});
		
		btnOk = new JButton("OK");
		
		upperTextArea = new JTextArea();
		upperScrollPane = new JScrollPane(upperTextArea);
		
		lowerTextArea = new JTextArea();
		lowerTextArea.setEditable(false);
		lowerScrollPane = new JScrollPane(lowerTextArea);
		
		upperlabel = new JLabel(upperLabelName);
		
		lowerLabel = new JLabel(lowerLabelName);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(upperScrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(comboBox, 0, 379, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnX))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(upperlabel)
									.addPreferredGap(ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
									.addComponent(btnOk)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnOption)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(12))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lowerScrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lowerLabel)
							.addContainerGap(360, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnX)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOption)
						.addComponent(btnOk)
						.addComponent(upperlabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(upperScrollPane, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(lowerLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lowerScrollPane, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
	}
	
	/**
	 * Metodo che restituisce il pannello creato
	 * @return panel = JPanel
	 */
	public JPanel getPanel(){
		return panel;
	}
	/**
	 * Metodo che restituisce la JTabbedPane in cui il pannello si trova
	 * @return tabbedPane = JTabbedPane
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	/**
	 * Metodo che restituisce il bottone option
	 * @return btnOption = JButton
	 */
	public JButton getBtnOption() {
		return btnOption;
	}
	
	/**
	 * Metodo che restituisce il bottone ok
	 * @return btnOK = JButton
	 */
	public JButton getBtnOk() {
		return btnOk;
	}
	
	/**
	 * Metodo che restituisce la comboBox
	 * @return comboBox = JComboBox
	 */
	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	
	/**
	 * Metodo che setta la comboBox
	 * @return void
	 */
	public void setComboBox(String[] s) {
		this.comboBox = new JComboBox<String>(s);
	}
	
	/**
	 * Metodo che restituisce la upperTextArea
	 * @return upperTextArea = TextArea
	 */
	public JTextArea getUpperTextArea() {
		return upperTextArea;
	}
	public void setTextUpperTextArea(String text){
		upperTextArea.setText(text);
	}
	/**
	 * Metodo che restituisce la lowerTextArea
	 * @return lowerTextArea = TextArea
	 */
	public JTextArea getLowerTextArea() {
		return lowerTextArea;
	}
	
	/**
	 * Metodo che restituisce l'oggetto che determina lo stato del cifrario
	 * @return codice = StateUtil
	 */
	public StateUtil getCodice(){
		return codice;
	}
	
}
