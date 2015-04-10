package TDS;
/**
 * Cette classe represente les caracteristiques commun d'un element de tds
 * @author Ersagun
 *
 */
public abstract class TdsElement {
	int idf;
	String cat;
	String type;
	String scope;
	String nom;


	public TdsElement(int idfp,String catp,String nomp,String typep,String scopep){
		this.idf=idfp;
		this.cat=catp;
		this.nom=nomp;
		this.type=typep;
		this.scope=scopep;
	}	
}


