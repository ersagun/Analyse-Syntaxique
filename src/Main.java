import java.io.FileInputStream;
import java.io.FileNotFoundException;

import fr.ul.miage.analyse.generated.*;


public class Main {

	public static void main(String[] args) {
		ParserCup parser;
		try {
			parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/02-globall.miage")));
			parser.parse();
			System.out.println("TDS :");
			System.out.println(parser.afficheTDSetAST());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
