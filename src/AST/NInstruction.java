package AST;

import TDS.TDS;

public class NInstruction extends NoeudElement{

	public NInstruction() {
		super("instruction");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud instruction => #type : =ninstruction";
	}

}
