/*
 * analyseur lexical  du :
 * Projet interpreteur
 * 
 *
 *
 * (c) 2013
 */

package fr.ul.miage.analyse.generated;
import java_cup.runtime.Symbol;

%%
/* options */

%line
%column

%public

%class AnalyseurLexical
%cupsym ParserSym
%cup

/* champs et methodes supplementaires de la classe Yylex */
%{
	private void echo(){
	   System.out.print(yytext());
	}
%}

%eof{
    //C'est la fin du fichier
    System.out.println("FIN DU FICHIER\n\n");
%eof}



/* macros */
SEP                     =   [ \r\t\f\n]
NUM                     =   [0-9]+
IDF                     =   [a-zA-Z_][a-zA-Z0-9_]*
COM                     =   \/\*(([^*])|(\*[^/]))*\*\/
BOOLEEN                 =   "true"|"false"
OPERATEURCOMPARAISON    =   "<" | ">" | "<=" | ">=" | "==" | "!="

%%

/* regles */

"+"         {  echo(); return new Symbol(ParserSym.ADD); }
"-"         {  echo(); return new Symbol(ParserSym.SUB); }
"*"         {  echo(); return new Symbol(ParserSym.MUL);  }
"/"         {  echo(); return new Symbol(ParserSym.DIV);  }
"("         {  echo(); return new Symbol(ParserSym.PO);   }
")"         {  echo(); return new Symbol(ParserSym.PF);   }
";"         {  echo(); return new Symbol(ParserSym.PV);   }
"="         {  echo(); return new Symbol(ParserSym.EGAL); }



","         {  echo(); return new Symbol(ParserSym.VIRG); }
"{"         {  echo(); return new Symbol(ParserSym.ACCO); }
"}"         {  echo(); return new Symbol(ParserSym.ACCF); }
"int"       {  echo(); return new Symbol(ParserSym.INT,new String(yytext())); }
"void"      {  echo(); return new Symbol(ParserSym.VOID,new String(yytext())); }
"return"    {  echo(); return new Symbol(ParserSym.RETURN,yytext()); }


"while"                 {  echo(); return new Symbol(ParserSym.WHILE,yytext()); }
"if"                    {  echo(); return new Symbol(ParserSym.IF,yytext()); }
"else"                  {  echo(); return new Symbol(ParserSym.ELSE,yytext()); }
"not"                   {  echo(); return new Symbol(ParserSym.NOT,yytext()); }
{BOOLEEN}               {  echo(); return new Symbol(ParserSym.BOOLEEN, yytext()); }
{OPERATEURCOMPARAISON}  {  echo(); return new Symbol(ParserSym.OPERATEURCOMPARAISON, yytext()); }



"input"     {  echo(); return new Symbol(ParserSym.READ,yytext()); }
"write"     {  echo(); return new Symbol(ParserSym.WRITE,yytext()); }


{NUM}       { echo(); return new Symbol(ParserSym.NUM, new Integer(yytext()));}
{IDF}       { echo(); return new Symbol(ParserSym.IDF, new String(yytext()));}
{SEP}       { echo();  }
{COM}       { echo();  }
