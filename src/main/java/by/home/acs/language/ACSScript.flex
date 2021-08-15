package by.home.acs.language;

import by.home.acs.language.psi.ACSScriptTokenType;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
%%

%{
  public ACSScriptLexer() {
    this((java.io.Reader)null);
  }
%}

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
NUMBER = (0[xX][0-9a-fA-F]+)|(-?[0-9]+)
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
SEMICOLON_SYMBOL = ";"
COLON_SYMBOL = ":"
%caseless
FUNCTION = "function"
SCRIPT = "script"
VOID = "void"
INT = "int"
STR = "str"
BOOL = "bool"
OPEN="OPEN"
ENTER="ENTER"
RETURN="RETURN"
RESPAWN="RESPAWN"
DEATH="DEATH"
LIGHTNING="LIGHTNING"
UNLOADING="UNLOADING"
DISCONNECT="DISCONNECT"
KILL="KILL"
REOPEN="REOPEN"
PICKUP="PICKUP"
REDRETURN="REDRETURN"
BLUERETURN="BLUERETURN"
WHITERETURN="WHITERETURN"
CLIENTSIDE="CLIENTSIDE"
NET="NET"

%states WAITING_VALUE, TEST_ONE_VALUE
%xstate TEST_VALUE
%%
  "#include"                                                 {yybegin(YYINITIAL); return ACSScriptTypes.INCLUDE_KEY;}
  "#import"                                                  {yybegin(YYINITIAL); return ACSScriptTypes.IMPORT_KEY;}
  "#define"                                                  {yybegin(YYINITIAL); return ACSScriptTypes.DEFINE_KEY;}
  "#library"                                                 {yybegin(YYINITIAL); return ACSScriptTypes.LIBRARY_KEY;}
  "global"                                                  {yybegin(YYINITIAL); return ACSScriptTypes.GLOBAL;}
  "static"                                                  {yybegin(YYINITIAL); return ACSScriptTypes.STATIC;}
  "world"                                                   {yybegin(YYINITIAL); return ACSScriptTypes.WORLD;}
  "special"                                                 {yybegin(YYINITIAL); return ACSScriptTypes.SPECIAL;}
  {OPEN_BRACKET}                                            {yybegin(YYINITIAL); return ACSScriptTypes.OPEN_BRACKET;}
  {CLOSE_BRACKET}                                           {yybegin(YYINITIAL); return ACSScriptTypes.CLOSE_BRACKET;}
  {OPEN_BRACE}                                              {yybegin(YYINITIAL); return ACSScriptTypes.OPEN_BRACE;}
  {CLOSE_BRACE}                                             {yybegin(YYINITIAL); return ACSScriptTypes.CLOSE_BRACE;}
  {VOID}                                                    {yybegin(YYINITIAL); return ACSScriptTypes.VOID;}
  {BOOL}                                                    {yybegin(YYINITIAL); return ACSScriptTypes.BOOL;}
  {INT}                                                     {yybegin(YYINITIAL); return ACSScriptTypes.INT;}
  {STR}                                                     {yybegin(YYINITIAL); return ACSScriptTypes.STR;}
  {FUNCTION}                                                {yybegin(YYINITIAL);  return ACSScriptTypes.FUNCTION;}
  {SCRIPT}                                                  {yybegin(YYINITIAL); return ACSScriptTypes.SCRIPT;}
  ({CRLF}|{WHITE_SPACE})+                                   {yybegin(YYINITIAL); return TokenType.WHITE_SPACE;}
  "true"                                                    {yybegin(YYINITIAL); return ACSScriptTypes.TRUE;}
  "false"                                                   {yybegin(YYINITIAL); return ACSScriptTypes.FALSE;}
  "switch"                                                  {yybegin(YYINITIAL); return ACSScriptTypes.SWITCH;}
  "case"                                                    {yybegin(YYINITIAL); return ACSScriptTypes.CASE;}
  "for"                                                     {yybegin(YYINITIAL); return ACSScriptTypes.FOR;}
  "while"                                                   {yybegin(YYINITIAL); return ACSScriptTypes.WHILE;}
  "until"                                                   {yybegin(YYINITIAL); return ACSScriptTypes.UNTIL;}
  "do"                                                      {yybegin(YYINITIAL); return ACSScriptTypes.DO;}
  "break"                                                   {yybegin(YYINITIAL); return ACSScriptTypes.BREAK;}
  "default"                                                 {yybegin(YYINITIAL); return ACSScriptTypes.DEFAULT;}
  "if"                                                      {yybegin(YYINITIAL); return ACSScriptTypes.IF;}
  "else"                                                    {yybegin(YYINITIAL); return ACSScriptTypes.ELSE;}
  "return"                                                  {yybegin(YYINITIAL); return ACSScriptTypes.RETURN;}
  "terminate"                                               {yybegin(YYINITIAL); return ACSScriptTypes.TERMINATE;}

  {NUMBER}                                                  {yybegin(YYINITIAL); return ACSScriptTypes.NUMBER;}
  {STRING}                                                  {yybegin(YYINITIAL); return ACSScriptTypes.STRING;}
  {END_LINE_COMMENT}                                        {yybegin(YYINITIAL); return ACSScriptTypes.COMMENT;}
  {MULTIPLE_LINE_COMMENT}                                   {yybegin(YYINITIAL); return ACSScriptTypes.COMMENT;}
  {CHARACTER}                                               {yybegin(YYINITIAL); return ACSScriptTypes.CHARACTER;}
  {FLOAT}                                                   {yybegin(YYINITIAL); return ACSScriptTypes.FLOAT;}
  {EQUALS_SYMBOL}                                           {yybegin(YYINITIAL); return ACSScriptTypes.EQUALS;}
  {DOT_SYMBOL}                                              {yybegin(YYINITIAL); return ACSScriptTypes.DOT;}
  {COMMA_SYMBOL}                                            {yybegin(YYINITIAL); return ACSScriptTypes.COMMA;}
  {OPEN}                                                    {yybegin(YYINITIAL); return ACSScriptTypes.OPEN;}
  {ENTER}                                                   {yybegin(YYINITIAL); return ACSScriptTypes.ENTER;}
  {RETURN}                                                  {yybegin(YYINITIAL); return ACSScriptTypes.RETURN;}
  {RESPAWN}                                                 {yybegin(YYINITIAL); return ACSScriptTypes.RESPAWN;}
  {DEATH}                                                   {yybegin(YYINITIAL); return ACSScriptTypes.DEATH;}
  {LIGHTNING}                                               {yybegin(YYINITIAL); return ACSScriptTypes.LIGHTNING;}
  {UNLOADING}                                               {yybegin(YYINITIAL); return ACSScriptTypes.UNLOADING;}
  {DISCONNECT}                                              {yybegin(YYINITIAL); return ACSScriptTypes.DISCONNECT;}
  {KILL}                                                    {yybegin(YYINITIAL); return ACSScriptTypes.KILL;}
  {REOPEN}                                                  {yybegin(YYINITIAL); return ACSScriptTypes.REOPEN;}
  {PICKUP}                                                  {yybegin(YYINITIAL); return ACSScriptTypes.PICKUP;}
  {REDRETURN}                                               {yybegin(YYINITIAL); return ACSScriptTypes.REDRETURN;}
  {WHITERETURN}                                             {yybegin(YYINITIAL); return ACSScriptTypes.WHITERETURN;}
  {BLUERETURN}                                              {yybegin(YYINITIAL); return ACSScriptTypes.BLUERETURN;}
  {CLIENTSIDE}                                              {yybegin(YYINITIAL); return ACSScriptTypes.CLIENTSIDE;}
  {NET}                                                     {yybegin(YYINITIAL); return ACSScriptTypes.NET;}
  {OPEN_SQUARE_BRACKET}                                     {yybegin(YYINITIAL); return ACSScriptTypes.OPEN_SQUARE_BRACKET;}
  {CLOSE_SQUARE_BRACKET}                                    {yybegin(YYINITIAL); return ACSScriptTypes.CLOSE_SQUARE_BRACKET;}
  {SEMICOLON_SYMBOL}                                        {yybegin(YYINITIAL); return ACSScriptTypes.SEMICOLON;}
  {COLON_SYMBOL}                                            {yybegin(YYINITIAL); return ACSScriptTypes.COLON;}
  {IDENTIFIER}                                              {yybegin(YYINITIAL); return ACSScriptTypes.IDENTIFIER; }
// If the character sequence does not match any of the above rules, we return BAD_CHARACTER which indicates that
// there is an error in the character sequence. This is used to highlight errors.
[^] { return TokenType.BAD_CHARACTER; }
