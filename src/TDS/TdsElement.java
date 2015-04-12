package TDS;

/**
 * Cette classe represente les caracteristiques commun d'un element de tds
 * 
 * @author Ersagun
 *
 */
public abstract class TdsElement {
	int idf;
	String cat;
	String nom;

	public TdsElement(int idfp, String catp, String nomp) {
		this.idf = idfp;
		this.cat = catp;
		this.nom = nomp;
	}

	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if (this.getClass().getName() == "Variable") {
			if (((Variable) this).nom == ((Variable) o).nom
					&& ((Variable) this).scope == ((Variable) o).scope) {
				result = true;
			}
		}
		if (this.getClass().getName() == "Fonction") {
			if (((Fonction) this).nom == ((Fonction) o).nom) {
				result = true;
			}
		}
		return result;
	}

	public abstract String toString();

}
