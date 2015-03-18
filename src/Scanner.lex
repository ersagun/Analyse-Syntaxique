/* auteur : ersagun.yalcintepe@etu.univ-lorraine.fr */
/* (c) 2015 */


package fr.ul.miage.exemple.generated;
import java_cup.runtime.Symbol;
import java.io.IOException;

%%

/* options */
%line
%public
%cupsym ParserSym
%cup
%debug

/* champs et méthodes supplémentaires de la classe Yylex */
%{
	private void error() throws IOException{
		throw new IOException("token inconnu à la ligne "+yyline+": "+yytext());
	}
	
	private void echo(){
	   System.out.print(yytext());
	}
%}

/* macros */
SEP     =   [ \r\t\f\n]
NUMB    =   [0-9]+
IDF    =   [a-zA-Z][a-zA-Z0-9_]*
COMMENT		=	\/\*(([^*])|(\*[^/]))*\*\/

%%

/* règles */

"+"         { echo(); return new Symbol(ParserSym.ADD); }
"-"         { echo(); return new Symbol(ParserSym.SUB); }
"*"         { echo(); return new Symbol(ParserSym.MUL);  }
"/"         { echo(); return new Symbol(ParserSym.DIV);  }
"("         { echo(); return new Symbol(ParserSym.PO);   }
")"         { echo(); return new Symbol(ParserSym.PF);   }
";"         { echo(); return new Symbol(ParserSym.PTVIRG);   }
"="         { echo(); return new Symbol(ParserSym.EGAL);   }
"read"      { echo(); return new Symbol(ParserSym.READ); }
"write"     { echo(); return new Symbol(ParserSym.WRITE); }
"<" 		{ echo(); return new Symbol(ParserSym.INF); }
"<="		{ echo(); return new Symbol(ParserSym.INFEG); }
"=="		{ echo(); return new Symbol(ParserSym.EGEG); }
">="		{ echo(); return new Symbol(ParserSym.SUPEG); }
">"		    { echo(); return new Symbol(ParserSym.SUP); }
"!="		{ echo(); return new Symbol(ParserSym.DIF); }
"{"		    { echo(); return new Symbol(ParserSym.AO); }
"}" 		{ echo(); return new Symbol(ParserSym.AF); }
","		    { echo(); return new Symbol(ParserSym.VIRG); }
"if"		{ echo(); return new Symbol(ParserSym.SI); }
"else"		{ echo(); return new Symbol(ParserSym.SINON); }
"while"		{ echo(); return new Symbol(ParserSym.TQUE); }
"void"		{ echo(); return new Symbol(ParserSym.VOID); }
"int"		{ echo(); return new Symbol(ParserSym.INT); }
"return"	{ echo(); return new Symbol(ParserSym.RTN); }
{NUMB}      { echo(); return new Symbol(ParserSym.NUMB, new Integer(Integer.parseInt(yytext())));}
{IDF}       { echo(); return new Symbol(ParserSym.IDF, new String(yytext()));}
{SEP}       { echo(); }
{COMMENT}	{echo();}
