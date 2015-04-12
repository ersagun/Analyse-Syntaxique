package AST;

import java.util.ArrayList;

import TDS.TDS;

public class NVariable extends NoeudElement {
	int ref;
	int scope;
	
	//creation de noeud de identificateur comme variable i
	public NVariable(int refp,int scopep) {
		super("identificateur");
		this.ref = refp;
		this.scope=scopep;
	}
	

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud variable => #ref : "+this.ref+", #scope : "+this.scope+" [information recuperé de td grace a la ref : "+tds.search(this.ref, this.scope)+"]";
	}

}
