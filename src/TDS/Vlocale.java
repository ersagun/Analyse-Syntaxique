package TDS;

public class Vlocale extends TdsElement {
	int rang;
	int scope;
	String type;

	public Vlocale(int idf,String cat,String nomp,String typep,int scopep,int rangp){
		super(idf, "variableLocal",nomp);
		this.rang=rangp;
		this.scope=scopep;
		this.type=typep;
	}
	
	public String toString(){
		return "idf : "+this.idf+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , scope : "+this.scope+" , rang : "+this.rang;
	}
}
