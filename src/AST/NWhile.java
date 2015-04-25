package AST;

import TDS.TDS;

public class NWhile extends NoeudElement {

	public NWhile() {
		super("while");
		this.ajouterFG(new NCondition("racine-condition"));
		this.ajouterFD(new NOperation("racine-operation"));
		// TODO Auto-generated constructor stub
	}

	public NWhile(NoeudElement ne1, NoeudElement ne2) {
		super("while");
		ajouterFG(ne1);
		ajouterFD(ne2);
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud while => #while";
	}

}
