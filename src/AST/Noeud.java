package AST;

import java.util.ArrayList;

import TDS.TDS;

public class Noeud {
/**
	String type;
	int ref;
	// Variable utilisé seulement quand un noeud contient une constante
	int valeur;
	String scope;
	public ArrayList<Noeud> listeNoeud;

	
	//creation de noeud de fonction
	public Noeud(String typep, int refp) {
		this.type = typep;
		this.ref = refp;
		listeNoeud = new ArrayList<Noeud>();
		this.valeur = -1;
		this.scope="";
	}
	
	//creation de noeud de racine
	public Noeud() {
		this.type = "racine";
		this.ref = -1;
		listeNoeud = new ArrayList<Noeud>();
		this.valeur = -1;
		this.scope="";
	}

	//creation de noeud de constant
	public Noeud(int v) {
		this.type = "constant";
		this.ref = -1;
		this.valeur = v;
		listeNoeud = new ArrayList<Noeud>();
		this.scope="";
	}
	
	//creation de noeud de identificateur comme variable i
	public Noeud(String typep,int refp,String scopep) {
		this.type = typep;
		this.ref = refp;
		this.valeur = -1;
		listeNoeud = new ArrayList<Noeud>();
		this.scope=scopep;
	}
	
	//creation de noeud d'operation +,-,*,:,=
	public Noeud(String typep) {
		this.type = typep;
		this.ref = -1;
		this.valeur = -1;
		listeNoeud = new ArrayList<Noeud>();
		this.scope="";
	}

	**/

/**
	public String toString() {
		String v = "";
		// verification du type de noeud
		if (this.ref != -1 && this.type !="" && valeur == -1) {
			v = "Noeud #type : " + this.type + "#" + " #ref : " + this.ref+" infromation recuperé de td grace a la ref : ";
		}
		
		if (this.type == "" && this.ref == -1 && this.valeur != -1) {
			v = "Noeud constant #valeur : " + this.valeur;
		}
		
		if (this.type != "" && this.ref != -1 && this.valeur != -1) {
			v = "Noeud id #nom : " + this.valeur+" infromation recuperé de td grace a la ref : ";
		}

		if (this.type != "" && this.ref == -1 && this.valeur == -1) {
			v = "Noeud de #type : " + this.type;
		}
		return v;
	}
	
	public String afficherNoeud(TDS tds) {
		String v = "";
		// verification du type de noeud
		if (this.ref != -1 && this.type !="" && valeur == -1) {
			v = "Noeud #type : " + this.type + "#" + " #ref : " + this.ref+" infromation recuperé de td grace a la ref : "+tds.search(this.ref, this.scope);
		}
		
		if (this.type == "" && this.ref == -1 && this.valeur != -1) {
			v = "Noeud constant #valeur : " + this.valeur;
		}
		
		if (this.type != "" && this.ref != -1 && this.valeur != -1) {
			v = "Noeud id #nom : " + this.valeur+" infromation recuperé de td grace a la ref : "+tds.search(this.ref, this.scope);
		}

		if (this.type != "" && this.ref == -1 && this.valeur == -1) {
			v = "Noeud de #type : " + this.type;
		}
		return v;
	}
	
	**/
	
/**
	public static String afficheLesFilsDunNoeud(ArrayList<Noeud> l) {
	String v="";
	for(int i=0;i<=l.size()-1;i++){
		v=v+l.toString();
	}
	return v;
	}
	
	//
	
	public static String afficheLesFils(Noeud r) {
		int size=r.listeNoeud.size();
		String v="";
		for(int i = 0;i<=size-1;i++){
			Noeud.afficheLesFils(r.listeNoeud.get(i));
			v=v+r.listeNoeud.get(i).toString()+size;
		}

	return v;
	}
**/
}
