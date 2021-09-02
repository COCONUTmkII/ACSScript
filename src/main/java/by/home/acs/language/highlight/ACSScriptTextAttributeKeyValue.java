package by.home.acs.language.highlight;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public final class ACSScriptTextAttributeKeyValue {
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("ACS_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);

    public static final TextAttributesKey STRING_VALUE =
            createTextAttributesKey("ACS_STRING_VALUE", DefaultLanguageHighlighterColors.STRING);

    public static final TextAttributesKey INT_VALUE =
            createTextAttributesKey("ACS_INT_VALUE", DefaultLanguageHighlighterColors.NUMBER);

    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("ACS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("ACS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    public static final TextAttributesKey KEY =
            createTextAttributesKey("ACS_KEY", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey SCRIPT_TYPE =
            createTextAttributesKey("ACS_SCRIPT_TYPE", DefaultLanguageHighlighterColors.METADATA);

    public static final TextAttributesKey FUNCTION_CALL =
            createTextAttributesKey("ACS_METHOD_CALL", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static final TextAttributesKey PARAMETER =
            createTextAttributesKey("ACS_PARAMETER", DefaultLanguageHighlighterColors.PARAMETER);

}
