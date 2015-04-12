package TDS;

public class Variable extends TdsElement {
	int val;
	int scope;
	String type;

	public Variable(int idf,String nomp,int scopep,int valp,String typep){
		super(idf, "identificateur",nomp);
		this.val=valp;
		this.scope=scopep;
		this.type=typep;
	}

	
	public String toString(){
		return "idf : "+this.idf+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , scope : "+this.scope+" , val : "+this.val;
	}


	public int getScope() {
		return scope;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setScope(int scope) {
		this.scope = scope;
	}


	public int getVal() {
		return val;
	}


	public void setVal(int val) {
		this.val = val;
	}
}
