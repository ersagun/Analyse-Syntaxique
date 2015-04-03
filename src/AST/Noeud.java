package AST;

import java.util.ArrayList;

public class Noeud {

	String type;
	String ref;
	ArrayList<Noeud> listeNoeud;
	Noeud filsGauche;
	Noeud filsDroite;
	
	public Noeud(String typep,String refp){
		this.type=typep;
		this.ref=refp;
		listeNoeud=new ArrayList<Noeud>();
	}
	
	public Noeud(){
		this.type="racine";
		this.ref="";
		listeNoeud=new ArrayList<Noeud>();
	}
	
	public void ajouter1fils(Noeud n){
		listeNoeud.add(n);
	}
	
	public void ajouterNFils(Noeud[] nNoeud){
		for(int i=0;i<=nNoeud.length;i++){
			listeNoeud.add(nNoeud[i]);
		}
	}
	
	public void ajouterFG(Noeud n){
		listeNoeud.add(n);
	}
	
	public void ajouterFD(Noeud n){
		listeNoeud.add(n);
	}
	
	
}
