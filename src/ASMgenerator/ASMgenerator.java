package ASMgenerator;

import TDS.*;
import AST.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ASMgenerator {

	public TDS tds;
	public NoeudElement node;
	
	
	/*
	 * CONSTRUCTORS
	 */
	public ASMgenerator(TDS tds, NoeudElement node) {
		super();
		this.tds = tds;
		this.node = node;
	}
	
	/*
	 * METHODES
	 */
	
	/**
	 * Retourne la génération ASM sous une chaine et dans un fichier
	 * generer indent permet de gerer  les indentations
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
	
	
	private void _generateIndent(int indent, StringBuffer buff){
		for (int i = 0; i < indent; i++) {
			buff.append("\t");
		}
	}
	
	/**
	 * Génère la base du programme ASM
	 * 	- Fait un appel à main directement
	 * Generer code sert a afficher en ASM la base du fichier.uasm selon l'algorihtme vu en cours.
		Un test a été effectué sur des AST et TSD vides,
		La sortie ASM est dans un fichier: 
	 * @param node
	 * @param buff
	 */
	public void generated_Code(NoeudElement node, StringBuffer buff){
		buff.append("|============ Header ================|\n");
		buff.append(".include beta.uasm\n");
		buff.append("\tCMOVE(stack, SP)\n");
		buff.append("BR(start)\n");
		
		this.generated_Data(node,buff);
		this.generated_Program(node, buff, 0);
		
		buff.append("|============ Début programme ================|\n");
		
		buff.append("start:\n");
		buff.append("\tCALL(main)\n");
		buff.append("\tHALT()\n");
		buff.append("stack:\n");
	}
	
	public void generated_Data(NoeudElement node, StringBuffer buff){
		for(TdsElement element : this.tds.getTable()){
			if ((element.getCat()==("variable")) && (((Variable)element).getScope()==-1) && (((Variable)element).getType()=="int") ){
				buff.append("\t"+element.getNom()+":LONG("+((Variable)element).getVal()+")");
			}
		}
	}
	
	/**
	 * Début de la génération ASM
	 * 	- Demande la génération de chaques fonctions
	 * 
	 * @param node
	 * @param buff
	 */
	public void generated_Program(NoeudElement node, StringBuffer buff,int indent){
		buff.append("|Generation du programme: appel de "+node.getChildren().size()+" fontion(s)|\n");
		for (NoeudElement child : node.getChildren()) {
			this.generated_Function((NFonction) child, buff, indent);
		}
	}
	
	
	
	/**
	 * Génére la structure de base d'une fonction
	 * 	- Les variables locales sont déclarées en allouant la place nécessaire en pile
	 * 
	 * @param node On récupère un noeud FONCTION
	 * @param buff
	 */
	public void generated_Function(NFonction node, StringBuffer buff, int indent){
		
		int nbVarLocal = node.getnlocalvar(this.tds);
		String id = node.getname(this.tds);
				
		//buf.append("|============ Header ================|\n");
		buff.append( id + ":\n");
		buff.append("\tPUSH(LP)\n");
		buff.append("\tPUSH(BP)\n");
		buff.append("\tMOVE(SP, BP)\n");
		buff.append("\tALLOCATE(" + nbVarLocal + ")\n");
		
		this.generated_Bloc(node.getFG(), buff, indent+1);
		
		buff.append("\tDEALLOCATE(" + nbVarLocal + ")\n");
		buff.append("\tPOP(BP)\n");
		buff.append("\tPOP(LP)\n");
		buff.append("\tJMP(LP)\n");
	}
	
	public void generated_Bloc(NoeudElement node, StringBuffer buff, int indent){
		
	}
	
}
