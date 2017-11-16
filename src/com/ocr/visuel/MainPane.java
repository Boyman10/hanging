package com.ocr.visuel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

//http://syncor.blogspot.fr/2013/09/getting-started-with-log4j-2-in-eclipse.html
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Our main panel where we load inner panels whenever we need
 * @author John
 *
 */
public class MainPane extends JPanel {

	private static final long serialVersionUID = -1009948418725756829L;

	private AllPane myPan;
	
	// logging lines for tracing program execution
	private static Logger logger = LogManager.getRootLogger();
	
	/**
	 * Constructor which calls the first Panel on start
	 */
	public MainPane() {

		super();
		// first time we call the about panel :
		myPan = new AboutPane();
		logger.info("calling MainPane - launch About page");
	}

	// Method called each time we paint the frame
	public void paintComponent(Graphics g){

		logger.info("MainPane - painting");
		
		// first off : remove all components :
		removeTout();
		
		super.paintComponent(g);

		this.setBackground(Color.white);
		
		// What kind of layout we launch :
		this.setLayout(new BorderLayout()); 

		// we will ad generic data instead here as we are only calling about pane for now ------TODO-----
		this.add((AboutPane)myPan);

	}     

	public void removeTout() {

		this.removeAll();
		this.revalidate();
	}


	public void setPan(AllPane thePan) {
		
		logger.info("MainPane - setting panel : " + thePan.getClass().getSimpleName());
		
		myPan = thePan;
		removeTout();
		
	}


}
