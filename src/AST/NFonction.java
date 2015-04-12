package AST;

import java.util.ArrayList;

import TDS.TDS;

//une fonction a forcement comme scope, globale
public class NFonction extends NoeudElement {
	int ref;
	
	//creation de noeud de fonction
	public NFonction(int refp) {
		super("fonction");
		this.ref = refp;
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud fonction => #type : " + this.categorie+", #ref : " + this.ref+ " [informations recupéré dans le tds : "+tds.search(this.ref)+"]";
	}
}

