package AST;
import TDS.TDS;
import AST.NoeudElement;


public class NAffectation extends NoeudElement {
	String val;
	public NAffectation(String c) {
		super("affectation");
		this.val=c;
		
	}
	@Override
	public String afficherNoeud(TDS tds) {
		return 	"Noeud operation => #type : =";
	}

}
