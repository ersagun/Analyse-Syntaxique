package TDS;

public class Variable extends TdsElement {
	int val;

	public Variable(int idf,String cat,String nomp,String type,String scopep,int valp){
		super(idf, cat,nomp, type,scopep);
		this.val=valp;
	}

}
