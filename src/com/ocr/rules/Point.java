package com.ocr.rules;

public class Point {

	private String pseudo;
	private int nbPts;
	private short nbMots;
	
	public Point() {
		
		pseudo = new String("anonyme");
		nbPts = 0;
		nbMots = 0;
	}
	
	public void addPoints(int pts) {
		
		nbPts += pts;
		
	}
	
	public void addMots(short pts) {
		
		nbMots += pts;
		
	}	
	
	// we set the pseudo :
	public void setPseudo(String ps)   throws  PseudoException {
		
		// attention si déjà indiqué
		if (pseudo != "anonyme" && pseudo != ps)
			throw new PseudoException();
			else
				pseudo = ps;		
	}

	public short getNbMots() {
		
		return nbMots;
	}
	
	public int getPts() {
		
		return nbPts;
	}
	
	@Override
	public String toString() {
		return "Point [pseudo=" + pseudo + ", nbPts=" + nbPts + ", nbMots=" + nbMots + "]";
	}

	public String getPseudo() {
		
		return pseudo;
	}		
	// Class d exception pour une erreur / pseudo
	public class PseudoException extends Exception{ 

		private static final long serialVersionUID = 8428533246678160233L;

		public PseudoException(){
		    System.out.println("Vous essayez de placer un pseudo différent de celui en cours d'utilisation !");
		  }  
		}
	
}
