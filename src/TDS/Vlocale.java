package TDS;

public class Vlocale extends TdsElement {
	String scope;
	int rang;

	public Vlocale(int idf,String cat,String nomp,String type,String scopep,int rangp){
		super(idf, cat,nomp, type,scopep);
		this.scope=scopep;
		this.rang=rangp;
	}
}
