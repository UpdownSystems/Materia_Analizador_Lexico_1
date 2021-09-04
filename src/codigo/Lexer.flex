package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%

/* Palabras reservadas */
( START )       {lexeme = yytext(); return ST; }
( CHECKLEVEL )  {lexeme = yytext(); return CL; }
( ALERT )       {lexeme = yytext(); return AL; }
( CHECKHUM )    {lexeme = yytext(); return CH; }
( CHECKPH )     {lexeme = yytext(); return CPH; }
( NEEDWATER )   {lexeme = yytext(); return NW; }
( WATERPLANTS ) {lexeme = yytext(); return WP; }
( FILLTANKS )   {lexeme = yytext(); return FT; }
( END )         {lexeme = yytext(); return EN; }

/* Otros simbolos */
{espacio}       {/*Ignore*/}
("*")           {lexeme = yytext(); return at;}
("+")           {lexeme = yytext(); return ms;}
(";")           {lexeme = yytext(); return ptc;}

/* Salto de linea */
( "\n" )        {lexeme = yytext(); return et;}

/* Comentarios */
( "//"(.)* )    {/*Ignore*/}

("=")           {lexeme = yytext(); return ig;}
(",")           {lexeme = yytext(); return cm;}
("%")           {lexeme = yytext(); return pj;}
(">=")          {lexeme = yytext(); return mai;}
("<=")          {lexeme = yytext(); return mei;}
("=!")          {lexeme = yytext(); return df;}
sw              {lexeme = yytext(); return sw;}
vl              {lexeme = yytext(); return vl;}
h               {lexeme = yytext(); return h;}
ph              {lexeme = yytext(); return ph;}
if              {lexeme = yytext(); return If;}
else            {lexeme = yytext(); return Else;}
or              {lexeme = yytext(); return or;}
\(              {lexeme = yytext(); return pa;}
\)              {lexeme = yytext(); return pc;}
&&              {lexeme = yytext(); return and;}
{D}             {lexeme = yytext(); return num;}
bi              {lexeme = yytext(); return bi;}

.               {lexeme = yytext(); return ERROR;}