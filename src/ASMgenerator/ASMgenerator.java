package ASMgenerator;

import TDS.*;
import AST.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ASMgenerator {

	public TDS tds;
	public Noeud node;
	
	
	/*
	 * CONSTRUCTORS
	 */
	public ASMgenerator(TDS tds, Noeud node) {
		super();
		this.tds = tds;
		this.node = node;
	}
	
	/*
	 * METHODES
	 */
	
	/**
	 * Retourne la génération ASM sous une chaine
	 * 
	 * @return
	 */
	
	public String generateToString(){
		StringBuffer buf = new StringBuffer();
		this.generated_Code(node, buf);
		return buf.toString();
	}
	
	public void generateToFile(String filename){
		try{
			String content = this.generateToString();
			File file = new File(filename);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				System.out.println(" Creation du fichier "+filename);
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println(filename + " ASM generated !\n");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Impossible de créer le fichier demandé\n");
			System.exit(0);
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Génère la base du programme ASM
	 * 	- Fait un appel à main directement
	 * 
	 * @param node
	 * @param buff
	 */
	public void generated_Code(Noeud node, StringBuffer buff){
		buff.append("|============ Header ================|\n");
		buff.append(".include beta.uasm\n");
		buff.append("\tCMOVE(stack, SP)\n");
		buff.append("BR(start)\n");
		
		this.generated_Data(node,buff);
		
		buff.append("|============ Début programme ================|\n");
		
		buff.append("start:\n");
		buff.append("\tCALL(main)\n");
		buff.append("\tHALT()\n");
		
		this.generated_Function(node,buff);
		
		buff.append("stack:\n");
	}
	
	public void generated_Data(Noeud node, StringBuffer buff){
	}
	
	public void generated_Function(Noeud node, StringBuffer buff){
	}
	
	
	
}
