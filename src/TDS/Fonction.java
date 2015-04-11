package TDS;

public class Fonction extends TdsElement {

	int nbParam;
	int nbLoc;
	
	
	public Fonction(int idf,String cat,String nomp,String type,String scopep,int nbParamp,int nbLocp){
		super(idf, cat,nomp, type,scopep);
		this.nbParam=nbParamp;
		this.nbLoc=nbLocp;
	}
	
	public String toString(){
		return "idf : "+this.idf+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , scope : "+this.scope+" , nbParam : "+this.nbParam+" , nbLoc : "+this.nbLoc;
	}
}
