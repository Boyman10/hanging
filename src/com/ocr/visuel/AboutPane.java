package com.ocr.visuel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


import com.ocr.visuel.images.ImgPanel;

public class AboutPane implements AllPane{

	private JLabel myTitle = new JLabel("Bienvenue dans le jeu du pendu !");
	private ImgPanel myImagePnl = new ImgPanel();
	//private JTextPane myTextPnl = new JTextPane();
	private JLabel myText = new JLabel("Vous avez 7 coups pour trouver le mot caché...");

	public AboutPane() {
		
		myImagePnl.setMyImg("image1.jpg");
		
	}
	
	public void initPane(JPanel jpan) {

		//Définition d'une police d'écriture
		Font police = new Font("Tahoma", Font.BOLD, 20);
		//On l'applique au JLabel
		myTitle.setFont(police);
		//Changement de la couleur du texte
		myTitle.setForeground(Color.black);
		//On modifie l'alignement du texte grâce aux attributs statiques
		//de la classe JLabel
		myTitle.setHorizontalAlignment(JLabel.CENTER);

		// Ajout de texte 


		myText.setHorizontalAlignment(JLabel.CENTER);
		
		
		// ajout du titre en haut de panneau :
		jpan.add(myTitle, BorderLayout.NORTH);
		jpan.add(myImagePnl, BorderLayout.CENTER);
		jpan.add(myText, BorderLayout.SOUTH);		
	}
	
	public void removeMe() {
		
		myImagePnl.removeAll();
		myTitle.removeAll();
		myText.removeAll();
		
	}
           	
}
