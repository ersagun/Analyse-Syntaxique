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
		return "idf : "+this.id+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , nbParam : "+this.nbParam+" , nbLoc : "+this.nbLoc;
	}

	public int getNbParam() {
		return nbParam;
	}

	public int getNbLoc() {
		return nbLoc;
	}
	
	public String getType(){
		return this.type;
	}
	
	
	public int getId(){
		return this.id;
	}
	
	public String getNom(){
		return this.nom;
	}
}
