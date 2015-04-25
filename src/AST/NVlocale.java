package AST;

import TDS.TDS;

public class NVlocale extends NoeudElement {
 int ref;
 int scope;
 
	public NVlocale(int refp,int scopep) {
		super("varlocal");
		this.ref=refp;
		this.scope=scopep;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return  "Noeud vlocale => #ref : "+this.ref+", #scope : "+this.scope+" [information recuperé de td grace a la ref : "+tds.search(this.ref, this.scope)+"]";
	}

}
