package AST;

import TDS.TDS;

public class NVlocale extends NoeudElement {
 int ref;
 int scope;
 String nom;
 
	public NVlocale(int refp,int scopep) {
		super("varlocal");
		this.ref=refp;
		this.scope=scopep;
		// TODO Auto-generated constructor stub
	}
	
	public NVlocale(String nomm,int scopep){
		super("varlocal");
		this.nom=nomm;
		this.scope=scopep;
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return  "Noeud vlocale => #nom : "+this.nom+", #scope : "+this.scope;
	}

	public void setScope(Integer integer) {
		this.scope=integer;
		
	}

}
