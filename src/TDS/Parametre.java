package TDS;

public class Parametre extends TdsElement {

int rang;
int scope;
String type;

public Parametre(int idf,String cat,String nomp,String type,int scopep,int rangp,String typep){
	super(idf, "param",nomp );
	this.rang=rangp;
	this.scope=scopep;
	this.type=typep;
}

public String toString(){
	return "idf : "+this.idf+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , scope : "+this.scope+" , rang : "+this.rang;
}
}
