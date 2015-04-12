package AST;

import java.util.ArrayList;

import TDS.TDS;

public abstract class NoeudElement {

	String categorie;
	public ArrayList<NoeudElement> listeNoeud ;
	
	public NoeudElement(String categoriep){
		this.categorie=categoriep;
		this.listeNoeud=new ArrayList<NoeudElement>();
	}
	
	public abstract String afficherNoeud(TDS tds);
	
	public void ajouter1fils(NoeudElement n) {
		listeNoeud.add(n);
	}

	public void ajouterNFils(NoeudElement[] nNoeud) {
		for (int i = 0; i <= nNoeud.length; i++) {
			listeNoeud.add(nNoeud[i]);
		}
	}

	public void ajouterFG(NoeudElement n) {
		listeNoeud.add(n);
	}

	public void ajouterFD(NoeudElement n) {
		listeNoeud.add(n);
	}

	public NoeudElement getFG() {
		return listeNoeud.get(0);
	}

	public NoeudElement getFD() {
		return listeNoeud.get(1);
	}
}
