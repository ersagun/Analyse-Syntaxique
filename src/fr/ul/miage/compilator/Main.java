
package fr.ul.miage.compilator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fr.ul.miage.compilator.*;


	/**	
	public static String[] listerRepertoire(File repertoire){ 

		String [] listefichiers;

		listefichiers=repertoire.list(); 
		return listefichiers;
		} 

	
	public static void main(String[] args) {
		
		String[] listefichiers=listerRepertoire(new File("./fichiers"));
		
		for(String fichier:listefichiers){
			 FileInputStream fis = null;
				try {
					fis = new FileInputStream("./fichiers/"+fichier);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
					ParserCup parser = new ParserCup(new Yylex(fis));
				try {
					System.out.println("-------------------------------- "+fichier+" est en cours de lecture. ----------------");
					parser.parse();
					System.out.println("-------------------------------- Lecture terminé. ----------------");
				} catch (Exception e) {
					System.err.println("...Erreur de syntaxe ");
					System.exit(1);
					System.exit(1);
				}
				//parser.getResult();
			}
			
		
		ParserCup parser;
		try {
			parser = new ParserCup(new Yylex(new FileInputStream("./fichiers/05-expression.miage")));
			parser.parse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		**/


/**
 * 
 */


import java.io.FileNotFoundException;
import java.io.FileReader;

import fr.ul.miage.analyse.generated.*;
/**
 * 
 * @author
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    if (args.length == 0) {
	        System.out.println("Usage : java Main <inputfile>");
	        System.exit(1);
	    }

	    
		try {
			ParserCup parser = new ParserCup(new AnalyseurLexical(new FileReader(args[0])));
			
			parser.parse();
		} catch (FileNotFoundException e1) {
			System.out.println("Fichier introuvable");
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Erreur de syntaxe");
                        e.printStackTrace();
			System.exit(1);
		}
	}

}

