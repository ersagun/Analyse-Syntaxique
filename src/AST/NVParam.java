package AST;

import TDS.TDS;

public class NVParam extends NoeudElement {
	
	int ref;
	int scope;
	
	public NVParam(int refp,int scopep) {
		super("nvparam");
		this.ref=refp;
		this.scope=scopep;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return  "Noeud param => #type=nvparam, ref= "+this.ref+" ,scope: "+this.scope;
	}

}
