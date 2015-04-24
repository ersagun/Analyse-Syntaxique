package AST;

import TDS.Parametre;
import TDS.TDS;
import TDS.TdsElement;
import TDS.Variable;
import TDS.Vlocale;

public class NCondition extends NoeudElement {
	String condition;

	public NCondition() {
		super("condition");
	}

	public NCondition(String condition) {
		super("condition");
		this.condition = condition;

	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public NCondition(int i, String cond, String s, int scope, TDS tds) {
		super("operation");
		this.condition = cond;
		boolean found = false;
		NoeudElement var = null;
		TdsElement te = tds.searchVariable(s, scope);
		// il faut aller chercher
		if (tds.searchVariable(s, scope) instanceof Variable) {
			var = new NVariable(((Variable) te).getId(),
					((Variable) te).getScope());
			found = true;
		}
		if (tds.searchVariable(s, scope) instanceof Vlocale && found == false) {
			var = new NVariable(((Variable) te).getId(),
					((Vlocale) te).getScope());
			found = true;
		}

		if (tds.searchVariable(s, scope) instanceof Parametre && found == false) {
			var = new NVariable(((Variable) te).getId(),
					((Parametre) te).getScope());
			found = true;
		}

		NoeudElement constant = new NConstant(i);
		this.ajouterFG(constant);
		this.ajouterFD(var);

	}

	public NCondition(String i, int scope, String cond, int s, TDS tds) {
		super("condition");
		this.condition = cond;
		boolean found = false;
		NoeudElement var = null;
		TdsElement te = tds.searchVariable(i, scope);
		// il faut aller chercher
		if (tds.searchVariable(i, scope) instanceof Variable) {
			var = new NVariable(((Variable) te).getId(),
					((Variable) te).getScope());
			found = true;
		}
		if (tds.searchVariable(i, scope) instanceof Vlocale && found == false) {
			var = new NVariable(((Variable) te).getId(),
					((Vlocale) te).getScope());
			found = true;
		}

		if (tds.searchVariable(i, scope) instanceof Parametre && found == false) {
			var = new NVariable(((Variable) te).getId(),
					((Parametre) te).getScope());
			found = true;
		}

		NoeudElement constant = new NConstant(s);
		this.ajouterFG(var);
		this.ajouterFD(constant);

	}

	public NCondition(NoeudElement a, String condition, NoeudElement b) {
		super("condition");
		this.condition = condition;
		this.ajouterFG(a);
		this.ajouterFD(b);
		;
	}

	@Override
	public String afficherNoeud(TDS tds) {
		// TODO Auto-generated method stub
		String rep = "";
		if (this.condition != null) {
			rep = "Noeud condition => #condition : " + this.condition;
		} else {
			rep = "Noeud condition => #racine ";
		}
		return rep;
	}
}
