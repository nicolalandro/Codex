package Util_GUI;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import Util.CifrarioPerSostituzione;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SetCharCifrarioPerSostituzione {
	/**
	 *La classe <code>OpzioniCifrarioPerSostituzione</code> è la classe che realizza un pannello di opzioni per la classe OpzioniCIfrarioPerSostituzione.
	 *@param p = JPanel, il pannello restituito
	 *@param daCriptare = JTextField in cui l'utente specificherà il carattere da criptare
	 *@param criptata = JTextField in cui l'utente specificherà come il carattere verrà criptato 
	 *@author Nicola Landro
	 *@version 0.0
	 */
	private JPanel p;
	private JTextField daCriptare;
	private JTextField criptata;
	private int pos;
	
	/**
	 *Costruisce un pannello di opzioni per la classe OpzioniCifrarioPerSppostamento
	 *@param aggiunto = JPanel in cui viene aggiunto
	 *@param list = ArrayList<SetCharCifrarioPerSostituzione> la lista in cui viene aggiunto
	 *@param dialog = JDialog in cui si troverà (perchè a volte è necessario eseguire un pack())
	 *@param c = CifrarioPerSostituzione da settare;
	 */
	public SetCharCifrarioPerSostituzione(JPanel aggiunto, ArrayList<SetCharCifrarioPerSostituzione> list, JDialog dialog, CifrarioPerSostituzione c){
		pos = list.size(); // non size-1 perchè fino a che non viene creato non viene aggiunto alla lista
		
		p = new JPanel();
		
		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aggiunto.remove(p);
				aggiunto.repaint();
				c.setLettera(getChar(), ""+getChar());
				list.remove(pos);
				dialog.pack();
			}
		});
		
		daCriptare = new JTextField();
		daCriptare.setEditable(true);
		daCriptare.setColumns(10);
		daCriptare.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				daCriptare.setEditable(false);
				daCriptare.setText(""+e.getKeyChar());
			}
		});
		
		JLabel lblDaCriptare = new JLabel("Da Criptare");
		
		criptata = new JTextField();
		criptata.setColumns(10);
		
		JLabel lblCriptato = new JLabel("Criptato");
		GroupLayout gl_p = new GroupLayout(p);
		gl_p.setHorizontalGroup(
			gl_p.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_p.createParallelGroup(Alignment.LEADING)
						.addComponent(daCriptare, 0, 0, Short.MAX_VALUE)
						.addComponent(lblDaCriptare, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_p.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_p.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(criptata, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_p.createSequentialGroup()
							.addGap(71)
							.addComponent(lblCriptato)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnX)
					.addGap(25))
		);
		gl_p.setVerticalGroup(
			gl_p.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_p.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_p.createSequentialGroup()
							.addGroup(gl_p.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDaCriptare)
								.addComponent(lblCriptato))
							.addGap(11)
							.addGroup(gl_p.createParallelGroup(Alignment.BASELINE)
								.addComponent(criptata, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(daCriptare, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_p.createSequentialGroup()
							.addComponent(btnX, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
							.addGap(10))))
		);
		p.setLayout(gl_p);
		
		
		
	}
	/**
	 * Metodo che restituisce il pannello
	 * @return panel = JPanel
	 */
	public JPanel getPanel(){
		return p;
	}
	/**
	 * Metodo che restituisce il carattere da criptare
	 * @return char 
	 */
	public char getChar(){
		return daCriptare.getText().charAt(0);
	}
	/**
	 * Metodo che verifica se c'è il carattere da criptare
	 * @return boolean = true se non c'è nessun carattere
	 */
	public boolean isCharEmpty(){
		return daCriptare.getText().isEmpty();
	}
	/**
	 * Metodo che restituisce la stringa criptata
	 * @return String
	 */
	public String getString(){
		return criptata.getText();
	}
	/**
	 * Metodo che verifica se la stringa criptata è accettabile
	 * @return boolean = true se non ci sono spazi
	 */
	public boolean isStringWithoutSpace(){
		boolean b=false;
		String s = criptata.getText();
		for(int i = 0; i< s.length();i++){
			if(s.isEmpty()||s.charAt(i)==(' ')){
				b = false;
				break;
			}
			else{
				b = true;
			}
		}
		return b;
	}
	
}
