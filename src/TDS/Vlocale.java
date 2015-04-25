package TDS;

public class Vlocale extends TdsElement {
	int rang;
	int scope;
	String type;
	int val;

	public Vlocale(int id,String nomp,String typep,int scopep,int rangp,int val){
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
	
	public void setScope(int s){
		this.scope=s;
	}

	public void setType(String string) {
		this.type=string;
		
	}

	public void setId(int cpt_tdsId) {
		this.id=cpt_tdsId;
		
	}

}
