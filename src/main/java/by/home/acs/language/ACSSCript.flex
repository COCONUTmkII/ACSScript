package by.home.acs.language;

import by.home.acs.language.psi.ACSScriptTokenType;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType.*;

%%
%public
%class ACSScriptLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

/*IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
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
[^] { return TokenType.BAD_CHARACTER; }*/
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*

// If some character sequence is matched to this regex, it will be treated as a WHITE_SPACE.
WHITE_SPACE=[ \t\n\x0B\f\r]+

// Initial state. We can specify mutiple states for more complex grammars. This corresponds to `modes` in ANTLR grammar.
%%
<YYINITIAL> {
  // In here, we match keywords. So if a keyword is found, this returns a token which corresponds to that keyword.
  // These tokens are generated using the `Ballerina.bnf` file and located in the SimpleTypes `class`.
  // These tokens are Parser uses these return values to match token squence to a parser rule.
  "Script"           { return ACSScriptTypes.SCRIPT;}
  "function"         { return ACSScriptTypes.FUNCTION; } // This indicates that the `function` keyword is encountered.
  "returns"          { return ACSScriptTypes.RETURNS; }  // This indicates that the `returns` keyword is encountered.
  "int"              { return ACSScriptTypes.INT; }      // This indicates that the `int` keyword is encountered.
  "string"           { return ACSScriptTypes.STR; }   // This indicates that the `string` keyword is encountered.

  // In here, we check for character sequences which matches regular expressions which we defined above.
  {IDENTIFIER}       { return ACSScriptTypes.IDENTIFIER; } // This indicates that a character sequence which matches to the rule
                                            // identifier is encountered.
  {WHITE_SPACE}      { return TokenType.WHITE_SPACE; } // This indicates that a character sequence which matches to the rule
                                             // whitespace is encountered.
}

// If the character sequence does not match any of the above rules, we return BAD_CHARACTER which indicates that
// there is an error in the character sequence. This is used to highlight errors.
[^] { return TokenType.BAD_CHARACTER; }
