import TDS.*;
import AST.*;

public class AST2 {
	// ATTENTION :
	// les remarques importantes, une variable globale c'est a dire une var
	// declaré en dehors d'une fonction a une scope -1
	// dans les fonctions, type est le type de retour. Dans les variables type
	// est le type de variable.
	//
	public static void main(String[] Args) {
		System.out
				.println("----------------------------------Test while------------------------------------\n");

		/**
		int i , j;
		void main(){
			i = 0; j = 0;
			while (i <3){
				j = j + i;
			}
		 }		**/

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
		// creation de noeud affectation1
		NoeudElement affect1 = new NAffectation("i", -1, "=", tds);
		// fils droite de affectation val 0
		NoeudElement val1 = new NConstant(0);
		
		// creation de noeud affectation2
		NoeudElement affect2 = new NAffectation("j", -1, "=", tds);
		// fils droite de affectation val 0
		NoeudElement val2 = new NConstant(0);

		//Creation de noeud while
		NoeudElement wayle=new NWhile();
		NoeudElement condition=new NCondition();
		NoeudElement conditionWhile=new NCondition("i",-1,"<",3,tds);
		
		// noeud wayle complet il reste FD qui est donc le corps de while
		
		NoeudElement affectj=new NAffectation("j",-1,"=",tds);
		NoeudElement plus=new NOperation("j",-1,"+","i",-1,tds);
		
		
		// adjonction de fonction main a la racine
		racine.ajouter1fils(fonction_main);

		affect1.ajouterFD(val1);
		// affect1 complet
		affect2.ajouterFD(val2);
		// affect2 complet
		
		
		wayle.ajouterFG(condition);
		condition.ajouter1fils(conditionWhile);


		affectj.ajouterFD(plus);
		wayle.ajouterFD(affectj);
	

		// adjonction des deux affectations et le noeud while a la fonction main

		NoeudElement[] tab=new NoeudElement[3];
		tab[0]=affect1;
		tab[1]=affect2;
		tab[2]=wayle;
		fonction_main.ajouterNFils(tab);

		String vs = "";
		String sv = NoeudElement.afficheLesFils(racine, tds, vs);
		System.out.println(sv);
		System.out.println("--------------------------------------------------------------------------------------------------");
	}
}
