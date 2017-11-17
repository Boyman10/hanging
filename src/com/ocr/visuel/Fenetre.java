package com.ocr.visuel;


import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main Frame where we load the main Panel starting from About Panel
 * @author John
 *
 */
//https://openclassrooms.com/courses/apprenez-a-programmer-en-java/interagir-avec-des-boutons

public class Fenetre extends JFrame {

	private static final long serialVersionUID = -2654032239268488999L;
	// logging lines for tracing program execution
	private static Logger logger = LogManager.getRootLogger();
	
	private MyMenu ourMenu;
	private MainPane defaultPan;

	public Fenetre(){

		this.setTitle("Hanged man game by @Boyma10");
		this.setSize(1200,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// Now our main panel  
		defaultPan = new MainPane();
		
		this.setContentPane(defaultPan);
		ourMenu = new MyMenu(defaultPan);

		// We add our menu now :
		this.setJMenuBar(ourMenu);

			

		this.setVisible(true);

	}

}
