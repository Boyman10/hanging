package com.ocr.visuel;

import java.awt.Color;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
//import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ocr.dico.MyDico;
import com.ocr.observer.Observateur;
import com.ocr.rules.Point;
import com.ocr.rules.Point.PseudoException;
import com.ocr.rules.Rule;
import com.ocr.visuel.images.ImgPanel;

/**
 * Class to handle the game view :
 * @author John
 *
 */
public class NewPane extends JPanel implements AllPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3797492138992111545L;

	private JPanel panBtns = new JPanel();
	private ImgPanel myImgPanel = new ImgPanel();
	private JLabel mLbl = new JLabel("Mots trouvés :");
	private JLabel scLbl = new JLabel("Score actuel :");
	private JLabel leMot = new JLabel();
	private JPanel myBtns1 = new JPanel();
	private JPanel myBtns2 = new JPanel();
	private JPanel myBtns3 = new JPanel();	
	private MyDico dico;
	private Point curPts;

	// logging lines for tracing program execution
	private static Logger logger = LogManager.getRootLogger();

	/**
	 * New Pan constructor which call the dictionary
	 * We also initialize the nb of points
	 */
	public NewPane() {
		
		//super();
		logger.info("Called New panel - constructor");
		try {
			this.dico =  new MyDico();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// keep track of points by instantiating a new object on new panel
		curPts = new Point();
		
		initComponent();
		
	}
	
	public void initComponent() {

		this.clearMe();
		
		// set grid layout for whole panel
		this.setLayout(new GridLayout(1,1));

		//Add 2 panels :
		this.add(panBtns);	
		this.add(myImgPanel);

		panBtns.setBackground(Color.white);
		panBtns.setLayout(new BoxLayout(panBtns, BoxLayout.PAGE_AXIS));
		// Working with 1st panel :

		//Adding scores :
		panBtns.add(mLbl);
		panBtns.add(scLbl);


		//On initialise le JLabel avec notre mot à trouver :
		Font police = new Font("DS-digital", Font.TYPE1_FONT, 40);
		leMot.setFont(police);
		leMot.setForeground(Color.BLUE);
		leMot.setHorizontalTextPosition(JLabel.CENTER);
		
		// HERE the OBSERVER ;
		this.dico.addObservateur(new Observateur(){
			public void update(String wo, short diff, boolean wEqual) {
				
				leMot.setText(wo);
				myImgPanel.setMyImg("image" + diff + ".jpg");

				myImgPanel.repaint();
				System.out.println("updating image to " + diff);
				
				Rule check = new Rule();
				
				// si on atteind le max d erreurs
				if (diff == check.getMaxTries() ) {
					// supprime les boutons et propose un nouveau jeu
					// Reset points
					curPts = new Point();
					clearMe();
					
				} else if(wEqual) {
					
					// update points class with current word found :
					short pp = check.getPts(diff);	
					
					// open dialog box to ask for pseudo if TOP 10 !
					//https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-menus-et-boites-de-dialogue

			        ZDialog zd = new ZDialog(null, "Coucou les ZérOs", true);
			        ZDialogInfo zInfo = zd.showZDialog();
			        
			        // on place le pseudo 
			        try {
						curPts.setPseudo(zInfo.toString());
						
					} catch (PseudoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        
			        
				    JOptionPane.showInputDialog(null, "Veuillez décliner votre identité !", "Gendarmerie nationale !", JOptionPane.QUESTION_MESSAGE);				
					
				}
			}
		});

	
		panBtns.add(leMot);

		this.dico.updateObservateur();

		myBtns1.setLayout(new BoxLayout(myBtns1, BoxLayout.LINE_AXIS));
		myBtns2.setLayout(new BoxLayout(myBtns2, BoxLayout.LINE_AXIS));
		myBtns3.setLayout(new BoxLayout(myBtns3, BoxLayout.LINE_AXIS));


		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		short i = 0;
		for(char chr : alphabet) {
			JButton jbut = new JButton(Character.toString(chr));
			if(++i < 7)
				myBtns1.add(jbut);
			else if(i >= 7 && i < 15)
				myBtns2.add(jbut);
			else
				myBtns3.add(jbut);
			jbut.addActionListener(new BoutonListener(chr)); 

		}

		// NOw the buttons :
		panBtns.add(myBtns1);
		panBtns.add(myBtns2);
		panBtns.add(myBtns3);

	}

	// I m listening to my buttons :
	class BoutonListener implements ActionListener{

		char myChar;

		public BoutonListener(char ch) {		
			myChar = ch;			
		}

		public void actionPerformed(ActionEvent arg0) {

			System.out.println("Click on : " + myChar);
			
			// Now work on the word to check the letter and apply changes ALGORITHM :
			dico.compareWords(myChar);
		}

	}


	
	public void clearMe() {

		removeTout();
		
		try {
			this.dico =  new MyDico();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		repaint();
		
	}

	@Override
	public void removeTout() {
		// TODO Auto-generated method stub
		this.removeAll();
		this.revalidate();
	}
}
