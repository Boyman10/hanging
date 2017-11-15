package com.ocr.rules;


/* Classe de définition de calculs de points */
public class Rule {

	private short maxTries;
	
	public Rule() {
		
		maxTries = 7;
	}
	
	public Rule(short tries) {
		
		maxTries = tries;
	}	
	
	
	public short getMaxTries() {
		
		return maxTries;
	}
	
	/* Algorithme de comptage de points*/
	public short getPts(short errors) {
		
		switch(errors) {
		
		case 0 : return 100;
		case 1 : return 50;
		case 2 : return 35;
		case 3 : return 25;
		case 4 : return 15;
		case 5 : return 10;
		case 6 : return 5;
		
		default : return 0;
			
		}
	}
	
}
