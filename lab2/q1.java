import java.io.*;
class Main
  	{
	public static void main(String args[]) throws IOException
		{
		one lex = new one(System.in);
		Token token = lex.yylex();
		while(token.text != null)
			{
			token = lex.yylex();
			}
		}
	}
class Token
	{
	String text;
	Token (String t) {text = t;}
	}
%%
%public
%class one
%type void
%eofval{
	return new Token(null);
%eofval}
%type Token

DIGIT=[0-9]
LETTER=[a-zA-Z]
NEWLINE=[\n]

%%
\"({LETTER}|{DIGIT})*\"		{System.out.println("String - "+yytext());}
{DIGIT}+							{System.out.println("Integer - "+yytext());}
{DIGIT}+\.{DIGIT}+					{System.out.println("Float - "+yytext());}
{NEWLINE}+ {System.out.print("");}
