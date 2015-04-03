package TDS;
/**
 * Cette classe represente les caracteristiques commun d'un element de tds
 * @author Ersagun
 *
 */
public class TdsElement {
	String idf;
	String cat;
	String type;
	String scope;


	public TdsElement(String idfp,String catp,String typep,String scopep){
		this.idf=idfp;
		this.cat=catp;
		this.type=typep;
		this.scope=scopep;
	}
	
}


