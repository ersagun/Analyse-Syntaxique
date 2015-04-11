package TDS;

public class Vlocale extends TdsElement {
	int rang;

	public Vlocale(int idf,String cat,String nomp,String type,String scopep,int rangp){
		super(idf, cat,nomp, type,scopep);
		this.rang=rangp;
	}
	
	public String toString(){
		return "idf : "+this.idf+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , scope : "+this.scope+" , rang : "+this.rang;
	}
}
