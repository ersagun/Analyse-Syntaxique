package TDS;

public class Parametre extends TdsElement {

int rang;

public Parametre(String idf,String cat,String type,String scopep,int rangp){
	super(idf, cat, type,scopep);
	this.rang=rangp;
}

}
