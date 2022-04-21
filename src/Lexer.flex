import static Tokens.*;

%%
%class Lexer
%type Tokens

%{
    public String lexema;
%}

%%

/* Comillas */
( "\"" ) {lexeme=yytext(); return Comillas;}

( int | char | long | float | double ) {lexeme=yytext(); return T_dato;}

(int) {lexema=yytext(); return Int;}
(float) {lexema=yytext(); return Float;}
(boolean) {lexema=yytext(); return Bool;}
(char) {lexema=yytext(); return Char;}
(String) {lexema=yytext(); return String;}
(null) {lexema=yytext(); return Null;}
(if) {lexema=yytext(); return If;}
(else) {lexema=yytext(); return Else;}
(while) {lexema=yytext(); return While;}
(switch) {lexema=yylex(); return Switch;}


