package AST;

import TDS.TDS;

public class NElse extends NoeudElement {

	public NElse() {
		super("else");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "noeud #type : else";
	}

}
