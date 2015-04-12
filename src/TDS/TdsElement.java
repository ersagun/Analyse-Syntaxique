package TDS;
/**
 * Cette classe represente les caracteristiques commun d'un element de tds
 * @author Ersagun
 *
 */
public abstract class TdsElement {
	int idf;
	String cat;
	String nom;


	public TdsElement(int idfp,String catp,String nomp){
		this.idf=idfp;
		this.cat=catp;
		this.nom=nomp;
	}
	
	public abstract String toString();
	
}


