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
WHITE_SPACE=\s+

WHITE_SPACE=[ \t\n\x0B\f\r]+
NUMBER=(-?[0-9]+)
STRING= \"([^\\\"]|\\.)*\"
END_LINE_COMMENT=("//")[^\r\n]*
MULTIPLE_LINE_COMMENT="/*"( [^*] | (\*+[^*/]) )*\*+\/
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "function"         { return FUNCTION; }
  "script"           { return SCRIPT; }
  "void"             { return VOID; }
  "int"              { return INT; }
  "str"              { return STR; }
  "bool"             { return BOOL; }
  "("                { return OPEN_BRACKET; }
  ")"                { return CLOSE_BRACKET; }
  "{"                { return OPEN_BRACE; }
  "}"                { return CLOSE_BRACE; }
  ","                { return COMMA; }
  "COMMENT"          { return COMMENT; }

  {WHITE_SPACE}      { return WHITE_SPACE; }
  {NUMBER}           { return NUMBER; }
  {STRING}           { return STRING; }
  {END_LINE_COMMENT} { return COMMENT;}
  {MULTIPLE_LINE_COMMENT} { return COMMENT;}
  {IDENTIFIER}       { return IDENTIFIER; }

}

[^] { return BAD_CHARACTER; }
