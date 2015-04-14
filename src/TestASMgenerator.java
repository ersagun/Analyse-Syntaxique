import TDS.*;
import AST.*;
import ASMgenerator.*;

public class TestASMgenerator {

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
			NoeudElement affect=new NAffectation("=");
			//fils gauche de affectation var i ATTENTION ! ICI LA VARIABLE EST GLOBALE DONC LE SCOPE EST MOINS UN JE ME SUIS TROMPE (Ersagun)
			NoeudElement var=new NVariable(0,-1);
			//fils droite de affectation val 0
			NoeudElement val=new NConstant(0);
			//ajouter les fils a affectation

			
			//affectation deux j = (2+i) - (3+i)
			//creation de noeud daffectation 2
			NoeudElement affect2=new NAffectation("="); 
			//recuperation de la variable j     PAREIL (ERSAGUN)
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

		ASMgenerator asm= new ASMgenerator(tds,racine);
		asm.generateToFile("Code_ASM.uasm");
	}
}
