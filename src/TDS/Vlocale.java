package TDS;

public class Vlocale extends TdsElement {
	String scope;
	int rang;

	public Vlocale(String idf,String cat,String type,String scopep,int rangp){
		super(idf, cat, type,scopep);
		this.scope=scopep;
		this.rang=rangp;
	}
}
