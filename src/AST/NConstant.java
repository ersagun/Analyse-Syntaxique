package AST;

import TDS.TDS;

public class NConstant extends NoeudElement {
	int valeur;
	
	//creation de noeud de constant
	public NConstant(int v) {
		super("constant");
		this.valeur = v;
	}

	@Override
	public String afficherNoeud(TDS tds) {
		return "Noeud constant => #valeur : " + this.valeur;
	}

	public int getValeur() {
		return valeur;
	}
	
}
