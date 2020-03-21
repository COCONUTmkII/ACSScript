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

IDENTIFIER= [a-zA-Z_][a-zA-Z0-9_]*
STRING= \"([^\\\"]|\\.)*\"
CHARACTER = (\')([^\\'\n]|(\\n) | (\\t) | (\\0) | (\\{2}) | (\\u[0-9]{4}))(\')
NUMBER = -?[0-9]+
WHITE_SPACE=[ \t\n\x0B\f\r]+
END_LINE_COMMENT=("//")[^\r\n]*
MULTIPLE_LINE_COMMENT="/*"( [^*] | (\*+[^*/]) )*\*+\/
FLOAT = -?\d+(\.\d+)?

%%
<YYINITIAL> {
  "include"           { return ACSScriptTypes.INCLUDE;}
  "import"            { return ACSScriptTypes.IMPORT;}
  "define"            { return ACSScriptTypes.DEFINE;}
  "library"           { return ACSScriptTypes.LIBRARY;}
  "global"            { return ACSScriptTypes.GLOBAL;}
  "static"            { return ACSScriptTypes.STATIC;}
  "world"             { return ACSScriptTypes.WORLD;}
  "Script" | "script" { return ACSScriptTypes.SCRIPT;}
  "function"          { return ACSScriptTypes.FUNCTION;}
  "void"              { return ACSScriptTypes.VOID;}
  "int"               { return ACSScriptTypes.INT; }
  "str"               { return ACSScriptTypes.STR; }
  "bool"              { return ACSScriptTypes.BOOL;}
  "OPEN"              { return ACSScriptTypes.OPEN;}
  "ENTER"             { return ACSScriptTypes.ENTER;}
  "RETURN"            { return ACSScriptTypes.RETURN;}
  "RESPAWN"           { return ACSScriptTypes.RESPAWN;}
  "DEATH"             { return ACSScriptTypes.DEATH;}
  "LIGHTNING"         { return ACSScriptTypes.LIGHTNING;}
  "UNLOADING"         { return ACSScriptTypes.UNLOADING;}
  "DISCONNECT"        { return ACSScriptTypes.DISCONNECT;}
  "KILL"              { return ACSScriptTypes.KILL;}
  "REOPEN"            { return ACSScriptTypes.REOPEN;}
  "net" | "NET"       { return ACSScriptTypes.NET;}
  "true"              { return ACSScriptTypes.TRUE;}
  "false"             { return ACSScriptTypes.FALSE;}
  "switch"            { return ACSScriptTypes.SWITCH;}
  "case"              { return ACSScriptTypes.CASE;}
  "for"               { return ACSScriptTypes.FOR;}
  "while"             { return ACSScriptTypes.WHILE;}
  "until"             { return ACSScriptTypes.UNTIL;}
  "do"                { return ACSScriptTypes.DO;}
  "break"             { return ACSScriptTypes.BREAK;}
  "default"           { return ACSScriptTypes.DEFAULT;}
  "if"                {  return ACSScriptTypes.IF;}
  "else"              { return ACSScriptTypes.ELSE;}
  "return"            { return ACSScriptTypes.RETURN;}

  {IDENTIFIER}        { return ACSScriptTypes.IDENTIFIER; }
  {WHITE_SPACE}       { return TokenType.WHITE_SPACE; }
  {END_LINE_COMMENT}  { return ACSScriptTypes.COMMENT;}
  {MULTIPLE_LINE_COMMENT}   {return ACSScriptTypes.COMMENT;}
  {NUMBER}            { return ACSScriptTypes.NUMBER;}
  {STRING}            { return ACSScriptTypes.STRING;}
  {CHARACTER}         { return ACSScriptTypes.CHARACTER;}
  {FLOAT}             { return ACSScriptTypes.FLOAT;}
}

// If the character sequence does not match any of the above rules, we return BAD_CHARACTER which indicates that
// there is an error in the character sequence. This is used to highlight errors.
[^] { return TokenType.BAD_CHARACTER; }
