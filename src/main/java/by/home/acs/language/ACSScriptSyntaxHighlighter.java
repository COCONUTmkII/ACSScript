package by.home.acs.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static com.intellij.openapi.editor.colors.TextAttributesKey.isTemp;

public class ACSScriptSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    public static final TextAttributesKey STRING_VALUE =
            createTextAttributesKey("SIMPLE_STRING_VALUE", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey INT_VALUE =
            createTextAttributesKey("SIMPLE_INT_VALUE", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    public static final TextAttributesKey KEY =
            createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD);

    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] INT_KEYS = new TextAttributesKey[]{INT_VALUE};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING_VALUE};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ACSScriptLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ACSScriptTypes.IDENTIFIER)) {
            return SEPARATOR_KEYS;
        } else if (tokenType.equals(ACSScriptTypes.FUNCTION) || tokenType.equals(ACSScriptTypes.SCRIPT)) {
            return KEY_KEYS;
        } else if (tokenType.equals(ACSScriptTypes.NUMBER)) {
            return INT_KEYS;
        } else if (tokenType.equals(ACSScriptTypes.STRING) || tokenType.equals(ACSScriptTypes.STR)) {
            return STRING_KEYS;
        } else if (tokenType.equals(ACSScriptTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
