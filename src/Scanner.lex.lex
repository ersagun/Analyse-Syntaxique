/*
 * analyseur lexical  du :
 * Projet interpreteur
 * 
 *
 *
 * (c) 2015
 */

package analyse.generated;
import java_cup.runtime.Symbol;
import exception.*;

%%
/* options */

%line
%column

%class AnalyseurLexical
%public

%cupsym Sym
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

"+"         {  echo(); return new Symbol(Sym.ADD); }
"-"         {  echo(); return new Symbol(Sym.SUB); }
"*"         {  echo(); return new Symbol(Sym.MUL);  }
"/"         {  echo(); return new Symbol(Sym.DIV);  }
"("         {  echo(); return new Symbol(Sym.PO);   }
")"         {  echo(); return new Symbol(Sym.PF);   }
";"         {  echo(); return new Symbol(Sym.PV);   }
"="         {  echo(); return new Symbol(Sym.EGAL); }



","         {  echo(); return new Symbol(Sym.VIRG); }
"{"         {  echo(); return new Symbol(Sym.ACCO); }
"}"         {  echo(); return new Symbol(Sym.ACCF); }
"int"       {  echo(); return new Symbol(Sym.INT,yytext()); }
"void"      {  echo(); return new Symbol(Sym.VOID,yytext()); }
"return"    {  echo(); return new Symbol(Sym.RETURN,yytext()); }


"while"                 {  echo(); return new Symbol(Sym.WHILE,yytext()); }
"if"                    {  echo(); return new Symbol(Sym.IF,yytext()); }
"else"                  {  echo(); return new Symbol(Sym.ELSE,yytext()); }
"not"                   {  echo(); return new Symbol(Sym.NOT,yytext()); }
{BOOLEEN}               {  echo(); return new Symbol(Sym.BOOLEEN, yytext()); }
{OPERATEURCOMPARAISON}  {  echo(); return new Symbol(Sym.OPERATEURCOMPARAISON, yytext()); }



"input"     {  echo(); return new Symbol(Sym.READ,yytext()); }
"write"     {  echo(); return new Symbol(Sym.WRITE,yytext()); }


{NUM}       { echo(); return new Symbol(Sym.NUM, new Integer(yytext()));}
{IDF}       { echo(); return new Symbol(Sym.IDF, yytext());}
{SEP}       { echo();  }
{COM}       { echo();  }
