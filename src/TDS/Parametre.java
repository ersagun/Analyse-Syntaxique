package TDS;

public class Parametre extends TdsElement {

int rang;
int scope;
String type;
int valeur;

public Parametre(int idf,String nomp,int scopep,int rangp,String typep,int valp){
	super(idf, "param",nomp );
	this.rang=rangp;
	this.scope=scopep;
	this.type=typep;
	this.valeur=valp;
}

public String toString(){
	return "idf : "+this.id+" , cat : "+this.cat+" , nom : "+this.nom+", type : "+this.type+" , scope : "+this.scope+" , rang : "+this.rang;
}

public int getScope() {
	// TODO Auto-generated method stub
	return this.scope;
}
}
