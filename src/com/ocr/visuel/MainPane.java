package com.ocr.visuel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MainPane extends JPanel {

	private static final long serialVersionUID = -1009948418725756829L;

	private AllPane myPan;

	public MainPane() {

		super();
		// first time we call the about panel :
		myPan = new AboutPane();
	}

	public void paintComponent(Graphics g){

		// first off : remove all components :
		removeTout();
		super.paintComponent(g);

		this.setBackground(Color.white);
		// on définit le type de layout à employer pour notre panneau :
		this.setLayout(new BorderLayout()); 

		myPan.removeMe();
		myPan.initPane(this);

	}     

	public void removeTout() {

		// On dessine celui-ci afin qu'il prenne tout la surface
		this.removeAll();
		this.revalidate();
	}


	public void setPan(AllPane thePan) {
		
		myPan = thePan;
		myPan.removeMe();
		removeTout();
		
	}


}
