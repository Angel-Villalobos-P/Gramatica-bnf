package codigo;

import static codigo.Tokens.*;

%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexema;
%}
%%

{espacio} {}            // Espacios en blanco
( "//"(.)* ) {}         // Comentario
"\n" {return Linea;}    // Salto de linea
 . {return ERROR;}      // Error de análisis

int {lexema = yytext(); return Int;}
float {lexema = yytext(); return Float;}
bool {lexema = yytext(); return Bool;}
char {lexema = yytext(); return Char;}
string {lexema = yytext(); return String;}
array {lexema = yytext(); return Array;}
null {lexema = yytext(); return Null;}

if {lexema = yytext(); return If;}
else {lexema = yytext(); return Else;}
while {lexema = yytext(); return While;}
switch {lexema = yytext(); return Switch;}
case {lexema = yytext(); return Case;}
print {lexema = yytext(); return Print;}
return {lexema = yytext(); return Return;}
main {lexema = yytext(); return Main;}

"#" {lexema = yytext(); return Numeral;}

"=" {lexema = yytext(); return Igual;}
"+" {lexema = yytext(); return Suma;}
"-" {lexema = yytext(); return Resta;}
"/" {lexema = yytext(); return Division;}
"*" {lexema = yytext(); return Multiplicacion;}
"~" {lexema = yytext(); return Modulo;}
"^" {lexema = yytext(); return Potencia;}
"(" {lexema = yytext(); return Parentesis_apertura;}
")" {lexema = yytext(); return Parentesis_cierre;}
"{" {lexema = yytext(); return Llave_apertura;}
"}" {lexema = yytext(); return Llave_cierre;}
"[" {lexema = yytext(); return Corchete_apertura;}
"]" {lexema = yytext(); return Corchete_cierre;}
"\"" {lexema = yytext(); return Comillas;}

"++" {lexema = yytext(); return Op_Incremento;}
"--" {lexema = yytext(); return Op_Decremento;}
("<" | "<=" | ">=" | ">" | "==" | "!=") {lexema = yytext(); return Op_Relacional;}
( "&&" | "||" | "&" | "|" | "!") {lexema = yytext(); return Op_Logico;}
(true | false) {lexema = yytext(); return Op_Booleano;}

{L}({L}|{D})* {lexema = yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexema = yytext(); return Numero;}