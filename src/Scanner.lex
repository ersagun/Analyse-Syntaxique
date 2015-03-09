/* auteur : ersagun.yalcintepe@etu.univ-lorraine.fr - julien.remy@etu.univ-lorraine.fr */
/* (c) 2015 */


package fr.ul.miage.exemple.generated;
import java_cup.runtime.Symbol;
import java.lang.StringBuffer;

%%

/* options */
%line
%public
%cupsym ParserSym
%cup
/*%debug*/

/* macros */
SEPARATEUR     = [ \t]+
NUM     =   [0-9]+
DECAL   =   ("+"|"-")[0-9]{4}
FIN     =   "\n"|"\r\n"
IP 		=   ([0-9]{1,3}\.){3}[0-9]{1,3}  
ACTION  =   "\""([^\"]|"\\\"")*"\""
TIRET   =   " - - "  

%%

/* regles */


{IP}   		{ return new Symbol(ParserSym.IP, new String(yytext()));}
{ACTION}    { return new Symbol(ParserSym.ACTION);}
{TIRET}     { return new Symbol(ParserSym.TIRET);}
"\r"		{ return new Symbol(ParserSym.EOF);}
"Jan"		{ return new Symbol(ParserSym.JAN);}
"Feb"		{ return new Symbol(ParserSym.FEV);}
"Mar"		{ return new Symbol(ParserSym.MAR);}
"Apr"		{ return new Symbol(ParserSym.AVR);}
"May"		{ return new Symbol(ParserSym.MAI);}
"Jun"		{ return new Symbol(ParserSym.JUIN);}
"Jul"		{ return new Symbol(ParserSym.JUIL);}
"Aug"		{ return new Symbol(ParserSym.AOU);}
"Sep"		{ return new Symbol(ParserSym.SEP);}
"Oct"		{ return new Symbol(ParserSym.OCT);}
"Nov"		{ return new Symbol(ParserSym.NOV);}
"Dec"		{ return new Symbol(ParserSym.DEC);}
":"         { return new Symbol(ParserSym.DP);}
"/"         { return new Symbol(ParserSym.SL);}
"["         { return new Symbol(ParserSym.CO);}
"]"         { return new Symbol(ParserSym.CF);}
{DECAL}     { return new Symbol(ParserSym.DECAL,new Integer(yytext()));}
{NUM}       { return new Symbol(ParserSym.NUM, new Integer(yytext()));}
/*{END}  		{System.out.println("");}*/
{SEPARATEUR}      {;}
{FIN}		{ return new Symbol(ParserSym.FIN);}
.			{ return null;}
