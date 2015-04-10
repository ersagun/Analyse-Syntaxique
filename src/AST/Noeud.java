package AST;

import java.util.ArrayList;

public class Noeud {

	String type;
	int ref;
	//Variable utilisé seulement quand un noeud contient une constante
	int valeur;
	ArrayList<Noeud> listeNoeud;

	
	public Noeud(String typep,int refp){
		this.type=typep;
		this.ref=refp;
		listeNoeud=new ArrayList<Noeud>();
	}
	
	public Noeud(){
		this.type="racine";
		listeNoeud=new ArrayList<Noeud>();
	}
	
	public Noeud(int v){
		this.valeur=v;
	}
	
	public Noeud(String typep){
		this.type=typep;
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
	
	public Noeud getFG(){
		return listeNoeud.get(0);
	}
	public Noeud getFD(){
		return listeNoeud.get(1);
	}
	
	
	
}
