
import TDS.*;
import AST.*;
public class TestAst {

	// ATTENTION : 
	// les remarques importantes, une variable globale c'est a dire une var declaré en dehors d'une fonction a une scope -1
	//dans les fonctions, type est le type de retour. Dans les variables type est le type de variable.
	//
	public static void main(String[]Args){
		/**
		int i, j;
		main(){
			i=0;
			j = (2+i) - (3+i);
		}
		**/
		//Simulation de cpt
		int cpt=0;
		
		/**
		 * Création et insertion des tds elements
		 */
		
		/**
		TDS tds=new TDS();
		//cpt=0
		TdsElement a=new Variable(cpt,"i",-1,0,"int");
		tds.ajoute(a);
		cpt++;
		//TdsElement a_bis=new Variable(cpt,"i",-1,0,"int");
		//tds.ajoute(a_bis);
		//cpt++;
		
		//cpt=1
		TdsElement b=new Variable(cpt,"j",-1,0,"int");
		tds.ajoute(b);
		cpt++;
		//cpt=2
		TdsElement c=new Fonction(cpt,"main",0,0,"void");
		tds.ajoute(c);
		cpt++;
		//cpt=3
		
		
		
		//creation racine
		NoeudElement racine= new NRacine();
		//creation de noeud fonction main
		NoeudElement fonction_main=new NFonction(2);
		//affectation un i=0
		//creation de noeud affectation
		NoeudElement affect=new NOperation("=");
		//fils gauche de affectation var i
		NoeudElement var=new NVariable(0,-1);
		//fils droite de affectation val 0
		NoeudElement val=new NConstant(0);
		//ajouter les fils a affectation

		
		//affectation deux j = (2+i) - (3+i)
		//creation de noeud daffectation 2
		NoeudElement affect2=new NOperation("="); 
		//recuperation de la variable j
		NoeudElement varj=new NVariable(1,-1);
		
		//creation du fils droite de l'affectation donc le moins 
		NoeudElement moins = new NOperation("-");
		//fils du moins plus1 et plus2
		NoeudElement plus1 = new NOperation("+");
		NoeudElement plus2 = new NOperation("+");
		//ajouter le fils plus1 du  moins
	
		
		//preparation de noeud de plus1
		NoeudElement const2=new NConstant(2);
		//recuperation de i
		NoeudElement vari=new NVariable(0,3);
		//ajouter noeud const 2 a plus1, fils gauche
	
		//la meme chose pour noeud plus2
		NoeudElement const3=new NConstant(3);
		NoeudElement vari2=new NVariable(0,3);
	

		
		racine.ajouter1fils(fonction_main);
		
		fonction_main.ajouterFG(affect);
		fonction_main.ajouterFD(affect2);
		
		affect.ajouterFG(var);
		affect.ajouterFD(val);
		
		affect2.ajouterFG(varj);
		affect2.ajouterFD(moins);
		
		moins.ajouterFG(plus1);
		moins.ajouterFD(plus2);
		
		plus1.ajouterFG(const2);
		plus1.ajouterFD(vari);
		
		plus2.ajouterFG(const3);
		plus2.ajouterFD(vari2);

		
		String v="";
		System.out.println(NoeudElement.afficheLesFils(racine,tds,v));
**/
		//voila affichage alors, j'aai du mal pour faire la fonction recursive qui parcours du coup j'ai fait a la main ^^ pour toute question sur l'arbe ou tds n'hesitez pas
/**
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		System.out.println(racine.afficherNoeud(tds));
		System.out.println(racine.listeNoeud.get(0).afficherNoeud(tds));
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(0).afficherNoeud(tds));
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(0).listeNoeud.get(0).afficherNoeud(tds));
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(0).listeNoeud.get(1).afficherNoeud(tds));

	
		
		
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(1).afficherNoeud(tds));
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(1).listeNoeud.get(0).afficherNoeud(tds));
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(1).listeNoeud.get(1).afficherNoeud(tds));
		
		
		
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(1).listeNoeud.get(1).listeNoeud.get(0).afficherNoeud(tds));
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(1).listeNoeud.get(1).listeNoeud.get(0).listeNoeud.get(0).afficherNoeud(tds));
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(1).listeNoeud.get(1).listeNoeud.get(0).listeNoeud.get(1).afficherNoeud(tds));
		
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(1).listeNoeud.get(1).listeNoeud.get(1).afficherNoeud(tds));
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(1).listeNoeud.get(1).listeNoeud.get(1).listeNoeud.get(0).afficherNoeud(tds));
		System.out.println(racine.listeNoeud.get(0).listeNoeud.get(1).listeNoeud.get(1).listeNoeud.get(1).listeNoeud.get(1).afficherNoeud(tds));

		
		System.out.println("--------------------------------------------------------------------------------------------------");
		
**/

		
		/**

 * Test g�n�ration de code : 
 * boucle
int i , j;
void main(){
	i = 0; j = 0;
	while (i <3){
		j = j + i;
	}
 }		
		**/
		
		//IN THE END, la fonction affichage de l'arbre recusive est reussi !!! :p a 02h50 xD seul probleme, je n'arrive pas afficher la racine mais 
		//on s'en fou on sait qu'il est la. La boucle while se fait de la facon suivante: while est un fils d'une fonction tout le temps et ce fils nommé while contien 
		//un seul et unique enfant gaté la condition, ensuite le corps qui est donc plussieur operation . . . Pour toute question n'hesitez pas 
		
		//Simulation de cpt
		int cpt1=0;
		TDS tds1 = new TDS();
		NoeudElement racine1 = new NRacine();
		
		
		TdsElement vari1=new Variable(cpt1,"i",-1,0,"int");
		tds1.ajoute(vari1);
		cpt1++;
		TdsElement varj1=new Variable(cpt1,"j",-1,0,"int");
		tds1.ajoute(varj1);
		cpt1++;
		TdsElement main1=new Fonction(cpt1,"main",0,0,"void");
		tds1.ajoute(main1);
		cpt1++;
		
		
		NoeudElement fonction_main1=new NFonction(2);
		NoeudElement affect11=new NAffectation("=");
		//fils gauche de affectation var i
		NoeudElement var1=new NVariable(0,-1);
		//fils droite de affectation val 0
		NoeudElement val1=new NConstant(0);
		//ajouter les fils a affectation
		
		NoeudElement affect22=new NAffectation("=");
		//fils gauche de affectation var j
		NoeudElement var2=new NVariable(1,-1);
		//fils droite de affectation val 0
		NoeudElement val2=new NConstant(0);
		//ajouter les fils a affectation
		
		NoeudElement nwhile=new NWhile();
		NoeudElement ncond=new NCondition("i <3");
		NoeudElement naffectdswhile=new NAffectation("=");
		//fils gauche de affectation var j
		NoeudElement varj2=new NVariable(1,-1);
		
		
		NoeudElement plus=new NOperation("+");
		NoeudElement varj22=new NVariable(1,-1);
		
		//fils gauche de affectation var j
		NoeudElement vari22=new NVariable(0,-1);
		
		
		affect11.ajouterFG(var1);
		affect11.ajouterFD(val1);
		
		affect22.ajouterFG(var2);
		affect22.ajouterFD(val2);
		
		nwhile.ajouter1fils(ncond);
		ncond.ajouter1fils(naffectdswhile);
		naffectdswhile.ajouterFG(varj2);
		naffectdswhile.ajouterFD(plus);
		plus.ajouterFG(varj22);
		plus.ajouterFD(vari22);
		
		racine1.ajouter1fils(fonction_main1);
		NoeudElement[] tableauDoperationDansLaFonction=new NoeudElement[3];
		tableauDoperationDansLaFonction[0]=affect11;
		tableauDoperationDansLaFonction[1]=affect22;
		tableauDoperationDansLaFonction[2]=nwhile;
		fonction_main1.ajouterNFils(tableauDoperationDansLaFonction);
		
		String v="";
		String s=NoeudElement.afficheLesFils(racine1,tds1,v);
		System.out.println(s);
		
	}
}
