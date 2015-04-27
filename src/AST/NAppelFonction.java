package AST;

import TDS.*;

public class NAppelFonction extends NoeudElement {
	public int ref;
	public NListeParam listeparam=null;
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
		String f="";
		if(this.listeparam!=null){
			for(int i=0;i<=this.listeparam.listeParam.size()-1;i++){
				listeparam=listeparam+this.listeparam.listeParam.get(i).afficherNoeud(tds)+",";
			}
			f="Noeud AppelFonction => #type : = appelFonction, ref:"+this.ref+ " [informations recupéré dans le tds : "+tds.search(this.ref)+" liste de parametre : "+listeparam+"]";
		}else{
			f="Noeud AppelFonction => #type : = appelFonction, ref:"+this.ref+ " [informations recupéré dans le tds : "+tds.search(this.ref)+" sans param]";
		}
		
		return f;
	}
	
	public NListeParam getListeparam() {
		return listeparam;
	}

	public void setListeparam(NListeParam listeparam) {
		this.listeparam = listeparam;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public void ajouterListeParam(NListeParam lp){
		this.listeparam=lp;
	}
	
	public String getName(TDS tds)
	{
		Fonction f=(Fonction)tds.search(this.ref);
		return f.getNom();
	}
}
