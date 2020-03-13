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
INTEGER= -(([0-9]{1,9}|1[0-9]{9}|2(0[0-9]{8}|1([0-3][0-9]{7}|4([0-6][0-9]{6}|7([0-3][0-9]{5}|4([0-7][0-9]{4}|8([0-2][0-9]{3}|3([0-5][0-9]{2}|6([0-3][0-9]|4[0-7]))))))))) | ([0-9]{1,9}|1[0-9]{9}|2(0[0-9]{8}|1([0-3][0-9]{7}|4([0-6][0-9]{6}|7([0-3][0-9]{5}|4([0-7][0-9]{4}|8([0-2][0-9]{3}|3([0-5][0-9]{2}|6([0-3][0-9]|4[0-8]))))))))))
NUMBER= [1-9][0-9]+*


STRING= \"(.[^\"]*)\"

// If some character sequence is matched to this regex, it will be treated as a WHITE_SPACE.
WHITE_SPACE=[ \t\n\x0B\f\r]+
END_LINE_COMMENT=("//")[^\r\n]*
MULTIPLE_LINE_COMMENT="/*"( [^*] | (\*+[^*/]) )*\*+\/
// Initial state. We can specify mutiple states for more complex grammars. This corresponds to `modes` in ANTLR grammar.
%%
<YYINITIAL> {
  // In here, we match keywords. So if a keyword is found, this returns a token which corresponds to that keyword.
  // These tokens are generated using the `Ballerina.bnf` file and located in the ACSScruptTypes `class`.
  // These tokens are Parser uses these return values to match token squence to a parser rule.
  "include"          { return ACSScriptTypes.INCLUDE;}
  "import"           { return ACSScriptTypes.IMPORT;}
  "define"           { return ACSScriptTypes.DEFINE;}
  "library"          { return ACSScriptTypes.LIBRARY;}
  "global"           { return ACSScriptTypes.GLOBAL;}
  "static"           { return ACSScriptTypes.STATIC;}
  "world"            { return ACSScriptTypes.WORLD;}
  "Script"           { return ACSScriptTypes.SCRIPT;}
  "function"         { return ACSScriptTypes.FUNCTION;}
  "void"             { return ACSScriptTypes.VOID;}
  "int"              { return ACSScriptTypes.INT; }
  "str"              { return ACSScriptTypes.STR; }
  "bool"             { return ACSScriptTypes.BOOL;}
  "OPEN"             { return ACSScriptTypes.OPEN;}
  "ENTER"            { return ACSScriptTypes.ENTER;}
  "RETURN"           { return ACSScriptTypes.RETURN;}
  "RESPAWN"          { return ACSScriptTypes.RESPAWN;}
  "DEATH"            { return ACSScriptTypes.DEATH;}
  "LIGHTNING"        { return ACSScriptTypes.LIGHTNING;}
  "UNLOADING"        { return ACSScriptTypes.UNLOADING;}
  "DISCONNECT"       { return ACSScriptTypes.DISCONNECT;}
  "KILL"             { return ACSScriptTypes.KILL;}
  "REOPEN"           { return ACSScriptTypes.REOPEN;}
  "net"              { return ACSScriptTypes.NET;}
  "true"             { return ACSScriptTypes.TRUE;}
  "false"            { return ACSScriptTypes.FALSE;}
  "switch"           { return ACSScriptTypes.SWITCH;}
  "case"             { return ACSScriptTypes.CASE;}
  "for"              { return ACSScriptTypes.FOR;}
  "while"            { return ACSScriptTypes.WHILE;}
  "until"            { return ACSScriptTypes.UNTIL;}
  "do"               { return ACSScriptTypes.DO;}
  "break"            { return ACSScriptTypes.BREAK;}
  "default"          { return ACSScriptTypes.DEFAULT;}
  "if"               { return ACSScriptTypes.IF;}
  "else"             { return ACSScriptTypes.ELSE;}
  "return"           { return ACSScriptTypes.RETURN;}

  // In here, we check for character sequences which matches regular expressions which we defined above.
  {IDENTIFIER}       { return ACSScriptTypes.IDENTIFIER; } // This indicates that a character sequence which matches to the rule
                                            // identifier is encountered.
  {WHITE_SPACE}      { return TokenType.WHITE_SPACE; } // This indicates that a character sequence which matches to the rule
                                             // whitespace is encountered.
  {END_LINE_COMMENT} { return ACSScriptTypes.COMMENT;}
  {MULTIPLE_LINE_COMMENT}   {return ACSScriptTypes.COMMENT;}
  {NUMBER}           { return ACSScriptTypes.NUMBER;}
  {INTEGER}          { return ACSScriptTypes.INTEGER;}
  {STRING}           { return ACSScriptTypes.STRING;}

}

// If the character sequence does not match any of the above rules, we return BAD_CHARACTER which indicates that
// there is an error in the character sequence. This is used to highlight errors.
[^] { return TokenType.BAD_CHARACTER; }
