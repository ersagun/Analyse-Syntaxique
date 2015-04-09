package fr.ul.miage.projet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;




/**
 * 
 * 	- Conventions ASM :
 * 		* R10 sert de stockage au retour des fonctions
 * 		* R2 sert de stockage au resultat d'une opération
 * 
 * 	- Fichiers gérés : 	01.miage, 02.miage, 03.miage, 04.miage
 * 						05.miage, 06.miage, 07.miage, 08.miage, 11.miage
 * 
 * @todo:
 * 	Gérer le cas ou une fonction ne retourne rien ex f( m() ); et m est de type void
 * @author Maxime
 *
 */
public class ASMGenerator {
	
	private TDS tds;
	private Node<?> node;

	
	public ASMGenerator(TDS tds, Node<?> node) {
		super();
		this.tds = tds;
		this.node = node;
	}

	/**
	 * Retourne la génération ASM sous une chaine
	 * 
	 * @return
	 */
	public String generateToString(){
		StringBuffer buf = new StringBuffer();
		this._generateBase(node, buf);
		return buf.toString();
	}
	
	public void generateToFile(String filename){
		try{
			String content = this.generateToString();
			File file = new File(filename);
			// if file doesnt exists, then create it
			if (!file.exists()) {
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
	 * 
	 * @param node
	 * @param buff
	 */
	private void _generateBase(Node<?> node, StringBuffer buff){
		buff.append("|============ Header ================|\n");
		buff.append(".include beta.uasm\n");
		buff.append("BR(start)\n");
		
		this._generateGlobal(buff);
		this._generateProgramm(node, buff, 0);
		
		buff.append("|============ Début programme ================|\n");
		buff.append("start:\n");
		buff.append("\tCMOVE(stack, SP)\n");
		buff.append("\tCALL(main)\n");
		buff.append("\tHALT()\n");
		buff.append("stack:\n");
	}
	
	/**
	 * Déclaration des variables globales
	 * Déclaration en mémoire centrale au niveau ASM
	 * 
	 */
	private void _generateGlobal(StringBuffer buf){
		buf.append("|============ Declarations globales ================|\n");
		for (Element elt : this.tds.getGlobalVars()) {
			//System.out.println(elt);
			buf.append( elt.getId() + " : LONG(" + elt.getValeur() + ")\n");
		}
		
	}

	/**
	 * Début de la génération ASM
	 * 	- Demande la génération de chaques fonctions
	 * 
	 * @param node
	 * @param buff
	 */
	private void _generateProgramm(Node<?> node, StringBuffer buff, int indent){
		for (Node child : node.getChildren()) {
			
			this._generateFunction( child, buff, indent);
		}
	}
	
	/**
	 * Génére la structure de base d'une fonction
	 * 	- Les variables locales sont déclarées en allouant la place nécessaire en pile
	 * 
	 * @param node On récupère un noeud FONCTION
	 * @param buff
	 */
	private void _generateFunction(Node<NodeContenuFonction> node, StringBuffer buff, int indent){
		int nbVarLocal = node.getContent().getNb_var_loc();
		String id = node.getContent().getId();
				
		//buf.append("|============ Header ================|\n");
		buff.append( id + ":\n");
		buff.append("\tPUSH(LP)\n");
		buff.append("\tPUSH(BP)\n");
		buff.append("\tMOVE(SP, BP)\n");
		buff.append("\tALLOCATE(" + nbVarLocal + ")\n");
		
		this._generateBloc(node.getChildren().get(0), buff, indent+1);
		
		buff.append("\tDEALLOCATE(" + nbVarLocal + ")\n");
		buff.append("\tPOP(BP)\n");
		buff.append("\tPOP(LP)\n");
		buff.append("\tJMP(LP)\n");
	}

	private void _generateBloc(Node<?> node, StringBuffer buff, int indent){
		// Parcours des instructions
		for (Node<?> child : node.getChildren()){
			
			this._generateInstruction( child, buff, indent);
		}
	}
	
	/**
	 * Génère une instruction.
	 * L'instruction est une ligne par defaut dans une fonction
	 * @todo
	 */
	private void _generateInstruction(Node<?> node, StringBuffer buff, int indent){

		if(node.getContent() instanceof String){
			
			switch((String)node.getContent()){
				case "declaration":
					break;
				case "affectation":
					this._generateAffectation((Node<String>)node, buff, indent+1);
					break;
				case "appel":
					break;
				
				// Cas ou le contenu est de type ecriture
				case "ecriture":
					this._generateWrite((Node<String>)node, buff, indent+1);
					break;
					
				case "retour":
					this._generateReturn((Node<String>)node, buff, indent+1);
					break;
					
				// Cas d'une alternative
				case "si":
					this._generateIf(node, buff, indent+1);
					break;
					
				// Cas du while
				case "while":
					this._generateWhile(node, buff, indent+1);
					break;
					
				default:
					break;
			}
		}
		else if(node.getContent() instanceof NodeContentAppel){
			this._generateCall((Node<NodeContentAppel>)node, buff, indent+1);
		}
	}
	
	/**
	 * Affecte une partie droite à une variable
	 * La variable peut être globale / locale / paramètre
	 * Le code ASM généré est different
	 * 
	 * 	IDF = expression
	 * 	IDF 
	 * @todo
	 */
	private void _generateAffectation(Node<String> node, StringBuffer buff, int indent){

		this._generateIndent(indent, buff);
		buff.append("|== Debut (=) ==|\n");
		
		/**
		 * Partie droite
		 */
		// Si la partie droite est une lecture()
		if( (node.getChildren().get(1).getContent() instanceof String) 
				&& ( ((String)node.getChildren().get(1).getContent()).equals("lecture") ) ){
			this._generateRead(node, buff, indent+1);
		}
		else{
			this._generateExpression(node.getChildren().get(1), buff, indent+1);
		}
		
		/**
		 * Affectation du resultat à la partie gauche
		 */
		// Si le resultat de droite vient d'une fonction Il est stocké dans R0
		if(node.getChildren().get(1).getContent() instanceof NodeContentAppel){
			this._generateIndent(indent, buff);
			buff.append("PUSH(R10) | retour fonction placé dans la pile\n");
		}
		
		// Récuperation du resultat
		this._generateIndent(indent, buff);
		buff.append("POP(R0) | valeur à insérer dans l'IDF\n");
		
		//System.out.println(node.getChildren().get(0).getContent() instanceof Element);System.exit(0);
		// à gauche d'une affectation c'est un IDF
		Element elt = (Element)(node.getChildren().get(0).getContent());
		
		switch(elt.getPortee()){
				
			// Var globale on change la valeur en MC
			case "globale":
				this._generateIndent(indent, buff);buff.append("ST(R0, " + elt.getId() + ")\n");
				break;
				
			// nom de la fonction dans laquelle elle est
			default:
				
				switch(elt.getCategorie()){
				
					// Variable locale on change la valeur dans la pile
					// Sa place a été alloué en début de fonction normalement
					case "variable":
						this._generateIndent(indent, buff);buff.append("PUTFRAME(R0, 4 * " + elt.getIndiceVar() + ")\n");
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
		this._generateIndent(indent, buff);buff.append("|== Fin (=) ==|\n");
		buff.append("\n");
	}
	
	
	/**
	 * Génère une expression
	 * - Une expression est une partie d'instruction
	 * - ADD     / SUB     / facteur
	 * - .. + .. / .. - .. / facteur
	 */
	private void _generateExpression(Node<?> node, StringBuffer buff, int indent){

		// expr ADD facteur
		// expr SUB facteur
		if(node.getContent() instanceof String){
			switch((String)(node.getContent())){
				case "+":
					this._generateIndent(indent, buff);buff.append("|== Debut (+) ==|\n");
					
					// Expr gauche
					this._generateExpression(node.getChildren().get(0), buff, indent + 1);
					// Facteur droit
					this._generateFacteur(node.getChildren().get(1), buff, indent + 1);
					
					// Si l'expr de droite est un appel on doit récuperer le resultat
					if(node.getChildren().get(1).getContent() instanceof NodeContentAppel){
						this._generateIndent(indent, buff);
						buff.append("PUSH(R10) | retour fonction placé dans la pile\n");
					}
					
					this._generateIndent(indent, buff);buff.append("POP(R1)\n");
					this._generateIndent(indent, buff);buff.append("POP(R0)\n");
					this._generateIndent(indent, buff);buff.append("ADD(R0, R1, R2)\n");
					this._generateIndent(indent, buff);buff.append("PUSH(R2)\n");
					this._generateIndent(indent, buff);buff.append("|== Fin (+) ==|\n");
					
					break;
				case "-":
					this._generateIndent(indent, buff);buff.append("|== Debut (-) ==|\n");
					
					this._generateExpression(node.getChildren().get(0), buff, indent + 1);
					this._generateFacteur(node.getChildren().get(1), buff, indent + 1);
					
					// Si l'expr de droite est un appel on doit récuperer le resultat
					if(node.getChildren().get(1).getContent() instanceof NodeContentAppel){
						this._generateIndent(indent, buff);
						buff.append("PUSH(R10) | retour fonction placé dans la pile\n");
					}
					this._generateIndent(indent, buff);buff.append("POP(R1)\n");
					this._generateIndent(indent, buff);buff.append("POP(R0)\n");
					this._generateIndent(indent, buff);buff.append("SUB(R0, R1, R2)\n");
					this._generateIndent(indent, buff);buff.append("PUSH(R2)\n");
					this._generateIndent(indent, buff);buff.append("|== Fin (-) ==|\n");
					break;
				
				// ça peut être "*"
				default:
					this._generateFacteur(node, buff, indent);
					break;
			}
		}
		// facteur
		else{
			this._generateFacteur(node, buff, indent);
		}
		/*
		switch(n.type)
		
			case 'facteur'
				generer_facteur(n)
			
			case 'NUMB'
				generer_numb(n)
				*/
		buff.append("\n");
	}
	
	/**
	 * Génère un facteur
	 * - Un facteur est une expression ou partie d'expression
	 * - DIV     / MUL     / atome
	 * - .. / .. / .. * .. / atome
	 */
	private void _generateFacteur(Node<?> node, StringBuffer buff, int indent){
		
		// facteur DIV atome
		// facteur MUL atome
		if(node.getContent() instanceof String){
			switch((String)(node.getContent())){
				case "/":
					this._generateIndent(indent, buff);buff.append("|== Debut (/) ==|\n");
					
					this._generateFacteur(node.getChildren().get(0), buff, indent+1);
					this._generateAtome(node.getChildren().get(1), buff, indent+1);
					
					this._generateIndent(indent, buff);buff.append("POP(R1)\n");
					this._generateIndent(indent, buff);buff.append("POP(R0)\n");
					this._generateIndent(indent, buff);buff.append("DIV(R0, R1, R2)\n");
					this._generateIndent(indent, buff);buff.append("PUSH(R2)\n");
					this._generateIndent(indent, buff);buff.append("|== Fin (/) ==|\n");
					break;
					
				case "*":
					this._generateIndent(indent, buff);buff.append("|== Debut (*) ==|\n");
					
					this._generateFacteur(node.getChildren().get(0), buff, indent+1);
					this._generateAtome(node.getChildren().get(1), buff, indent+1);
					
					this._generateIndent(indent, buff);buff.append("POP(R1)\n");
					this._generateIndent(indent, buff);buff.append("POP(R0)\n");
					this._generateIndent(indent, buff);buff.append("MUL(R0, R1, R2)\n");
					this._generateIndent(indent, buff);buff.append("PUSH(R2)\n");
					this._generateIndent(indent, buff);buff.append("|== Fin (/) ==|\n");
					break;
				default:
					// ça peut être un + donc on va vers atome
					this._generateAtome(node, buff, indent);
					break;
			}
			buff.append("\n");
		}
		// Atome
		else{
			this._generateAtome(node, buff, indent);
		}
	}
	
	
	/**
	 * Génère un atome
	 * - Un atome est un facteur ou partie de facteur
	 * - IDF / NUM / appel / (expression)
	 * - x / 5 / f() / (..)
	 * @todo
	 */
	private void _generateAtome(Node<?> node, StringBuffer buff, int indent){

		// Nombre : on mets sa valeur dans la pile
		if(node.getContent() instanceof Integer){
			Integer elt = (Integer)node.getContent();
			this._generateIndent(indent, buff);buff.append("|= NOMBRE =|\n");
			this._generateIndent(indent, buff);buff.append("CMOVE(" + elt + ", R0)\n");
			this._generateIndent(indent, buff);buff.append("PUSH(R0)\n");
		}
		// Variable : on mets sa valeur dans la pile
		else if(node.getContent() instanceof Element){
			this._generateIndent(indent, buff);buff.append("|= IDF =|\n");
			this._generateIDF((Node<Element>)node, buff, indent);
		}
		// Appel
		else if(node.getContent() instanceof NodeContentAppel){
			this._generateCall((Node<NodeContentAppel>)node, buff, indent);
		}
		// PO expression PF
		else{
			this._generateExpression(node, buff, indent);
		}
		buff.append("\n");
	}
	
	/**
	 * Génère la mise en pile de l'identifiant demandé
	 * 
	 * @param node
	 * @param buff
	 * @param indent
	 */
	private void _generateIDF(Node<Element> node, StringBuffer buff, int indent){
		Element elt = node.getContent();
		
		// Globale ou fonction
		switch(elt.getPortee()){
		
			// Var globale on change la valeur en MC
			case "globale":
				this._generateIndent(indent, buff);
				buff.append("LD(" + elt.getId() + ", R0)\n");
				break;
				
			// fonction
			default:
				
				switch(elt.getCategorie()){
				
					// Variable locale on récupère la valeur dans la pile
					case "variable":
						this._generateIndent(indent, buff);
						buff.append("GETFRAME(R0, 4 * " + elt.getIndiceVar() + ")\n");
					break;
					
					// IDF parametre à la fonction
					case "parametre":
						this._generateIndent(indent, buff);
						buff.append("GETFRAME(R0, - (3 + " + elt.getIndiceVar() + ") * 4)\n");
						break;
				}
			break;
		}
		this._generateIndent(indent, buff);
		buff.append("PUSH(R0)\n");
	}
	
	
	private void _generateCall(Node<NodeContentAppel> node, StringBuffer buff, int indent){
		NodeContentAppel content = node.getContent();
		int childs = node.getChildren().size();
		
		this._generateIndent(indent, buff);buff.append("|== Debut (appel) ==|\n");
		
		
		// Remplissage de la pile parametre
		this._generateIndent(indent+1, buff);
		buff.append("|== Envoi des paramètres ==|\n");
		for (Node<?> child : node.getChildren()){
			
			this._generateExpression( child, buff, indent+1);
		}
		
		// Appel fonction
		this._generateIndent(indent, buff);
		buff.append("CALL(" + content.getId()  + ")\n");
		
		// Vidage de la pile parametre
		for (int i = 0; i < childs; i++){
			this._generateIndent(indent, buff);buff.append("POP(R1) | dépilement arguments\n");
		}
		
		// Si la fonction a un retour on push le retour (contenu dans R0)
		
		this._generateIndent(indent, buff);buff.append("|== Fin (appel) ==|\n");
		buff.append("\n");

	}
	
	private void _generateReturn(Node<String>node, StringBuffer buff, int indent){
		
		this._generateIndent(indent, buff);
		buff.append("|== Debut (retour) ==|\n");
		
		this._generateExpression(node.getChildren().get(0), buff, indent+1);
		
		// Récuperation du resultat de l'expression dans R0
		this._generateIndent(indent, buff);
		buff.append("POP(R0)\n");
		this._generateIndent(indent, buff);
		buff.append("MOVE(R0, R10)\n"); // mise du resultat dans R10 (stockage conventionnel de retour de fonction)
		this._generateIndent(indent, buff);
		buff.append("|== Fin (retour) ==|\n");
		
		buff.append("\n");
		
	}
	
	private void _generateRead(Node<String>node, StringBuffer buff, int indent){
		
		this._generateIndent(indent, buff);
		buff.append("|== Debut (read()) ==|\n");
		this._generateIndent(indent, buff);
		buff.append("PUSH(R0)\n");
		this._generateIndent(indent, buff);
		buff.append("|== Fin (read()) ==|\n");
		
		buff.append("\n");
		
	}
	
	private void _generateWrite(Node<String>node, StringBuffer buff, int indent){
		
		this._generateIndent(indent, buff);buff.append("|== Debut (ecriture()) ==|\n");
		
		this._generateExpression(node.getChildren().get(0), buff, indent+1);
		
		// Si le resultat de droite vient d'une fonction Il est récupéré de R10
		if(node.getChildren().get(0).getContent() instanceof NodeContentAppel){
			this._generateIndent(indent, buff);
			buff.append("PUSH(R10) | retour fonction placé dans la pile\n");
		}
				
		this._generateIndent(indent, buff);
		buff.append("POP(R0)\n"); // Récupération de l'expression
		this._generateIndent(indent, buff);
		buff.append("Something is writing with R0...\n");
		this._generateIndent(indent, buff);
		buff.append("|== Fin (read()) ==|\n");
		
		buff.append("\n");
		
	}
	
	
	/**
	 * Un bloc if comprend trois enfants
	 * 	- bloc condition
	 * 	- bloc
	 *  - then / else
	 * @param node
	 * @param buff
	 * @param indent
	 */
	private void _generateIf(Node<?> node, StringBuffer buff, int indent){
		this._generateIndent(indent, buff);buff.append("|== Debut (if) ==|\n");
		this._generateIndent(indent, buff);buff.append("if:\n");
		
		// Génération de la condition
		this._generateCondition((Node<NodeContentCondition>)node.getChildren().get(0), buff, indent+1);
		
		// Si y'a un bloc else
		if(node.getChildren().size() > 2){
			// On saute au else si la condition est fausse
			this._generateIndent(indent+1, buff);buff.append("BEQ(R2, else) | condition fausse\n");
		}
		else{
			// Sinon on saute à la fin si la condition est fausse
			this._generateIndent(indent+1, buff);buff.append("BEQ(R2, endif) | condition fausse\n");
		}
				
		// Génération du bloc
		this._generateIndent(indent+1, buff);buff.append("|== Debut (bloc if) ==|\n");
		
		this._generateBloc(node.getChildren().get(1), buff, indent+1);
		
		
		// Si y'a un bloc else
		if(node.getChildren().size() > 2){
			// On branche la fin du if pour pas aller dans le elset
			this._generateIndent(indent+1, buff);buff.append("BR(endif)\n");
			
			this._generateIndent(indent, buff);buff.append("else:\n");
			this._generateIndent(indent+1, buff);buff.append("|== Debut (bloc else) ==|\n");
			
			this._generateBloc(node.getChildren().get(2), buff, indent+1);
		}
		// Génération du then ou else
		/*String childContent = (String)(node.getChildren().get(2).getContent());
		switch (childContent){
			case "then":
				break;
				
			case "else":
				this._generateIndent(indent, buff);buff.append("else:\n");
				break;
				
			case "elseif":
				//@todo
				break;
		}*/
		//if(node.getChildren().get(2).getContent() instanceof String)
		this._generateIndent(indent, buff);buff.append("endif:\n");
		buff.append("\n");
	}
	
	private void _generateWhile(Node<?> node, StringBuffer buff, int indent){
		this._generateIndent(indent, buff);buff.append("|== Debut (while) ==|\n");
		this._generateIndent(indent, buff);buff.append("while:\n");
		
		// Génération de la condition
		this._generateCondition((Node<NodeContentCondition>)node.getChildren().get(0), buff, indent+1);
		
		
		this._generateIndent(indent+1, buff);buff.append("BEQ(R2, endwhile) | condition fausse\n");
				
		// Génération du bloc
		this._generateIndent(indent+1, buff);buff.append("|== Debut (bloc while) ==|\n");
		
		this._generateBloc(node.getChildren().get(1), buff, indent+1);
		

		this._generateIndent(indent, buff);buff.append("BR(while)\n");
		this._generateIndent(indent, buff);buff.append("endwhile:\n");
		buff.append("\n");
	}
	
	
	private void _generateCondition(Node<NodeContentCondition> node , StringBuffer buff, int indent){
		this._generateIndent(indent, buff);buff.append("|== Debut (condition) ==|\n");
		
		this._generateExpression(node.getChildren().get(0), buff, indent+1);
		this._generateExpression(node.getChildren().get(1), buff, indent+1);
		
		this._generateIndent(indent, buff);buff.append("POP(R1)\n");
		this._generateIndent(indent, buff);buff.append("POP(R0)\n");
		
		switch(node.getContent().getComparator()){
			case "<":
				this._generateIndent(indent, buff);buff.append("CMPLT(R0, R1, R2)\n");
				break;
				
			case ">":
				this._generateIndent(indent, buff);buff.append("CMPLT(R1, R0, R2)\n");
				break;
				
			// Condition vide (toujours true)
			default:
				this._generateIndent(indent, buff);buff.append("CMOVE(1, R2)\n");
				break;
		}
		buff.append("\n");
	}
	
	
	


}


