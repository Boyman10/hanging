package com.ocr.visuel;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Our menu with all links
 * @author John
 */
public class MyMenu extends JMenuBar {


	private static final long serialVersionUID = 4939441333646325543L;

	private JMenu fichier = new JMenu("Fichier");
	private JMenuItem nouveau = new JMenuItem("Nouveau");
	private JMenuItem scores = new JMenuItem("Scores");
	private JMenuItem regles = new JMenuItem("Règles");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenu apropos = new JMenu("à".toUpperCase()  +  " propos");
	private JMenuItem infos = new JMenuItem("Infos");
	
	// logging lines for tracing program execution
	private static Logger logger = LogManager.getRootLogger();
		
	public MyMenu (MainPane pan) {

		super();
		
		// Initialize menus :
		fichier.add(scores);
		fichier.addSeparator();
		fichier.add(nouveau);
		fichier.addSeparator();
		fichier.add(regles);

		// Our mnemonics :
		fichier.setMnemonic('F');
		apropos.setMnemonic('o');

		apropos.add(infos);
		
		// Quit the game :
		quitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}        
		});

		// our game rules :
		regles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RulesPane rPan = new RulesPane();
				// change of panel
				logger.info("Click on RULES menu - calling Rules Pan...");
				pan.setPan(rPan);
			}
		});
		
		// About :
		infos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutPane rPan = new AboutPane();
				// change of panel
				logger.info("Click on ABOUT menu - calling About Pan...");
				pan.setPan(rPan);
				
			}
		});
		
		// Now our new Game panel :
		nouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewPane rPan = new NewPane();
				logger.info("Click on NEW menu - calling NEW GAME Pan...");
				// change of panel
				pan.setPan(rPan);
				
			}
		});
		

		fichier.addSeparator();
		fichier.add(quitter);

		// We add everything to the menu bar
		this.add(fichier);
		this.add(apropos);
	}
 

}
