package by.home.acs.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static by.home.acs.language.ACSScriptTypes.*;

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

EOL=\R
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
WHITE_SPACE=\s+
FUNCTION="function"
OPEN_BRACKET="("
WHITE_SPACE=[ \t\n\x0B\f\r]+
NUMBER=(-?[0-9]+)
STRING= \"([^\\\"]|\\.)*\"
END_LINE_COMMENT=("//")[^\r\n]*
MULTIPLE_LINE_COMMENT="/*"( [^*] | (\*+[^*/]) )*\*+\/
FIRST_VALUE_CHARACTER=[^ \s] | "\\"{EOL} | "\\".    //remove this
VALUE_CHARACTER=[^\s] | "\\"{EOL} | "\\".           //remove this



%states WAITING_VALUE, TEST_VALUE
%%

  {WHITE_SPACE}      { return WHITE_SPACE; }
    "void"             { return VOID; }
    "int"              { return INT; }
    "str"              { return STR; }
    "bool"             { return BOOL; }
    "script"           { return SCRIPT; }
    "("                { return OPEN_BRACKET; }
    ")"                { return CLOSE_BRACKET; }
    "{"                { return OPEN_BRACE; }
    "}"                { return CLOSE_BRACE; }
    ","                { return COMMA; }
    "COMMENT"          { return COMMENT; }
  {FUNCTION}+                                               {yybegin(WAITING_VALUE);  return FUNCTION;}
    /*<WAITING_VALUE> {WHITE_SPACE}+                                {yybegin(WAITING_VALUE); return WHITE_SPACE; }*/
    <WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*     {yybegin(TEST_VALUE); return FUNCTION_RETURN_TYPE;}
      <TEST_VALUE> {IDENTIFIER}{OPEN_BRACKET}                     {yybegin(YYINITIAL); return FUNCTION_PARAMETER;}
    //FIXME need to fix identifier after function return type

  {WHITE_SPACE}      { return WHITE_SPACE; }
  {NUMBER}           { return NUMBER; }
  {STRING}           { return STRING; }
  {END_LINE_COMMENT} { return COMMENT;}
  {MULTIPLE_LINE_COMMENT} { return COMMENT;}
  {IDENTIFIER}       { return IDENTIFIER; }

[^] { return BAD_CHARACTER; }
