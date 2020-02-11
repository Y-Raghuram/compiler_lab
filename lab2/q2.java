import java.io.*;
class Main{
	public static void main(String args[]) throws IOException{
		q2 lex = new q2(new FileReader("input.txt"));
		Token token = lex.yylex();
		while(token.text !=null){
			token = lex.yylex();
		}
	}
}

class Token{
	String text;
	Token(String t){
		text=t;
	}
}
%%
%public
%class q2
%type void

%type Token
%eofval{
return new Token(null);
%eofval}

digit = [0-9]
letter =[a-zA-Z]
special = [!@#$%^&*()_+]
whitespace = [\t\n\r]

%% 
whitespace {System.out.print("");}
main|var {System.out.println("Keyword "+yytext());}
integer|char|string|float {System.out.println("Data types "+yytext());}
if {System.out.println("If "+yytext());}
then {System.out.println("then "+yytext());}
else {System.out.println("else "+yytext());}
for {System.out.println("for "+yytext());}
while {System.out.println("while "+yytext());}
input {System.out.println("Input Function "+yytext());}
output {System.out.println("Output Function "+yytext());}
\"({letter}|{digit}|{special})*\" {System.out.println("String "+yytext());}
{letter}({letter}|{digit})* {System.out.println("Identifier "+yytext());}
\+|-|\*|\/ {System.out.println("Arithmetic Operators "+yytext());}
[\n] {System.out.print("");}
&&|\|\||!==|>|<|>=|<=|== {System.out.println("Logical Operators "+yytext());}
\{	{System.out.println("Left Curly Braces "+yytext());}
\} {System.out.println("Right Curly Braces "+yytext());}
\( {System.out.println("Left Parenthesis "+yytext());}
\) {System.out.println("Right Parenthesis "+yytext());}
= {System.out.println("Assigment Operator "+yytext());}
;|, {System.out.print("");}
" " {System.out.print("");}
