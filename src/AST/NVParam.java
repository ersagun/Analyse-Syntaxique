package AST;

import TDS.TDS;

public class NVParam extends NoeudElement {
	
	int ref;
	int scope;
	String nom;
	
	public NVParam(int refp,int scopep) {
		super("nvparam");
		this.ref=refp;
		this.scope=scopep;
		// TODO Auto-generated constructor stub
	}
	
	public NVParam(String n){
		super("nvparam");
		this.nom=n;
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
	String s="";
		if(nom!=""){
		s=	"Noeud param => #type=nvparam, nom="+this.nom;
		}else
		{
		s=  "Noeud param => #type=nvparam, ref= "+this.ref+" ,scope: "+this.scope;
	
		}
		return s;
		}
}
