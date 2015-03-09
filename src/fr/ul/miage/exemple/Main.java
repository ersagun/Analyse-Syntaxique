/**
 * La lecture du flux de carractère se fait en lecture de fichier
 */
package fr.ul.miage.exemple;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fr.ul.miage.exemple.generated.ParserCup;
import fr.ul.miage.exemple.generated.Yylex;

/**
 * @author Azim Roussanaly
 *
 */
public class Main {

	public static void main(String[] args) {
		File f = new File("./exemple.log");
		  FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  ParserCup parser = new ParserCup(new Yylex(fis));
		try {
			System.out.println("Calcul de statistique a commencé, veuillez patienter s'il vous plait :");
			parser.parse();
			System.out.println("La calcul est fini.");
		} catch (Exception e) {
			System.err.println("...Erreur de syntaxe ");
			System.exit(1);
			System.exit(1);
		}
		parser.getResult();
	}
	
	

}
