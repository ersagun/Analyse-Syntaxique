package AST;

import TDS.TDS;

public class NOperation extends NoeudElement {
	
	String val;
	
	//creation de noeud d'operation +,-,*,:,>,<
	public NOperation(String t) {
		super("operation");
		this.val=t;
		
	}	

	@Override
	public String afficherNoeud(TDS tds) {
		return 	"Noeud operation => #type : " + this.val;
	}


	public String getVal() {
		return val;
	}

}
