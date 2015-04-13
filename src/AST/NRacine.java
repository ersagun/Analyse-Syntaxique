package AST;

import TDS.TDS;

public class NRacine extends NoeudElement {

	
	//creation de noeud de racine
	public NRacine() {
		super("racine");
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud => #type : " + this.categorie;
	}

}
