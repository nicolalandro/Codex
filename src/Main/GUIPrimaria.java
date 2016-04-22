package Main;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import GUI.*;

public class GUIPrimaria extends JFrame {

	/**
	 *La classe <code>GUIPrimaria</code> è la classe che realizza l'interfaccia grafica.
	 *@param serialVersionUID = long che è necessario per evitare un worning causato dal fatto che JFrame implementa serializable
	 *@param contentPane = JPanel che rappresenta il corpo centra della GUI
	 *@param pannelli = JTabbedPane che rappresenta tutti i pannelli che sono visibili
	 *@author Nicola Landro
	 *@version 0.0
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane pannelli;

	/**
	 * Crea il frame.
	 */
	public GUIPrimaria() {
		super("Codex");
		setIconImage(Toolkit.getDefaultToolkit().getImage("/home/mint/workspace/Codex (PrimaRelease)/Image/logo.png"));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(contentPane, "Sei sicuro di voler uscire?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
		    }
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pannelli = new JTabbedPane();
		contentPane.add(pannelli);
		
		setJMenuBar(createMenu());
	}

	
	/**
	 * Creo la barra di menu
	 * @return bar: oggetto di tipo JMenuBar
	 */
	private JMenuBar createMenu(){
		JMenuBar bar = new JMenuBar();
		
			JMenu filemenu = new JMenu("File");
			filemenu.setMnemonic('F');
			
				JMenuItem NuovoItem = new JMenuItem("Nuovo");
				NuovoItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String[] options = new String[] {"Criptare", "Decriptare"};
					    int response = JOptionPane.showOptionDialog(null, "Scegliere modalità.", "Crea Nuovo",
					        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
					        null, options, options[0]);
					    if(response==0){
					    	
					    	//Panel Cript
							pannelli.add(new Cript(pannelli).getPanel(),"nuovo.cript");
					    }
					    else if(response==1){
					    	//Panel Decript
							pannelli.add(new DeCript(pannelli).getPanel(),"nuovo.decript");
					    }
					}
				});
				NuovoItem.setMnemonic('N');
				filemenu.add(NuovoItem);
				
				JMenuItem aboutItem = new JMenuItem("About...");
				aboutItem.setMnemonic('A');
				filemenu.add(aboutItem);
				aboutItem.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent event){
							JOptionPane.showMessageDialog(contentPane, "Progetto creato da Nicola Landro 2016.", 
									"About",JOptionPane.PLAIN_MESSAGE);			
						}
					}
				);
			
				
				JMenuItem exitItem = new JMenuItem("Exit");
				exitItem.setMnemonic('X');
				filemenu.add(exitItem);
				exitItem.addActionListener(
						new ActionListener() {
							public void actionPerformed(ActionEvent event){
								System.exit(0);	
							}
						}
					);
		
		bar.add(filemenu);
			
		JMenu infomenu = new JMenu("Informazioni");
		infomenu.setMnemonic('O');
		JMenuItem storiaItem = new JMenuItem("Storia");
		storiaItem.setMnemonic('r');
		infomenu.add(storiaItem);
		storiaItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event){
						//Panel storia
						pannelli.add(new Storia(pannelli).getPanel(),"Storia");

				}}
			);
		bar.add(infomenu);
		
			JMenu helpmenu = new JMenu("Help");
			helpmenu.setMnemonic('H');
				JMenuItem helpItem = new JMenuItem("Help contents");
				helpItem.setMnemonic('c');
				helpmenu.add(helpItem);
				helpItem.addActionListener(
						new ActionListener() {
							public void actionPerformed(ActionEvent event){
								JOptionPane.showMessageDialog(contentPane, 
										"Questa applicazione è in grado di criptare e decriptare", 
										"Aiuto",JOptionPane.PLAIN_MESSAGE);				
							}
						}
					);
			bar.add(helpmenu);
		
		
		
		return bar;
		
	}
	
	
}
