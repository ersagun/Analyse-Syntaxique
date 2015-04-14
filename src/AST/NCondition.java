package AST;

import TDS.TDS;

public class NCondition extends NoeudElement {
	String condition;
	public NCondition(String condition) {
		super("condition");
		this.condition=condition;
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return  "Noeud condition => #condition : " + this.condition;
	}

}
