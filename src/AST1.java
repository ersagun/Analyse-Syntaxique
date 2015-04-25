import TDS.*;
import AST.*;

public class AST1 {

	// ATTENTION :
	// les remarques importantes, une variable globale c'est a dire une var
	// declaré en dehors d'une fonction a une scope -1
	// dans les fonctions, type est le type de retour. Dans les variables type
	// est le type de variable.
	//
	public static void main(String[] Args) {
		System.out
				.println("----------------------------------Test operations------------------------------------\n");

		/**
		 * int i, j; 
		 * main(){ i=0; j = (2+i) - (3+i); }
		 **/

		System.out
				.println("------------------------------TDS :---------------------------------------------------------------");
		int cpt = 0;
		TDS tds = new TDS();
		TdsElement a = new Variable(cpt, "i", -1, 0, "int");
		tds.ajoute(a);
		cpt++;
		TdsElement b = new Variable(cpt, "j", -1, 0, "int");
		tds.ajoute(b);
		cpt++;
		TdsElement c = new Fonction(cpt, "main", 0, 0, "void");
		tds.ajoute(c);
		cpt++;
		tds.afficheTDS();
		System.out
				.println("--------------------------------------------------------------------------------------------------\n\n");

		System.out
				.println("------------------------------Noeuds :------------------------------------------------------------");
		// creation racine
		NoeudElement racine = new NRacine();
		// creation de noeud fonction main
		NoeudElement fonction_main = new NFonction(2);
		// adjonction de fonction main a la racine
		racine.ajouter1fils(fonction_main);

		// creation de noeud affectation
		NoeudElement affect = new NAffectation("i" + "", -1, "=",0, tds,);

		// creation de noeud affectation2
		NoeudElement affect2 = new NAffectation("j", -1, "=", tds);
		NoeudElement plus1 = new NOperation(2, "+", "i", -1, tds);
		NoeudElement plus2 = new NOperation(3, "+", "i", -1, tds);
		NoeudElement moins = new NOperation(plus1, "-", plus2);
		affect2.ajouterFD(moins);

		// adjonction des deux affectations a la fonction main les operations
		fonction_main.ajouterFG(affect);
		fonction_main.ajouterFD(affect2);

		String vs = "";
		String sv = NoeudElement.afficheLesFils(racine, tds, vs);
		System.out.println(sv);
		System.out
				.println("--------------------------------------------------------------------------------------------------");
	}
}
