package by.home.acs.language;

import by.home.acs.language.psi.ACSScriptTokenType;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

%%
%public
%class ACSScriptLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%eof{
return;
%eof}

CRLF = \R
IDENTIFIER= [a-zA-Z_][a-zA-Z0-9_]*
STRING= \"([^\\\"]|\\.)*\"
CHARACTER = (\')([^\\'\n]|(\\n) | (\\t) | (\\0) | (\\{2}) | (\\u[0-9]{4}))(\')
NUMBER = -?[0-9]+
WHITE_SPACE=[ \t\n\x0B\f\r]+
END_LINE_COMMENT=("//")[^\r\n]*
MULTIPLE_LINE_COMMENT="/*"( [^*] | (\*+[^*/]) )*\*+\/
FLOAT = -?\d+(\.\d+)?
EQUALS_SYMBOL = "="
DOT_SYMBOL = "."
COMMA_SYMBOL = ","
OPEN_BRACE =  "{"
CLOSE_BRACE = "}"
OPEN_BRACKET = "("
CLOSE_BRACKET = ")"
OPEN_SQUARE_BRACKET = "["
CLOSE_SQUARE_BRACKET = "]"
POUND_SYMBOL = "#"
SEMICOLON_SYMBOL = ";"
COLON_SYMBOL = ":"
LITERAL = [a-zA-Z]+
FIRST_VALUE_CHARACTER=[^ \s] | "\\"{CRLF} | "\\".    //remove this
VALUE_CHARACTER=[^\s] | "\\"{CRLF} | "\\".           //remove this
FUNCTION = "function"
VOID = "void"
INT = "int"
STR = "str"
BOOL = "bool"


%states WAITING_VALUE, TEST_ONE_VALUE
%xstate TEST_VALUE
%%
  "include"             { return ACSScriptTypes.INCLUDE;}
  "import"              { return ACSScriptTypes.IMPORT;}
  "define"              { return ACSScriptTypes.DEFINE;}
  "library"             { return ACSScriptTypes.LIBRARY;}
  "global"              { return ACSScriptTypes.GLOBAL;}
  "static"              { return ACSScriptTypes.STATIC;}
  "world"               { return ACSScriptTypes.WORLD;}
  "Script" | "script"   { return ACSScriptTypes.SCRIPT_IDENTIFIER;}
      {VOID}                                                    {yybegin(YYINITIAL); return ACSScriptTypes.VOID_TYPE;}
      {BOOL}                                                    {yybegin(YYINITIAL); return ACSScriptTypes.BOOL_TYPE;}
      {INT}                                                     {yybegin(YYINITIAL); return ACSScriptTypes.INT_TYPE;}
      {STR}                                                     {yybegin(YYINITIAL); return ACSScriptTypes.STRING_TYPE;}
  {FUNCTION}+            {yybegin(WAITING_VALUE);  return ACSScriptTypes.FUNCTION_IDENTIFIER;}
  <WAITING_VALUE>{WHITE_SPACE}+                                 {yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }
  <WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*     {yybegin(YYINITIAL); return ACSScriptTypes.FUNCTION_RETURN_TYPE;}
    ({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }


  //"void"                { return ACSScriptTypes.VOID_TYPE;}
 // "int"                 { return ACSScriptTypes.INT_TYPE; }
 // "str"                 { return ACSScriptTypes.STRING_TYPE;}
  //"bool"                { return ACSScriptTypes.BOOL_TYPE;}
  "OPEN"                { return ACSScriptTypes.OPEN;}
  "ENTER"               { return ACSScriptTypes.ENTER;}
  "RETURN"              { return ACSScriptTypes.RETURN;}
  "RESPAWN"             { return ACSScriptTypes.RESPAWN;}
  "DEATH"               { return ACSScriptTypes.DEATH;}
  "LIGHTNING"           { return ACSScriptTypes.LIGHTNING;}
  "UNLOADING"           { return ACSScriptTypes.UNLOADING;}
  "DISCONNECT"          { return ACSScriptTypes.DISCONNECT;}
  "KILL"                { return ACSScriptTypes.KILL;}
  "REOPEN"              { return ACSScriptTypes.REOPEN;}
  "net" | "NET"         { return ACSScriptTypes.NET;}
  "true"                { return ACSScriptTypes.TRUE;}
  "false"               { return ACSScriptTypes.FALSE;}
  "switch"              { return ACSScriptTypes.SWITCH;}
  "case"                { return ACSScriptTypes.CASE;}
  "for"                 { return ACSScriptTypes.FOR;}
  "while"               { return ACSScriptTypes.WHILE;}
  "until"               { return ACSScriptTypes.UNTIL;}
  "do"                  { return ACSScriptTypes.DO;}
  "break"               { return ACSScriptTypes.BREAK;}
  "default"             { return ACSScriptTypes.DEFAULT;}
  "if"                  {  return ACSScriptTypes.IF;}
  "else"                { return ACSScriptTypes.ELSE;}
  "return"              { return ACSScriptTypes.RETURN;}

  {IDENTIFIER}          { return ACSScriptTypes.IDENTIFIER; }
  //{WHITE_SPACE}         { return TokenType.WHITE_SPACE; }
  //{VOID}                { return ACSScriptTypes.VOID_TYPE;} not working tto highlight
  {END_LINE_COMMENT}    { return ACSScriptTypes.COMMENT;}
  {MULTIPLE_LINE_COMMENT}   {return ACSScriptTypes.COMMENT;}
  {NUMBER}              { return ACSScriptTypes.NUMBER;}
  {STRING}              { return ACSScriptTypes.STRING;}
  {CHARACTER}           { return ACSScriptTypes.CHARACTER;}
  {FLOAT}               { return ACSScriptTypes.FLOAT;}
  {EQUALS_SYMBOL}       { return ACSScriptTypes.EQUALS_SYMBOL;}
  {DOT_SYMBOL}          { return ACSScriptTypes.DOT_SYMBOL;}
  {COMMA_SYMBOL}        { return ACSScriptTypes.COMMA_SYMBOL;}
  {OPEN_BRACE}          { return ACSScriptTypes.OPEN_BRACE;}
  {CLOSE_BRACE}         { return ACSScriptTypes.CLOSE_BRACE;}
  {OPEN_BRACKET}        { return ACSScriptTypes.OPEN_BRACKET;}
  {CLOSE_BRACKET}       { return ACSScriptTypes.CLOSE_BRACKET;}
  {OPEN_SQUARE_BRACKET} { return ACSScriptTypes.OPEN_SQUARE_BRACKET;}
  {CLOSE_SQUARE_BRACKET} { return ACSScriptTypes.CLOSE_SQUARE_BRACKET;}
  {POUND_SYMBOL}        {return ACSScriptTypes.POUND_SYMBOL;}
  {SEMICOLON_SYMBOL}    {return ACSScriptTypes.SEMICOLON_SYMBOL;}
  {COLON_SYMBOL}        {return ACSScriptTypes.COLON_SYMBOL;}


// If the character sequence does not match any of the above rules, we return BAD_CHARACTER which indicates that
// there is an error in the character sequence. This is used to highlight errors.
[^] { return TokenType.BAD_CHARACTER; }