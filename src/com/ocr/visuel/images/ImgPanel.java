package com.ocr.visuel.images;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * We are using an image Panel only to show a panel containing an image
 * <b>The image can be changed any time by calling the public method setImg</b>
 * @author John
 *
 */
public class ImgPanel extends JPanel {

	private static final long serialVersionUID = -1907308929523265053L;
	private static Logger logger = LogManager.getRootLogger();
	private Image myImg ;
	
	// constructor passing the image name - could be implemented
	public ImgPanel() {
		
		super();
		logger.info("Calling Img Panel constructor");
		
		//https://openclassrooms.com/courses/apprenez-a-programmer-en-java/interagir-avec-des-boutons
		try {
			myImg = ImageIO.read(new File("src/images/" + "image2.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}   
	}
	
	// The paint method from JPanel class
	public void paintComponent(Graphics g){
		
		
		logger.info("Painting image Panel");
		
		this.setBackground(Color.white);
		//https://docs.oracle.com/javase/tutorial/2d/images/drawimage.html
		
		//center the image and draw it :
		g.drawImage(myImg, this.getWidth() / 2 - myImg.getWidth(null) / 2 ,10, this);
	} 	
	
	// Update the image :
	public void setMyImg(String img) {

		logger.info("Changing image Panel");
		
		try {
			myImg = ImageIO.read(new File("src/images/" + img));

		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
}
