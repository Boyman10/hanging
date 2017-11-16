package com.ocr.visuel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ocr.rules.Rule;

public class RulesPane extends JPanel implements AllPane {


	private static final long serialVersionUID = 2040261851977514813L;
	private JLabel myTitle = new JLabel("Le jeu du PENDU :");
	private JLabel mySubTitle = new JLabel("COMPTE DES POINTS :");
	private JLabel myRules ;
	
	public RulesPane() {
		
		super();
		myRules = new JLabel(getRules());
		
	}

	public void paintComponent(Graphics g) {

		//Définition d'une police d'écriture
		Font police = new Font("Tahoma", Font.BOLD, 20);
		//On l'applique au JLabel
		myTitle.setFont(police);
		//Changement de la couleur du texte
		myTitle.setForeground(Color.black);
		//On modifie l'alignement du texte grâce aux attributs statiques
		//de la classe JLabel
		myTitle.setHorizontalAlignment(JLabel.CENTER);

		// SS titre et points :
		
		police = new Font("Tahoma", Font.BOLD, 16);
		//On l'applique au JLabel
		mySubTitle.setFont(police);
		//Changement de la couleur du texte
		mySubTitle.setForeground(Color.red);
		//On modifie l'alignement du texte grâce aux attributs statiques
		//de la classe JLabel
		mySubTitle.setHorizontalAlignment(JLabel.LEFT);		
			
		//myRules = new JLabel(getRules());
		myRules.setHorizontalAlignment(JLabel.CENTER);		
		
		// on définit le type de layout à employer pour notre panneau :
		this.setLayout(new BorderLayout()); 	
		
		// ajout du titre en haut de panneau :
		this.add(myTitle, BorderLayout.NORTH);
		this.add(mySubTitle, BorderLayout.CENTER);
		this.add(myRules, BorderLayout.SOUTH);
	}

	// method to get all the rules about points in le Pendu :
	public String getRules() {
		
		String str = "<html>";
		
		Rule rl = new Rule();
		
		for(short i = 0; i < rl.getMaxTries();i++) {
			
			str += "Mot trouvé avec " + String.valueOf(i) + " erreur(s) : " + String.valueOf(rl.getPts(i)) + "<br/>";
			
			
		}
		
		str+= "</html>";
		
		System.out.println(str);
		return str;
	}
	

	@Override
	public void removeTout() {
		// TODO Auto-generated method stub
		this.removeAll();
		this.revalidate();
	}
}
