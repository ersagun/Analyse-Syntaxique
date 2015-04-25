package AST;

import java.util.ArrayList;

import TDS.*;


/**
 * 
 * @author Groupe : Complilation L3 MIAGE 2014-2015
 *
 */
public abstract class NoeudElement {

	String categorie;
	public ArrayList<NoeudElement> listeNoeud;

	public NoeudElement(String categoriep) {
		this.categorie = categoriep;
		this.listeNoeud = new ArrayList<NoeudElement>();
	}

	public abstract String afficherNoeud(TDS tds);

	public void ajouter1fils(NoeudElement n) {
		listeNoeud.add(n);
	}

	public void ajouterNFils(ArrayList<NoeudElement> nNoeud) {
		for (int i = 0; i <= nNoeud.size()-1 - 1; i++) {
			listeNoeud.add(nNoeud.get(i));
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

	public ArrayList<NoeudElement> getChildren() {
		return this.listeNoeud;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public static String afficheLesFils(NoeudElement racine, TDS tds, String v) {
		int size = racine.listeNoeud.size();
		String s = "";
		for (int i = size-1; i >= 0; i--) {
			s = racine.listeNoeud.get(i).afficherNoeud(tds) + "\n";
			v = s
					+ NoeudElement.afficheLesFils(racine.listeNoeud.get(i),
							tds, v);

		}
		return v;
	}
	

	public NoeudElement searchFonction(String nom,String ret,TDS tds) {
		NoeudElement retourne=null;
		System.out.println(nom+ret);
		TdsElement t=null;
		System.out.println(tds.getTable().size());
		for(TdsElement tt : tds.getTable()){
			if(t instanceof Fonction){
				System.out.println(t.toString());
				if(((Fonction)tt).getNom().equals(nom)/** && ((Fonction)tt).getType().equals(ret)**/){
					t=tt;
				}
			}
		}
		
		for (NoeudElement n : this.listeNoeud) {
			if (n instanceof NFonction) {
				if (((NFonction) n).getId(null)==t.getId()){
					retourne = n;
					break;
				}
			}
		}
		return retourne;
	}


	public NoeudElement getNiemeFils() {
		return this.listeNoeud.get(this.listeNoeud.size() - 1);
	}
	
	
}
