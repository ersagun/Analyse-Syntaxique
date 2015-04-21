package TDS;

public class Vlocale extends TdsElement {
	int rang;
	int scope;
	String type;
	int val;

	public Vlocale(int id,String cat,String nomp,String typep,int scopep,int rangp,int val){
		super(id, "variableLocal",nomp);
		this.rang=rangp;
		this.scope=scopep;
		this.type=typep;
		this.val=val;
	}
	
	public String toString(){
		return "idf : "+this.id+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , scope : "+this.scope+" , rang : "+this.rang;
	}
	
	public int getScope() {
		return scope;
	}

	public int getVal() {
		return this.val;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setVal(int v){
		this.val=v;
	}

}
