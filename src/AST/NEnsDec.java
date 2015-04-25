package AST;

import TDS.TDS;

public class NEnsDec extends NoeudElement {

	public NEnsDec() {
		super("ensembledec");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		return "Noeud EnsembleDeclaration => #type : =ensdec";
	}

}
