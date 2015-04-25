package ASMgenerator;

import TDS.*;
import AST.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import version_bis.Node;
import version_bis.NodeContentCondition;


/**
 * 
 * @author Groupe 22 : Complilation L3 MIAGE 2014-2015
 *
 */
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
	 * Retourne la génération ASM sous une chaine 
	 * @return code ASM
	 */
	public String generateToString(){
		StringBuffer buf = new StringBuffer();
		this.generated_Code(node, buf);
		return buf.toString();
	}
	
	/**
	 * avec le nom de fichier en paramètre, permet d'ecrire dans un fichier
	 * le code asm
	 * @param filename
	 */
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
	 * generer indent permet de gerer  les indentations de fichier 	asm
	 * @param indent
	 * @param buff
	 */
	private void generated_Indent(int indent, StringBuffer buff){
		for (int i = 0; i < indent; i++) {
			buff.append("\t");
		}
	}
	
	/**
	 * Génère la base du programme ASM
	 * 	- Fait un appel à main directement
	 * Generer code sert a afficher en ASM la base du fichier.uasm selon l'algorihtme vu en cours. 
	 * @param node
	 * @param buff
	 */
	public void generated_Code(NoeudElement node, StringBuffer buff){
		System.out.println("Génration du programme\n");
		buff.append("|============ Header ================|\n");
		buff.append(".include beta.uasm\n");
		buff.append("\tCMOVE(pile, SP)\n");
		buff.append("BR(start)\n");
		
		this.generated_Data(node,buff);
		this.generated_Program(node, buff, 0);
		
		buff.append("|============ Début programme ================|\n");
		
		buff.append("start:\n");
		buff.append("\tCALL(main)\n");
		buff.append("\tHALT()\n");
		buff.append("pile:\n");
	}
	
	/**
	 * Permet de generer et initialiser les var globales
	 * @param node
	 * @param buff
	 */
	public void generated_Data(NoeudElement node, StringBuffer buff){
		System.out.println("\tGéneration des données: variables globales\n");
		for(TdsElement element : this.tds.getTable()){
			if ((element.getCat()==("identificateur")) && (((Variable)element).getScope()==-1) && (((Variable)element).getType()=="int") ){
				buff.append("\t"+element.getNom()+":LONG("+((Variable)element).getVal()+")\n");
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
		System.out.println("\tGéneration des fonctions\n");
		int nbVarLocal = node.getnlocalvar(this.tds);
		String id = node.getname(this.tds);
				
		//buf.append("|============ Header ================|\n");
		buff.append( id + ":\n");
		buff.append("\tPUSH(LP)\n");
		buff.append("\tPUSH(BP)\n");
		buff.append("\tMOVE(SP, BP)\n");
		buff.append("\tALLOCATE(" + nbVarLocal + ")\n");
		
		this.generated_Bloc(node, buff, indent+1);
		
		buff.append("\tDEALLOCATE(" + nbVarLocal + ")\n");
		buff.append("\tPOP(BP)\n");
		buff.append("\tPOP(LP)\n");
		buff.append("\tJMP(LP)\n");
	}
	
	/**
	 * Genere le bloc d'instruction de chaque fils de fonction
	 * @param node
	 * @param buff
	 * @param indent
	 */
	public void generated_Bloc(NoeudElement node, StringBuffer buff, int indent){
			System.out.println("\t\tGéneration des blocs\n");
			for (NoeudElement child : node.getChildren()){
				
				this.generated_Instruction( child, buff, indent);
			}
	}

	
	/**
	 * Génère une instruction.
	 * L'instruction est une ligne par defaut dans une fonction
	 * @todo si
	 * @todo while
	 */
	public void generated_Instruction(NoeudElement node, StringBuffer buff, int indent){
		System.out.println("\t\tGéneration Instructions\n");
		
		if(node.getCategorie() instanceof String){
			switch((String)node.getCategorie()){
				case "affectation":
					this.generate_Affectation((NAffectation) node, buff, indent+1);
					break;

				case "retour":
					this.generated_Return( node, buff, indent+1);
					break;
					
				// Cas d'une alternative
				case "si":
					this.generated_If((NIf)node, buff, indent+1);
					break;
					
				// Cas du while
				case "while":
					this.generated_While((NWhile)node, buff, indent+1);
					break;
					
				default:
					break;
			}
		}
	}

	/**
	 * 
	 * @param node
	 * @param buff
	 * @param indent
	 */
	private void generate_Affectation(NAffectation node, StringBuffer buff,int indent) {
		System.out.println("\t\t\tGéneration Affectation\n");
		this.generated_Indent(indent, buff);
		buff.append("|== Debut (=) ==|\n");
		
		/**
		 * Partie droite
		 */
		
		this.generated_Expression(node.getFD(), buff, indent);
		/**
		 * Affectation du resultat à la partie gauche
		 */
		// Si le resultat de droite vient d'une fonction Il est stocké dans R0
		if(node.getFD() instanceof NAppelFonction){
			this.generated_Indent(indent, buff);
			buff.append("PUSH(R10) | retour fonction placé dans la pile\n");
		}
		
		// Récuperation du resultat
		this.generated_Indent(indent, buff);
		buff.append("POP(R0) | valeur à insérer dans l'IDF\n");
		
		NVariable elt = (NVariable)(node.getFG());
		
		switch(elt.getScope()){
			
			// Var globale on change la valeur en MC
			case -1:
				this.generated_Indent(indent, buff); buff.append("ST(R0, " + elt.getRef() + ")\n");
				break;
				
			// nom de la fonction dans laquelle elle est
			default:
				
				switch(elt.getCategorie()){
				
					// Variable locale on change la valeur dans la pile
					// Sa place a été alloué en début de fonction normalement
					case "variable":
						this.generated_Indent(indent, buff); buff.append("PUTFRAME(R0, 4 * " + elt.getRef() + ")\n");
					break;
				}
				/*
				switch(n.filsG.categorie){
					case 'param'
						>> PUTFRAME(R0, -(3 + elt.index)*4) // 0 premier parametre envoyé
				}
				*/
			break;
		}
		this.generated_Indent(indent, buff);buff.append("|== Fin (=) ==|\n");
		buff.append("\n");
		
	}
	
	/**
	 * Génère une expression
	 * - Une expression est une partie d'instruction
	 * - une operation
	 * - un atome (constante, idf, appelfonction)
	 * -lire
	 */
	private void generated_Expression(NoeudElement node, StringBuffer buff, int indent) {
		System.out.println("\t\t\tGéneration Expression:"+(String)node.getCategorie()+"\n");
		if(node.getCategorie() instanceof String){		
			switch((String)node.getCategorie()){
				case "constant":
					this.generated_Atome(node, buff, indent+1);
					break;
		
				case "identificateur":
					this.generated_Atome(node, buff, indent+1);
					break;
							
				case "appel_fonction":
					this.generated_Atome(node, buff, indent+1);
					break;
							
				case "operation":
					this.generated_Operation((NOperation)node, buff, indent+1);
					break;
							
				case "read":
					this.generated_Read(node, buff, indent);
					break;
				
				case "write":
					this.generated_Write(node, buff, indent);
					break;
				
				case "appelFonction":
					this.generated_Call((NAppelFonction)node, buff, indent);
					break;
					
							
				default:
					break;
			}
		}
				
	}
	
	/**
	 * Génère un atome
	 * - Un atome est un facteur ou partie de facteur
	 * - IDF / NUM / appel / (expression)
	 * - x / 5 / f() / (..)
	 * @todo generer_Call
	 */
	private void generated_Atome(NoeudElement node, StringBuffer buff, int indent){
		
		
		if((node) instanceof NConstant){
			
			Integer elt = (Integer)((NConstant)node).getValeur();
			System.out.println("\t\tGéneration constante:"+elt+"\n");
			this.generated_Indent(indent, buff); buff.append("|= NOMBRE =|\n");
			this.generated_Indent(indent, buff); buff.append("CMOVE(" + elt + ", R0)\n");
			this.generated_Indent(indent, buff); buff.append("PUSH(R0)\n");
		}
		// Variable : on met sa valeur dans la pile
		else if((node) instanceof NVariable){
			System.out.println("\t\tGéneration idf:"+((NVariable)node).get_Value(this.tds)+"\n");
			this.generated_Indent(indent, buff); buff.append("|= IDF =|\n");
			this.generated_Idf((NVariable)node, buff, indent);
		}
		// Appel
		else if(node instanceof NAppelFonction){
			this.generated_Call((NAppelFonction)node, buff, indent);
		}
		// PO expression PF
		else{
			this.generated_Expression(node, buff, indent);
		}
		buff.append("\n");
	}
	

	/**
	 * Genere les operation +/- avec facteurs et parenthèses
	 * @param node
	 * @param buff
	 * @param indent
	 * @todo generer_facteur
	 */
	private void generated_Operation(NoeudElement node, StringBuffer buff, int indent) {
		if(node instanceof NOperation){
			System.out.println("\t\t\tOperateur: "+((NOperation)node).getVal());
			switch((String)(((NOperation)node).getVal())){
				case "+":
					this.generated_Indent(indent, buff); buff.append("|== Debut (+) ==|\n");
					
					// Expr gauche
					this.generated_Expression(node.getFG(), buff, indent + 1);
					// Facteur droit
					this.generated_Facteur(node.getFD(), buff, indent + 1);
					
					// Si l'expr de droite est un appel on doit récuperer le resultat
					if(node.getFD() instanceof NAppelFonction){
						this.generated_Indent(indent, buff);
						buff.append("PUSH(R10) | retour fonction placé dans la pile\n");
					}
					
					this.generated_Indent(indent, buff); buff.append("POP(R1)\n");
					this.generated_Indent(indent, buff); buff.append("POP(R0)\n");
					this.generated_Indent(indent, buff); buff.append("ADD(R0, R1, R2)\n");
					this.generated_Indent(indent, buff); buff.append("PUSH(R2)\n");
					this.generated_Indent(indent, buff); buff.append("|== Fin (+) ==|\n");
					
					break;
				case "-":
					this.generated_Indent(indent, buff); buff.append("|== Debut (-) ==|\n");
					
					this.generated_Expression(node.getFG(), buff, indent + 1);
					this.generated_Facteur((NOperation)node.getFD(), buff, indent + 1);
					
					// Si l'expr de droite est un appel on doit récuperer le resultat
					if(node.getFD() instanceof NAppelFonction){
						this.generated_Indent(indent, buff);
						buff.append("PUSH(R10) | retour fonction placé dans la pile\n");
					}
					this.generated_Indent(indent, buff); buff.append("POP(R1)\n");
					this.generated_Indent(indent, buff); buff.append("POP(R0)\n");
					this.generated_Indent(indent, buff); buff.append("SUB(R0, R1, R2)\n");
					this.generated_Indent(indent, buff); buff.append("PUSH(R2)\n");
					this.generated_Indent(indent, buff); buff.append("|== Fin (-) ==|\n");
					break;
				
				// ça peut être "*"
				default:
					this.generated_Facteur(node, buff, indent);
					break;
			}
		}
		// facteur
		else{
			this.generated_Facteur(node, buff, indent);
		}
		
	}
	
	/**
	 * Génere un idf, il peut etre global...
	 * ou local, dans ce cas il est soit une simple variable soit un parametre
	 * @param node
	 * @param buff
	 * @param indent
	 */
	private void generated_Idf(NVariable node, StringBuffer buff, int indent) {
		System.out.println("\t\t\t\tGenerer IDF");
		// Globale ou fonction
		switch(node.getScope()){
		
			// Var globale on change la valeur en MC
			case -1:
				this.generated_Indent(indent, buff);
				buff.append("LD(" + node.getRef() + ", R0)\n");
				break;
				
			// fonction
			default:
				
				switch(node.getCategorie()){
				
					// Variable locale on r�cup�re la valeur dans la pile
					case "variable":
						this.generated_Indent(indent, buff);
						buff.append("GETFRAME(R0, 4 * " + node.getRef() + ")\n");
					break;
					
					// IDF parametre � la fonction
					case "parametre":
						this.generated_Indent(indent, buff);
						buff.append("GETFRAME(R0, - (3 + " + node.getRef() + ") * 4)\n");
						break;
				}
			break;
		}
		this.generated_Indent(indent, buff);
		buff.append("PUSH(R0)\n");
		
	}
	
	/**
	 * @TOD0
	 * @param node
	 * @param buff
	 * @param indent
	 */
	private void generated_Call(NAppelFonction node, StringBuffer buff, int indent) {
		// TODO Auto-generated method stub
		int childs = node.getChildren().size();
		
		this.generated_Indent(indent, buff);buff.append("|== Debut (appel) ==|\n");
		
		
		// Remplissage de la pile parametre
		this.generated_Indent(indent+1, buff);
		buff.append("|== Envoi des paramètres ==|\n");
		for (NoeudElement child : node.getChildren()){
			this.generated_Expression(child, buff, indent+1);
		}
		
		// Appel fonction
		this.generated_Indent(indent, buff);
		buff.append("CALL(" + node.ref  + ")\n");
		
		// Vidage de la pile parametre
		for (int i = 0; i < childs; i++){
			this.generated_Indent(indent, buff);buff.append("POP(R1) | dépilement arguments\n");
		}
		
		// Si la fonction a un retour on push le retour (contenu dans R0)
		
		this.generated_Indent(indent, buff);buff.append("|== Fin (appel) ==|\n");
		buff.append("\n");
	}
	
	/**
	 * Permet de garder la valeur de retour
	 * @param node
	 * @param buff
	 * @param indent
	 */
	private void generated_Return(NoeudElement node, StringBuffer buff, int indent) {
		this.generated_Indent(indent, buff);
		buff.append("|== Debut (retour) ==|\n");
		
		this.generated_Expression(node.getFG(), buff, indent+1);
		
		// R�cuperation du resultat de l'expression dans R0
		this.generated_Indent(indent, buff);
		buff.append("POP(R0)\n");
		this.generated_Indent(indent, buff);
		buff.append("MOVE(R0, R10)\n"); // mise du resultat dans R10 (stockage conventionnel de retour de fonction)
		this.generated_Indent(indent, buff);
		buff.append("|== Fin (retour) ==|\n");
		buff.append("\n");

	}
	
	/**
	 * Genere l'écriture
	 * @param node
	 * @param buff
	 * @param indent
	 */
	private void generated_Write(NoeudElement node, StringBuffer buff, int indent) {
		this.generated_Indent(indent, buff); buff.append("|== Debut (ecriture()) ==|\n");
		this.generated_Expression(node.getChildren().get(0), buff, indent+1);
		// Si le résultat de droite vient d'une fonction il est récupéré de R10
		if(node.getFG() instanceof NAppelFonction){
			this.generated_Indent(indent, buff); buff.append("PUSH(R10) | retour fonction placé dans la pile\n");
		}	
		this.generated_Indent(indent, buff); buff.append("POP(R0)\n"); // Récupération de l'expression
		this.generated_Indent(indent, buff); buff.append("Something is writing with R0...\n");
		this.generated_Indent(indent, buff); buff.append("|== Fin (read()) ==|\n");
		
		buff.append("\n");
	}
	
	/**
	 * Genere la lecture
	 * @param node
	 * @param buff
	 * @param indent
	 */
	private void generated_Read(NoeudElement node, StringBuffer buff, int indent){
		this.generated_Indent(indent, buff); buff.append("|== Debut (read()) ==|\n");
		this.generated_Indent(indent, buff); buff.append("PUSH(R0)\n");
		this.generated_Indent(indent, buff); buff.append("|== Fin (read()) ==|\n");
		buff.append("\n");
	}	


	/**
	 * Génère un facteur
	 * - Un facteur est une expression ou partie d'expression
	 * - DIV     / MUL     / atome
	 * - .. / .. / .. * .. / atome
	 */
	private void generated_Facteur(NoeudElement node, StringBuffer buff, int indent) {
		// facteur DIV atome
				// facteur MUL atome
				if(node instanceof 	NOperation){
					switch((String)(((NOperation)node).getVal())){
						case "/":
							this.generated_Indent(indent, buff);buff.append("|== Debut (/) ==|\n");
							
							this.generated_Facteur((NOperation)node.getFG(), buff, indent+1);
							this.generated_Atome(node.getFD(), buff, indent+1);
							
							this.generated_Indent(indent, buff);buff.append("POP(R1)\n");
							this.generated_Indent(indent, buff);buff.append("POP(R0)\n");
							this.generated_Indent(indent, buff);buff.append("DIV(R0, R1, R2)\n");
							this.generated_Indent(indent, buff);buff.append("PUSH(R2)\n");
							this.generated_Indent(indent, buff);buff.append("|== Fin (/) ==|\n");
							break;
							
						case "*":
							this.generated_Indent(indent, buff);buff.append("|== Debut (*) ==|\n");
							
							this.generated_Facteur((NOperation)node.getFG(), buff, indent+1);
							this.generated_Atome(node.getFD(), buff, indent+1);
							
							this.generated_Indent(indent, buff);buff.append("POP(R1)\n");
							this.generated_Indent(indent, buff);buff.append("POP(R0)\n");
							this.generated_Indent(indent, buff);buff.append("MUL(R0, R1, R2)\n");
							this.generated_Indent(indent, buff);buff.append("PUSH(R2)\n");
							this.generated_Indent(indent, buff);buff.append("|== Fin (/) ==|\n");
							break;
						default:
							// �a peut �tre un + donc on va vers atome
							this.generated_Atome(node, buff, indent);
							break;
					}
					buff.append("\n");
				}
				// Atome
				else{
					this.generated_Atome(node, buff, indent);
				}
		
	}
	


	private void generated_If(NIf node, StringBuffer buff, int indent) {
		this.generated_Indent(indent, buff);buff.append("|== Debut (if) ==|\n");
		this.generated_Indent(indent, buff);buff.append("if:\n");
		
		// G�n�ration de la condition
		this.generated_Condition((NCondition)node.getFG(), buff, indent+1);
		
		// Si y'a un bloc else
		if(node.getChildren().size() > 2){
			// On saute au else si la condition est fausse
			this.generated_Indent(indent+1, buff);buff.append("BEQ(R2, else) | condition fausse\n");
		}
		else{
			// Sinon on saute � la fin si la condition est fausse
			this.generated_Indent(indent+1, buff);buff.append("BEQ(R2, endif) | condition fausse\n");
		}
				
		// G�n�ration du bloc
		this.generated_Indent(indent+1, buff);buff.append("|== Debut (bloc if) ==|\n");
		
		this.generated_Bloc(node.getFD(), buff, indent+1);
		
		
		// Si y'a un bloc else
		if(node.getChildren().size() > 2){
			// On branche la fin du if pour pas aller dans le elset
			this.generated_Indent(indent+1, buff);buff.append("BR(endif)\n");
			
			this.generated_Indent(indent, buff);buff.append("else:\n");
			this.generated_Indent(indent+1, buff);buff.append("|== Debut (bloc else) ==|\n");
			
			this.generated_Bloc(node.getChildren().get(2), buff, indent+1);
		}
		// G�n�ration du then ou else
		/*String childContent = (String)(node.getChildren().get(2).getContent());
		switch (childContent){
			case "then":
				break;
				
			case "else":
				this.generated_Indent(indent, buff);buff.append("else:\n");
				break;
				
			case "elseif":
				//@todo
				break;
		}*/
		//if(node.getChildren().get(2).getContent() instanceof String)
		this.generated_Indent(indent, buff);buff.append("endif:\n");
		buff.append("\n");
	}

	private void generated_While(NWhile node, StringBuffer buff, int indent) {
		System.out.println("\t\t\tGenerer while");
		this.generated_Indent(indent, buff);buff.append("|== Debut (while) ==|\n");
		this.generated_Indent(indent, buff);buff.append("while:\n");
		
		// Génération de la condition
		this.generated_Condition((NCondition)node.getFG().getFG(), buff, indent+1);
		
		
		this.generated_Indent(indent+1, buff);
		buff.append("BEQ(R2, endwhile) | condition fausse\n");
				
		// Génération du bloc
		this.generated_Indent(indent+1, buff);buff.append("|== Debut (bloc while) ==|\n");
		
		this.generated_Bloc(node.getChildren().get(1), buff, indent+1);
		

		this.generated_Indent(indent, buff);buff.append("BR(while)\n");
		this.generated_Indent(indent, buff);buff.append("endwhile:\n");
		buff.append("\n");
	}


	private void generated_Condition(NCondition node , StringBuffer buff, int indent){
		System.out.println("\t\t\tGenerer condition");
		this.generated_Indent(indent, buff);buff.append("|== Debut (condition) ==|\n");
		
		this.generated_Expression((NoeudElement)node.getFG(), buff, indent+1);
		this.generated_Expression(node.getFD(), buff, indent+1);
		
		this.generated_Indent(indent, buff);buff.append("POP(R1)\n");
		this.generated_Indent(indent, buff);buff.append("POP(R0)\n");
		
		switch(node.getCondition()){
			case "<":
				this.generated_Indent(indent, buff);buff.append("CMPLT(R0, R1, R2)\n");
				break;
				
			case ">":
				this.generated_Indent(indent, buff);buff.append("CMPLT(R1, R0, R2)\n");
				break;
				
			// Condition vide (toujours true)
			default:
				this.generated_Indent(indent, buff);buff.append("CMOVE(1, R2)\n");
				break;
		}
		buff.append("\n");
	}
}
