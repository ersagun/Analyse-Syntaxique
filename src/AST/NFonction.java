package AST;

import TDS.*;

//une fonction a forcement comme scope, globale
public class NFonction extends NoeudElement {
	int ref;
	
	//creation de noeud de fonction
	public NFonction(int refp) {
		super("fonction");
		this.ref = refp;
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud fonction => #type : " + this.categorie+", #ref : " + this.ref+ " [informations recupéré dans le tds : "+tds.search(this.ref)+"]";
	}
	
	public int getnlocalvar(TDS tds){
		int nbvar=0;
		Fonction a=(Fonction)tds.search(this.ref);
		nbvar=a.getNbLoc();
		return nbvar;
	}
	
	public String getname(TDS tds){
		TdsElement a=tds.search(this.ref);
		String nom=a.getNom();
		return nom;
	}
	
	public int getId(TDS tds){
		return this.ref;
	}
}

