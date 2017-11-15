package com.ocr.dico;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
//import java.util.Arrays;

import com.ocr.observer.Observateur;

public class MyDico {

	//Notre collection d'observateurs
	private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();
	// The Word to guess
	private String myWord = new String();
	private String myCleanWord = new String();
	//Shown characters :
	private String showWord = "";

	//https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/ArrayUtils.html
	private char tab[] = {'a','e','i','o','u'};
	private char tabCh[][] = {{'à', 'â'}, {'é', 'è', 'ê', 'ë'}, {'î', 'ï'}, {'ô', 'ö'}, {'û', 'ù'}};
	
	// letters seek
	private short seekLetters = 0;
	private short foundLetters = 0;
	
	public MyDico() throws IOException {

		myWord = getWord();		
		myCleanWord = operateWord();
		System.out.println("Word to find : " + myWord);
		char cw[] = myWord.toCharArray();

		// We fill up the word to guess with blank characters
		for(int i = 0; i < cw.length; i++)
		{
			showWord += "*";
		}	
		
	}

	private boolean wordsEqual() {
		
		return (myWord == showWord);
	}
	// copy orginal word with word with no accents :
	private String operateWord() {
		// TODO Auto-generated method stub
		String str = myWord;
		char cw[] = str.toCharArray();


		for (int i = 0;i< cw.length;i++) {
			
			for (int o = 0;o< tab.length;o++) {
				//present = Arrays.asList(tabCh[o]).indexOf(cw[i]);
				for(char ccc : tabCh[o])
					if(ccc == cw[i]) {
						//found an occurence 
						System.out.println("Switched char : " + cw[i]);
						cw[i] = tab[o];
						
					}
			}
			
			
		}
		
		str = new String(cw);
		
		return str;
	}

	public String getWord() throws IOException {

		FileReader fr = null;
		LineNumberReader lnr = null;

		int nbre = (int)(Math.random()*336529);


		try {
			fr = new FileReader("src/dico/dictionnaire.txt");
			lnr = new LineNumberReader(fr);
			String s = lnr.readLine();

			while(s != null){

				if(nbre == lnr.getLineNumber())
					return s;
				s = lnr.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			// closes the stream and releases system resources
			if(fr != null)
				fr.close();
			if(lnr!= null)
				lnr.close();
		}

		return "";

	}

	// Method to compare the character sent with the current word :
	public void compareWords(char ch) {

		// increment the number of times we check a letter :
		seekLetters ++;
		
		char cw[] = myWord.toCharArray();
		char ccw[] = myCleanWord.toCharArray();
		
		for(int i = 0; i < cw.length; i++)
		{
			// check characters and accents within them :
			if (ccw[i] == ch) {

				// We found one char !! Yeah !!
				char[] chSh = showWord.toCharArray();
				chSh[i] = cw[i];
				showWord = String.valueOf(chSh);
				
				foundLetters++;
			}
		}

		//On avertit les observateurs que le mot à trouver est mis à jour :
		this.updateObservateur();

	}

	//Ajoute un observateur à la liste
	public void addObservateur(Observateur obs) {
		this.listObservateur.add(obs);
	}
	//Retire tous les observateurs de la liste
	public void delObservateur() {
		this.listObservateur = new ArrayList<Observateur>();
	}
	//Avertit les observateurs que l'objet observable a changé 
	//et invoque la méthode update() de chaque observateur
	public void updateObservateur() {

		for(Observateur obs : this.listObservateur )
			obs.update(showWord, (short)(seekLetters - foundLetters + 3),wordsEqual());
	}	


}
