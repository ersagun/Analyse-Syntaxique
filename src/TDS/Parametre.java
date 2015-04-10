package TDS;

public class Parametre extends TdsElement {

int rang;

public Parametre(int idf,String cat,String nomp,String type,String scopep,int rangp){
	super(idf, cat,nomp, type,scopep);
	this.rang=rangp;
}

}
