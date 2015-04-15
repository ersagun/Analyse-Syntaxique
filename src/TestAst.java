
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

		//voila affichage alors, j'aai du mal pour faire la fonction recursive qui parcours du coup j'ai fait a la main ^^ pour toute question sur l'arbe ou tds n'hesitez pas

		System.out.println("--------------------------------------------------------------------------------------------------");
		String vs="";
		String sv=NoeudElement.afficheLesFils(racine,tds,vs);
		System.out.println(sv);
		System.out.println("--------------------------------------------------------------------------------------------------");
		


		
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
		//tranchage de la condition :
		NoeudElement operationinf=new NOperation("<");
		NoeudElement varipourwhile=new NVariable(0,-1);
		NoeudElement consst3=new NConstant(3);
		
		ncond.ajouter1fils(operationinf);
		operationinf.ajouterFG(varipourwhile);
		operationinf.ajouterFD(consst3);
		
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
		
		String vss="";
		String s=NoeudElement.afficheLesFils(racine1,tds1,vss);
		System.out.println(s);
		
		//nouveau noeud
		
		
		
		
		/**

		int i = 3; int j;
		void main(){
			if (i < 2){
				j = 0;
			}else{
				j = 1;
			}
		 } **/
		
		TDS tdscond=new TDS();
		int cptcond=0;
		
		TdsElement varri=new Variable(cptcond,"i",-1,3,"int");
		tdscond.ajoute(varri);
		cptcond++;
		TdsElement varrj=new Variable(cptcond,"j",-1,0,"int");
		tdscond.ajoute(varrj);
		cptcond++;
		TdsElement fonct_m=new Fonction(cptcond,"main",0,0,"void");
		tdscond.ajoute(fonct_m);
		cptcond++;
		
		NoeudElement rac=new NRacine();
		NoeudElement fon_man=new NFonction(2);
		NoeudElement noeudif=new NIf();
		NoeudElement noeudelse=new NElse();
		

		NoeudElement condition=new NCondition("i < 2");
		
		
		
		NoeudElement opdeCond=new NOperation("<");
		NoeudElement varii=new NVariable(0,-1);
		NoeudElement consst2=new NConstant(2);
		
		condition.ajouter1fils(opdeCond);
		
		//optimiser ici
		opdeCond.ajouterFG(varii);
		opdeCond.ajouterFD(consst2);
	
		
		//optimiser affectation,appelfonction
		
		
		
		
		NoeudElement affectif=new NAffectation("=");
		NoeudElement varrri=new NVariable(1,-1);
		NoeudElement zeroconst=new NConstant(0);
		NoeudElement affectelse=new NAffectation("=");
		NoeudElement varjj2=new NVariable(1,-1);
		NoeudElement unconst=new NConstant(1);
		
		rac.ajouter1fils(fon_man);
		fon_man.ajouter1fils(noeudif);
		noeudif.ajouterFG(noeudelse);
		noeudelse.ajouter1fils(affectelse);
		affectelse.ajouterFG(varjj2);
		affectelse.ajouterFD(unconst);
		
		noeudif.ajouterFD(condition);
		condition.ajouter1fils(affectif);
		affectif.ajouterFG(varj2);
		affectif.ajouterFD(zeroconst);
		
		// ICI J'AI REPRESENTE LE NOEUD IF DE CETTE FACON : NOEUD IF SON FILS GAUCHE ET NOEUD ELSE, SON FILS DROITE ET LA CONDITION, LE NOEUD CONDITION A PLUSSIEUR 
		// NOEUD COMME LE NOEUD ELSE. SI CELA VOUS VA ON LE GARDE SINON JE PROPOSE LE DEUXIEME STRUCTURE QUI EST DONCT DE METTRE LA CONDITION EN HAUT ET FILS GAUCHE IF 
		//FILS DROITE ELSE. VOILA. FAUT DECIDER JUSTE.
		System.out.println("-----------------------------------------------------------------");
		String sss="";
		System.out.println(NoeudElement.afficheLesFils(rac, tdscond, sss));
	
		
	
		System.out.println("-----------------------------------------------------------------");
		
		/**
		int i =0;
		int j = 0;

		int f(int a, int b){
			int x, y, z;
			return 0;
		 }

		void main(){
			i = f(i,j); 
		}
	**/
	
	TDS tdscondd=new TDS();
	int cptcondd=0;
	
	TdsElement varfi=new Variable(cptcondd,"i",-1,0,"int");
	tdscond.ajoute(varfi);
	cptcondd++;
	
	TdsElement varfj=new Variable(cptcondd,"j",-1,0,"int");
	tdscond.ajoute(varrj);
	cptcondd++;
	
	TdsElement fonctt_f=new Fonction(cptcondd,"f",2,3,"int");
	tdscond.ajoute(fonctt_f);
	cptcondd++;

	TdsElement paramf1=new Parametre(cptcondd,"x",2,0,"int",0);
	tdscond.ajoute(paramf1);
	cptcondd++;

	TdsElement paramf2=new Parametre(cptcondd,"y",2,1,"int",0);
	tdscond.ajoute(paramf2);
	cptcondd++;

	TdsElement paramf3=new Parametre(cptcondd,"z",2,2,"int",0);
	tdscond.ajoute(paramf3);
	cptcondd++;

	TdsElement fonctt_m=new Fonction(cptcondd,"main",0,0,"void");
	tdscond.ajoute(fonctt_m);
	cptcondd++;
	
	
	NoeudElement raccine=new NRacine();
	NoeudElement foncc_f=new NFonction(2);
	NoeudElement foncc_man=new NFonction(6);
	NoeudElement returnn=new NReturn();
	NoeudElement 
	
	
	// JE NE SAIS PAS VRAIMENT SI JE REND UN ARBRE LEXPRESSION, OU VOUS LE TRANCHEZ VOUS , 
	

	// SI CA A VOUS DE FAIRE IL FAUT FAIR LE SUIVANTE:
	NoeudElement condition=new NCondition("i < 2");
	
	
	//SI CA A MOI DE LE FAIRE : 
	NoeudElement opdeCond=new NOperation("<");
	NoeudElement varii=new NVariable(0,-1);
	NoeudElement consst2=new NConstant(2);
	
	condition.ajouter1fils(opdeCond);
	opdeCond.ajouterFG(varii);
	opdeCond.ajouterFD(consst2);

	NoeudElement affectif=new NAffectation("=");
	NoeudElement varrri=new NVariable(1,-1);
	NoeudElement zeroconst=new NConstant(0);
	NoeudElement affectelse=new NAffectation("=");
	NoeudElement varjj2=new NVariable(1,-1);
	NoeudElement unconst=new NConstant(1);
	
	rac.ajouter1fils(fon_man);
	fon_man.ajouter1fils(noeudif);
	noeudif.ajouterFG(noeudelse);
	noeudelse.ajouter1fils(affectelse);
	affectelse.ajouterFG(varjj2);
	affectelse.ajouterFD(unconst);
	
	noeudif.ajouterFD(condition);
	condition.ajouter1fils(affectif);
	affectif.ajouterFG(varj2);
	affectif.ajouterFD(zeroconst);	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		int i =0;
int j = 0;

int f(int a, int b){
	int x, y, z;
	return 0;
 }

void main(){
	i = f(i,j); 
}  */
		
		
		
		
		
		
		
	}
}
