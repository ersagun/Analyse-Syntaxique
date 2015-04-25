package AST;

import TDS.*;

public class NAppelFonction extends NoeudElement {
	public int ref;
	public NListeParam listeparam;
	public NAppelFonction(int ref,NListeParam l) {
		super("appelFonction");
		this.ref=ref;
		this.listeparam=l;
		
		// TODO Auto-generated constructor stub
	}
	
	public NAppelFonction(int ref) {
		super("appelFonction");
		this.ref=ref;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		String listeparam="";
		
		for(int i=0;i<=this.listeparam.listeParam.size()-1;i++){
			listeparam=listeparam+this.listeparam.listeParam.get(i).afficherNoeud(tds)+",";
		}
		return "Noeud AppelFonction => #type : = appelFonction, ref:"+this.ref+ "liste de parametre : "+listeparam;
	}
	
	public void ajouterListeParam(NListeParam lp){
		this.listeparam=lp;
	}
}
