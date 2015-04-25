package AST;

import TDS.TDS;

public class NIf extends NoeudElement {
	
	
	//ce constructeur permet de créer un noeud de type si donc, comme les noeud while, le noeoud si a un seul fils et c'est la condition
	public NIf() {
		super("if");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeu de #type : if";
	}

}
