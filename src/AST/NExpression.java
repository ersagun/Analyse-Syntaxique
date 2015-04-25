package AST;

import TDS.TDS;

public class NExpression extends NoeudElement {

	public NExpression(String categoriep) {
		super(categoriep);
		// TODO Auto-generated constructor stub
	}
	
	public NExpression(NoeudElement op) {
		super("expression");
		this.ajouter1fils(op);
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud Expression => #type : =nexpression";
	}

}
