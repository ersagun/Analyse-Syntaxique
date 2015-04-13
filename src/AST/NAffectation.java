package AST;
import TDS.TDS;
import AST.NoeudElement;


public class NAffectation extends NoeudElement {

	public NAffectation(String t) {
		super("affectation");
		
	}
	@Override
	public String afficherNoeud(TDS tds) {
		return 	"Noeud operation => #type : =";
	}

}
