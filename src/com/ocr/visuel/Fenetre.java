package com.ocr.visuel;

import javax.swing.JFrame;

//notre PANEL est l'observateur
//https://openclassrooms.com/courses/apprenez-a-programmer-en-java/interagir-avec-des-boutons

public class Fenetre extends JFrame{

	private static final long serialVersionUID = -2654032239268488999L;

	private MyMenu ourMenu;
	private MainPane defaultPan;

	public Fenetre(){

		this.setTitle("Ma JFrame qui PEND");
		this.setSize(1200,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// Now our main panel : about 
		defaultPan = new MainPane();
		
		ourMenu = new MyMenu(defaultPan);
		// We add our menu now :
		this.setJMenuBar(ourMenu);
		
  	  	this.setContentPane(defaultPan);	

		this.setVisible(true);

	}

	
}
