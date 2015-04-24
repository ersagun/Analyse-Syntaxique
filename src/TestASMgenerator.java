import TDS.*;
import AST.*;
import ASMgenerator.*;

public class TestASMgenerator {

	public static void main(String[]Args){
		

		System.out
		.println("----------------------------------Test while------------------------------------\n");

/**

int i = 3; int j;
void main(){
	if (i < 2){
		j = 0;
	}else{
		j = 1;
	}
 } **/

System.out
		.println("------------------------------TDS :---------------------------------------------------------------");
int cpt = 0;
TDS tds = new TDS();
TdsElement a = new Variable(cpt, "i", -1, 3, "int");
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
NoeudElement val2 = new NConstant(1);

//Creation de noeud while
//NoeudElement nif=new If();
//EN PAUSE §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§





String vs = "";
String sv = NoeudElement.afficheLesFils(racine, tds, vs);
System.out.println(sv);
System.out.println("--------------------------------------------------------------------------------------------------");
		ASMgenerator asm= new ASMgenerator(tds,racine);
		asm.generateToFile("Code_ASM.uasm");
	}
}
