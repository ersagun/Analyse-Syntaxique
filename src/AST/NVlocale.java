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

	public NVlocale(String string) {
		super("varlocal");
		this.nom=string;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		String s="";
		if(this.ref!=-2){
			s= "Noeud vlocale => #nom : "+this.nom+", #scope : "+this.scope;
		}
		if(this.nom!=""){
			s= "Noeud vlocale => #nom : "+this.nom;
		}
		return s; 
	}

	public void setScope(Integer integer) {
		this.scope=integer;
		
	}

}
