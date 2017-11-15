package com.ocr.rules;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * CLASS TO READ and WRITE TO FILE FOR SCORES
 */
public class Score {

	List<Point> pts = new ArrayList<Point>();

	public Score() {

		// retrieve listing of scores 
		readList();
	}


	@Override
	public String toString() {


		String str = "";
		// iterate through the list and display :
		for(int i = 0; i < pts.size(); i++)
		{
			str += pts.get(i).toString();
		} 


		return str;		
	}

	private void readList() {


		// Récupération informations au sein du fichier scores.txt
		//ObjectInputStream
		//https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-flux-d-entree-sortie
		// Vérification de l'existence du fichier :
		ObjectInputStream ois;

		try {
			//On récupère maintenant les données !
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("scores.txt"))));

			try {

				// on lit la liste en tant qu'objet depuis le fichier
				pts = (List<Point>)ois.readObject();


			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}    

	}

	// return size of array of Point objects
	public int getSize() {

		return pts.size();
	}


	public void addPoint(Point myPts) {

		// on ajoute si pas encore 10 entrées :
		if (getSize() < 10)
			pts.add(myPts);
		else {

			// check nb de points et si ça vaut le coup d'ajouter au fichier :

		}
	}

	// write to file now : // ATTENTION ON DOIT AVOIR TOUS LES ELEMENTS... NEW EXCEPTION et pseudo ???...
	public void writePoints() {

		//ADD the new list to the file :
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("scores.txt"))));

			//Nous allons écrire la liste en tant qu'objet
			oos.writeObject(pts);

			//Ne pas oublier de fermer le flux !
			oos.close();		

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   

	}

}
