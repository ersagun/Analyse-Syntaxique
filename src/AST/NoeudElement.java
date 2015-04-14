package AST;

import java.util.ArrayList;

import TDS.TDS;

/**
 * 
 * @author Groupe : Complilation L3 MIAGE 2014-2015
 *
 */
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
		for (int i = 0; i <= nNoeud.length-1; i++) {
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
	
	public ArrayList<NoeudElement> getChildren()
	{
		return this.listeNoeud;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	//PROBLEME
		
	public static String afficheLesFils(NoeudElement racine,TDS tds,String v) {
		int size=racine.listeNoeud.size();
		String s="";
		for(int i = size-1;i>=0;i--){
			s=racine.listeNoeud.get(i).afficherNoeud(tds)+"\n";
			v=s+NoeudElement.afficheLesFils(racine.listeNoeud.get(i),tds,v);
			
		}
		return v;
		}
}
