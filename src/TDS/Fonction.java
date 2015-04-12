package TDS;

public class Fonction extends TdsElement {

	int nbParam;
	int nbLoc;
	String type;
	
	
	public Fonction(int idf,String nomp,int nbParamp,int nbLocp,String typep){
		super(idf, "fonction", nomp);
		this.nbParam=nbParamp;
		this.nbLoc=nbLocp;
		this.type=typep;
	}
	
	public String toString(){
		return "idf : "+this.idf+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , nbParam : "+this.nbParam+" , nbLoc : "+this.nbLoc;
	}
}
