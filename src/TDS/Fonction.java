package TDS;

public class Fonction extends TdsElement {

	int nbParam;
	int nbLoc;
	int rang;
	
	public Fonction(String idf,String cat,String type,String scopep,int nbParamp,int nbLocp, int rangp){
		super(idf, cat, type,scopep);
		this.nbParam=nbParamp;
		this.nbLoc=nbLocp;
		this.rang=rangp;
	}
}
