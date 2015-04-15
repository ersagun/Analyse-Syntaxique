import ASMgenerator.*;
import AST.*;
import TDS.*;

public class TestASMGenerato2 {

	public static void main(String[] args) {
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
NoeudElement conditionWhile=new NCondition("i",-1,"<",3,tds);
//ici on peut ajouter autant de condition qu'on veut
wayle.getFG().ajouter1fils(conditionWhile);

// noeud wayle complet il reste FD qui est donc le corps de while

NoeudElement affectj=new NAffectation("j",-1,"=",tds);
NoeudElement plus=new NOperation("j",-1,"+","i",-1,tds);


// adjonction de fonction main a la racine
racine.ajouter1fils(fonction_main);

affect1.ajouterFD(val1);
// affect1 complet
affect2.ajouterFD(val2);
// affect2 complet





affectj.ajouterFD(plus);
//ici on peut ajouter autant d'operation qu'on veut
wayle.getFD().ajouter1fils(affectj);


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
ASMgenerator asm= new ASMgenerator(tds,racine);
asm.generateToFile("Code_ASM1.uasm");

	}

}
