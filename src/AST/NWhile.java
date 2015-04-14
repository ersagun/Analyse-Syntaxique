package AST;

import TDS.TDS;

public class NWhile extends NoeudElement {

	public NWhile() {
		super("while");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud while => #while";
	}

}
