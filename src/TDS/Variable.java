package TDS;

public class Variable extends TdsElement {
	int val;
	int scope;
	String type;

	public Variable(int id,String nomp,int valp,String typep){
		super(id, "identificateur",nomp);
		this.val=valp;
		this.scope=-1;
		this.type=typep;
	}

	
	public String toString(){
		return "idf : "+this.id+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , scope : "+this.scope+" , val : "+this.val;
	}


	public int getScope() {
		return scope;
	}


	public String getType() {
		return type;
	}
	
	public int getId(){
		return id;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setScope(int scope) {
		this.scope = scope;
	}


	public int getVal() {
		return this.val;
	}


	public void setVal(int val) {
		this.val = val;
	}
	
	public void setId(int id){
		this.id=id;
	}
}
