package AST;

import TDS.*;

public class NVariable extends NoeudElement {
	int ref;
	int scope;
	
	//creation de noeud de identificateur comme variable i
	public NVariable(int refp) {
		super("identificateur");
		this.ref = refp;
		this.scope=-1;
	}
	

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud variable => #nom : "+this.ref+", #scope : "+this.scope+" [information recuperé de td grace a la ref : "+tds.searchVariable(this.ref)+"]";
	}


	public int getScope() {
		return scope;
	}


	public void setScope(int scope) {
		this.scope = scope;
	}


	public int getRef() {
		return ref;
	}


	public void setRef(int ref) {
		this.ref = ref;
	}

	public String get_Value(TDS tds){
		Variable var=(Variable)tds.search(this.ref);
		return var.getNom();
	}
}
