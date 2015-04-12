package AST;

import java.util.ArrayList;

import TDS.TDS;

public class NOperation extends NoeudElement {
	
	
	
	//creation de noeud d'operation +,-,*,:,=
	public NOperation(String t) {
		super(t);
	}
	

	@Override
	public String afficherNoeud(TDS tds) {
		return 	"Noeud operation => #type : " + this.categorie;
	}

}
