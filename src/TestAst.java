import java.util.ArrayList;

import TDS.*;
import AST.*;
public class TestAst {

	
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
		TdsElement a=new Variable(cpt,"var","i","variable","globale",0);
		tds.ajoute(a);
		cpt++;
		//cpt=1
		TdsElement b=new Variable(cpt,"var","j","variable","globale",0);
		tds.ajoute(b);
		cpt++;
		//cpt=2
		TdsElement c=new Fonction(cpt,"fonct","main","fonction","globale",0,0);
		tds.ajoute(c);
		cpt++;
		//cpt=3
		
		
		
		//creation racine
		Noeud racine= new Noeud();
		//creation de noeud fonction main
		Noeud fonction_main=new Noeud("fonction",3);
		//affectation un i=0
		//creation de noeud affectation
		Noeud affect=new Noeud("=");
		//fils gauche de affectation var i
		Noeud var=new Noeud(0);
		//fils droite de affectation val 0
		Noeud val=new Noeud(0);
		//ajouter les fils a affectation
		affect.ajouterFG(var);
		affect.ajouterFG(val);
		
		
		//affectation deux j = (2+i) - (3+i)
		//creation de noeud daffectation 2
		Noeud affect2=new Noeud("="); 
		//recuperation de la variable j
		Noeud varj=new Noeud(1);
		
		//creation du fils droite de l'affectation donc le moins 
		Noeud moins = new Noeud("-");
		//fils du moins plus1 et plus2
		Noeud plus1 = new Noeud("+");
		Noeud plus2 = new Noeud("+");
		//ajouter le fils plus1 du  moins
		moins.ajouterFG(plus1);
		
		
		//preparation de noeud de plus1
		Noeud const2=new Noeud(2);
		//recuperation de i
		Noeud vari=new Noeud(0);
		//ajouter noeud const 2 a plus1, fils gauche
		plus1.ajouterFG(const2);
		//ajouter variable i a plus1, fils droite
		plus1.ajouterFD(vari);
		moins.ajouterFD(plus2);
		
		//la meme chose pour noeud plus2
		Noeud const3=new Noeud(3);
		Noeud vari2=new Noeud(0);
		plus2.ajouterFG(const3);
		plus2.ajouterFD(vari2);
		
		affect2.ajouterFG(varj);
		affect2.ajouterFD(moins);
	
	}
}
