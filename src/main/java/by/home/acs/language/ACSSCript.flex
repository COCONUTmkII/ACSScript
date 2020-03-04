package by.home.acs.language;

import by.home.acs.language.psi.ACSScriptTokenType;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import by.home.acs.language.psi.ACSScriptType;

%%

%class ACSScriptLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
WHITE_SPACE=[ \t\n\x0B\f\r]+

%state WAITING_VALUE
%%

<YYINITIAL> {
  // In here, we match keywords. So if a keyword is found, this returns a token which corresponds to that keyword.
  // These tokens are generated using the `Ballerina.bnf` file and located in the SimpleTypes `class`.
  // These tokens are Parser uses these return values to match token squence to a parser rule.
  "Script"              {yybegin(YYINITIAL); return ACSScriptTypes.SCRIPT;}
  "function"            {yybegin(YYINITIAL); return ACSScriptTypes.FUNCTION; } // This indicates that the `function` keyword is encountered.
  "returns"             {yybegin(YYINITIAL); return ACSScriptTypes.RETURNS; }  // This indicates that the `returns` keyword is encountered.
  "int"                 {yybegin(YYINITIAL); return ACSScriptTypes.INT; }      // This indicates that the `int` keyword is encountered.
  "str"                 {yybegin(YYINITIAL); return ACSScriptTypes.STR; }   // This indicates that the `string` keyword is encountered.
}



<WAITING_VALUE> {
    {IDENTIFIER} {yybegin(YYINITIAL); return ACSScriptTypes.IDENTIFIER;}
    {WHITE_SPACE}+ {yybegin(YYINITIAL); return TokenType.WHITE_SPACE;}
    {END_OF_LINE_COMMENT} {yybegin(YYINITIAL); return ACSScriptTypes.COMMENT;}
}

// If the character sequence does not match any of the above rules, we return BAD_CHARACTER which indicates that
// there is an error in the character sequence. This is used to highlight errors.
[^] { return TokenType.BAD_CHARACTER; }

