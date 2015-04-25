
import static org.junit.Assert.*;

import java.io.FileInputStream;

import org.junit.Test;

import fr.ul.miage.analyse.generated.*;


public class TestGrammaire {/**
	@Test
	public void test_00() throws Exception {	
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/00-minimal.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}**/

	@Test
	public void test_01() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/01-minimal.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_02() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/02-global.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_03() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/03-expression.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_04() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/04-expression.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_05() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/05-expression.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}/**
	
	@Test
	public void test_06() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/06-local.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_07() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/07-parametre.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_08() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/08-fonction.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_09() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/09-fonction.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_10() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/10-conditionnelle.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_11() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/11-iteration.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_12() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/12-recursivitie.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_13() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/13-err1.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_14() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/14-err2.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_15() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/15-err3.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_16() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/16-err4.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}
	
	@Test
	public void test_17() throws Exception {
		ParserCup parser = new ParserCup(new AnalyseurLexical(new FileInputStream("./fichiers/17-err5.miage")));
		parser.parse();
		System.out.println("_________________________________________TDS : _________________________________________");
		System.out.println(parser.afficheTDSetAST());
		System.out.println("________________________________________________________________________________________");	
	}**/
}

