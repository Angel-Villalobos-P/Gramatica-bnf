import java_cup.runtime.Symbol;

%%
%class LecerCup
%type java_cup.runtime.Symbol
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol simbolo(int tipo, Object valor){
      return new Symbol(tipo, yyline, yycolumn, valor);
    }
    private Symbol simbolo(int tipo){
          return new Symbol(tipo, yyline, yycolumn);
    }
%}
%%

{espacio} {}            // Espacios en blanco
( "//"(.)* ) {}         // Comentario
 . {return ERROR;}      // Error de análisis

int {return new Symbol(sym.Int, yychar, yyline, yytext());}
float {return new Symbol(sym.Float, yychar, yyline, yytext());}
bool {return new Symbol(sym.Bool, yychar, yyline, yytext());}
char {return new Symbol(sym.Char, yychar, yyline, yytext());}
string {return new Symbol(sym.String, yychar, yyline, yytext());}
array {return new Symbol(sym.Array, yychar, yyline, yytext());}
null {return new Symbol(sym.Null, yychar, yyline, yytext());}

if {return new Symbol(sym.If, yychar, yyline, yytext());}
else {return new Symbol(sym.Else, yychar, yyline, yytext());}
while {return new Symbol(sym.While, yychar, yyline, yytext());}
switch {return new Symbol(sym.Switch, yychar, yyline, yytext());}
case {return new Symbol(sym.Case, yychar, yyline, yytext());}
print {return new Symbol(sym.Print, yychar, yyline, yytext());}
return {return new Symbol(sym.Return, yychar, yyline, yytext());}
main {return new Symbol(sym.Main, yychar, yyline, yytext());}

"#" {return new Symbol(sym.Numeral, yychar, yyline, yytext());}

"=" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"~" {return new Symbol(sym.Modulo, yychar, yyline, yytext());}
"^" {return new Symbol(sym.Potencia, yychar, yyline, yytext());}
"(" {return new Symbol(sym.Parentesis_apertura, yychar, yyline, yytext());}
")" {return new Symbol(sym.Parentesis_cierre, yychar, yyline, yytext());}
"{" {return new Symbol(sym.Llave_apertura, yychar, yyline, yytext());}
"}" {return new Symbol(sym.Llave_cierre, yychar, yyline, yytext());}
"[" {return new Symbol(sym.Corchete_apertura, yychar, yyline, yytext());}
"]" {return new Symbol(sym.Corchete_cierre, yychar, yyline, yytext());}
"\"" {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

"++" {return new Symbol(sym.Op_Incremento, yychar, yyline, yytext());}
"--" {return new Symbol(sym.Op_Decremento, yychar, yyline, yytext());}
("<" | "<=" | ">=" | ">" | "==" | "!=") {return new Symbol(sym.Op_Relacional, yychar, yyline, yytext());}
( "&&" | "||" | "&" | "|" | "!") {return new Symbol(sym.Op_Logico, yychar, yyline, yytext());}
(true | false) {return new Symbol(sym.Op_Booleano, yychar, yyline, yytext());}

{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}