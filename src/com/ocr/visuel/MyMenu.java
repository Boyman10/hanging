package com.ocr.visuel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class MyMenu extends JMenuBar {


	private static final long serialVersionUID = 4939441333646325543L;

	private JMenu fichier = new JMenu("Fichier");
	private JMenuItem nouveau = new JMenuItem("Nouveau");
	private JMenuItem scores = new JMenuItem("Scores");
	private JMenuItem regles = new JMenuItem("Règles");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenu apropos = new JMenu("à".toUpperCase()  +  " propos");
	private JMenuItem infos = new JMenuItem("Infos");

	public MyMenu (MainPane pan) {

		super();
		// on initialise les menus :
		fichier.add(scores);
		fichier.addSeparator();
		fichier.add(nouveau);
		fichier.addSeparator();
		fichier.add(regles);

		// Nos mnemonics :
		fichier.setMnemonic('F');
		apropos.setMnemonic('o');

		apropos.add(infos);
		
		// menu quitter le jeu :
		quitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}        
		});

		// menu regles :
		regles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RulesPane rPan = new RulesPane();
				// change of panel
				pan.setPan(rPan);
			}
		});
		
		// menu About :
		infos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutPane rPan = new AboutPane();
				// change of panel
				pan.setPan(rPan);
				System.out.println("Changed to about Pan");
			}
		});
		
		// Now our new Game panel :
		nouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewPane rPan = new NewPane();
				// change of panel
				pan.setPan(rPan);
				System.out.println("Changed to NOUVEAU Pan");
			}
		});
		
		


		fichier.addSeparator();
		fichier.add(quitter);

		// on ajoute le tout à la menu bar
		this.add(fichier);
		this.add(apropos);
	}


}
