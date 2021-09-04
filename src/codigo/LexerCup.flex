package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Palabras reservadas */
( START ) {return new Symbol(sym.ST, yychar, yyline, "start");}
( CHECKLEVEL ) {return new Symbol(sym.CL, yychar, yyline, yytext());}
( ALERT ) {return new Symbol(sym.AL, yychar, yyline, yytext());}
( CHECKHUM ) {return new Symbol(sym.CH, yychar, yyline, yytext());}
( CHECKPH ) {return new Symbol(sym.CPH, yychar, yyline, yytext());}
( NEEDWATER ) {return new Symbol(sym.NW, yychar, yyline, yytext());}
( WATERPLANTS ) {return new Symbol(sym.WP, yychar, yyline, yytext());}
( FILLTANKS ) {return new Symbol(sym.FT, yychar, yyline, yytext());}
( END ) {return new Symbol(sym.EN, yychar, yyline, yytext());}

/* Otros simbolos */
{espacio} {/*Ignore*/}
("*") {return new Symbol(sym.at, yychar, yyline, yytext());}
("+") {return new Symbol(sym.ms, yychar, yyline, yytext());}
(";") {return new Symbol(sym.ptc, yychar, yyline, yytext());}

/* Salto de linea */
( "\n" ) {return new Symbol(sym.et, yychar, yyline, yytext());}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

("=") {return new Symbol(sym.ig, yychar, yyline, yytext());}
(",") {return new Symbol(sym.cm, yychar, yyline, yytext());}
("%") {return new Symbol(sym.pj, yychar, yyline, yytext());}
(">=") {return new Symbol(sym.mai, yychar, yyline, yytext());}
("<=") {return new Symbol(sym.mei, yychar, yyline, yytext());}
("=!") {return new Symbol(sym.df, yychar, yyline, yytext());}
sw {return new Symbol(sym.sw, yychar, yyline, yytext());}
vl {return new Symbol(sym.vl, yychar, yyline, yytext());}
h {return new Symbol(sym.h, yychar, yyline, yytext());}
ph {return new Symbol(sym.ph, yychar, yyline, yytext());}
( if ) {return new Symbol(sym.If, yychar, yyline, yytext());}
( else ) {return new Symbol(sym.Else, yychar, yyline, yytext());}
or {return new Symbol(sym.or, yychar, yyline, yytext());}
\( {return new Symbol(sym.pa, yychar, yyline, yytext());}
\) {return new Symbol(sym.pc, yychar, yyline, yytext());}
&& {return new Symbol(sym.and, yychar, yyline, yytext());}
{D} {return new Symbol(sym.num, yychar, yyline, yytext());}
bi {return new Symbol(sym.bi, yychar, yyline, yytext());}

. {return new Symbol(sym.ERROR, yychar, yyline, yytext());}