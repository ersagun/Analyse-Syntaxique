import TDS.*;
import AST.*;
import ASMgenerator.*;

public class TestASMgenerator {

	public static void main(String[]Args){
		
		/*
		 * test 1 just pour verifier generer_code sur un AST et Noeud vide
		 */

		//TDS
		TDS tds= new TDS();
		//AST
		Noeud ast=new Noeud("function",1);
		//ASMGenerator
		ASMgenerator asm= new ASMgenerator(tds,ast);
		asm.generateToFile("Code_ASM");
	}
}
