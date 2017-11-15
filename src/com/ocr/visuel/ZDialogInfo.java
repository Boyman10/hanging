package com.ocr.visuel;

public class ZDialogInfo {
	  private String nom;

	  public ZDialogInfo(){}
	  public ZDialogInfo(String nom){
	    this.nom = nom;

	  }

	  public String toString(){
	    String str;
	    if(this.nom != null ){
	      str = "Description de l'objet InfoZDialog";
	      str += "Nom : " + this.nom + "\n";

	    }
	    else{
	      str = "Aucune information !";
	    }
	    return str;
	  }
	}
