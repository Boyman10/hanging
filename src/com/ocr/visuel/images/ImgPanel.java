package com.ocr.visuel.images;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImgPanel extends JPanel {

	private static final long serialVersionUID = -1907308929523265053L;

	private Image myImg ;
	
	// constructor passing the image name
	public ImgPanel() {
		
		super();
		
		//https://openclassrooms.com/courses/apprenez-a-programmer-en-java/interagir-avec-des-boutons
		try {
			myImg = ImageIO.read(new File("src/images/" + "image2.jpg"));

		} catch (IOException e) {
			e.printStackTrace();
		}   
	}
	
	public void paintComponent(Graphics g){
		
		this.setBackground(Color.white);
		//https://docs.oracle.com/javase/tutorial/2d/images/drawimage.html
		//center the image :
		g.drawImage(myImg, this.getWidth() / 2 - myImg.getWidth(null) / 2 ,10, this);
		System.out.println("Loading image to panel...");
	} 	
	
	// Update the image :
	public void setMyImg(String img) {

		
		try {
			myImg = ImageIO.read(new File("src/images/" + img));

		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
}
