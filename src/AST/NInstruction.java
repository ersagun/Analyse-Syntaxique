package AST;

import TDS.TDS;

public class NInstruction extends NoeudElement{

	public NInstruction(NoeudElement e) {
		super("instruction");
		this.ajouter1fils(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud instruction => #type : =ninstruction";
	}

}
