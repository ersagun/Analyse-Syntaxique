/* auteur : ersagun.yalcintepe@etu.univ-lorraine.fr */
/* (c) 2015 */


package fr.ul.miage.exemple.generated;
import java_cup.runtime.Symbol;

%%

/* options */
%line
%public
%cupsym ParserSym
%cup
%debug

/* macros */
SEPARATEUR     	= [ \t]+ /*espace*/
CONSTANT		= [0-9]+
PO				= "("
PF				= ")"
AO				= "{"
AF				= "}"
IF				= "if"
WHILE			= "while"
FOR				= "for"
RETURN			= "return"
IDENTIFICATEUR 	= ".*"  
COMMENTAIRES 	= "/\*.+?\*/"
VOID			= "void"
INT 			= "int"
AFFECTATION		="="
PV				=";"
FINLIGNE     		="\n"|"\r\n"
CMPSUP			="<"
CMPINF			=">"
ELSE			="else"
VIRGULE			=","
DIV				="/"
SUB				="-"
MUL				="*"
ADD				="+"
%%

/* regles */
{INT}				{ return new Symbol(ParserSym.INT);}
{CONSTANT}  		{ return new Symbol(ParserSym.CONSTANT, new Integer(yytext()));}
{VOID}				{ return new Symbol(ParserSym.VOID);}
{PO} 	    		{ return new Symbol(ParserSym.PO);}
{PF}				{ return new Symbol(ParserSym.PF);}
{AO}         		{ return new Symbol(ParserSym.AO);}
{AF}         		{ return new Symbol(ParserSym.AF);}
{IF}       			{ return new Symbol(ParserSym.IF);}
{WHILE}       		{ return new Symbol(ParserSym.WHILE);}
{FOR}       		{ return new Symbol(ParserSym.FOR);}
{RETURN}       		{ return new Symbol(ParserSym.RETURN);}
{IDENTIFICATEUR}	{ return new Symbol(ParserSym.IDENTIFICATEUR,new Integer(yytext()));}
{CMPINF}			{ return new Symbol(ParserSym.CMPINF);}
{CMPSUP}			{ return new Symbol(ParserSym.CMPSUP);} 
{COMMENTAIRES}      {;}
{AFFECTATION}     	{ return new Symbol(ParserSym.AFFECTATION);}
{PV}		     	{ return new Symbol(ParserSym.PV);}
{FINLIGNE}			{ return new Symbol(ParserSym.FINLIGNE);}
{VIRGULE} 			{ return new Symbol(ParserSym.VIRGULE);}
{DIV}				{ return new Symbol(ParserSym.DIV);}
{SUB}				{ return new Symbol(ParserSym.SUB);}
{MUL}				{ return new Symbol(ParserSym.MUL);}
{ADD}				{ return new Symbol(ParserSym.ADD);}
{SEPARATEUR}		{ return new Symbol(ParserSym.ADD);}
{ELSE}				{ return new Symbol(ParserSym.ADD);}
.					{ return null;}
