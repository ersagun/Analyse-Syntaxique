package AST;

import TDS.TDS;

public class NReturn extends NoeudElement {
	
	public NReturn() {
		super("return");
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud de #ype : return ";
	}

}
