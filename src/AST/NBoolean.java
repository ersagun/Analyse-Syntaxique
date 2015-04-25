package AST;

import TDS.TDS;

public class NBoolean extends NoeudElement {
	String valeur;
	public NBoolean(String val) {
		super("boolean");
		this.valeur=val;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return null;
	}

}
