package TDS;

public class Variable extends TdsElement {
	int val;

	public Variable(String idf,String cat,String type,String scopep,int valp){
		super(idf, cat, type,scopep);
		this.val=valp;
	}

}
