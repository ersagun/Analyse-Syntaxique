package TDS;

public class Vlocale extends TdsElement {
	int rang;
	int scope;
	String type;

	public Vlocale(int id,String cat,String nomp,String typep,int scopep,int rangp){
		super(id, "variableLocal",nomp);
		this.rang=rangp;
		this.scope=scopep;
		this.type=typep;
	}
	
	public String toString(){
		return "idf : "+this.id+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , scope : "+this.scope+" , rang : "+this.rang;
	}
	
	public int getScope() {
		return scope;
	}

}
