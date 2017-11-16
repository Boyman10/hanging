package com.ocr.visuel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ocr.visuel.images.ImgPanel;

/**
 * AboutPane implementing the interface 
 * It displays only text via a 
 * @author John
 *
 */
public class AboutPane  extends JPanel implements AllPane {

	private static final long serialVersionUID = 2788078247138018951L;
	private JLabel myTitle = new JLabel("Welcome onto Hanged Man game !");
	private ImgPanel myImagePnl = new ImgPanel();

	private JLabel myText = new JLabel("You have 7 tries to find the word...");
	
	// logging lines for tracing program execution
	private static Logger logger = LogManager.getRootLogger();
	
	public AboutPane() {
		
		super();
		logger.info("Called about panel - constructor");
		// nothing yet ...
	}
	
	public void paintComponent(Graphics g) {

		logger.info("About panel painting");
		
		removeTout();
		
		// we update the image :
		myImagePnl.setMyImg("image1.jpg");
		
		// Define a style for our font :
		Font police = new Font("Tahoma", Font.BOLD, 20);
		// Applied to title :
		myTitle.setFont(police);
		
		// Define a  color
		myTitle.setForeground(Color.black);
		// Alignment for our text
		myTitle.setHorizontalAlignment(JLabel.CENTER);

		// Adding text
		myText.setHorizontalAlignment(JLabel.CENTER);
		
		
		// The title on top and the rest down :
		this.add(myTitle, BorderLayout.NORTH);
		this.add(myImagePnl, BorderLayout.CENTER);
		this.add(myText, BorderLayout.SOUTH);		
	}

	@Override
	public void removeTout() {
		// TODO Auto-generated method stub
		this.removeAll();
		this.revalidate();
	}
           	
}
