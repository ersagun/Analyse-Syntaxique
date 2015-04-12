import TDS.*;
import AST.*;
import ASMgenerator.*;

public class TestASMgenerator {

	public static void main(String[]Args){
		
		/*
		 * test 1 just pour verifier generer_code sur un AST et Noeud vide
		 * TDS tds= new TDS();
		 * Noeud ast=new Noeud();
		 * ASMgenerator asm= new ASMgenerator(tds,ast);
		 *asm.generateToFile("Code_ASM");
		 *test 2 pour generer programm
		 */

		//TDS
		TDS tds= new TDS();
		//AST
		NoeudElement ast=new NRacine();
		
		//ASMGenerator
		ASMgenerator asm= new ASMgenerator(tds,ast);
		asm.generateToFile("Code_ASM");
	}
}
