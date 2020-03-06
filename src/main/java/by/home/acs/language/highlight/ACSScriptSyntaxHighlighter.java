package by.home.acs.language.highlight;

import by.home.acs.language.ACSScriptLexerAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class ACSScriptSyntaxHighlighter extends SyntaxHighlighterBase {



    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ACSScriptLexerAdapter();
    }


    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return ACSScriptSyntaxAttributeKeySupplier.supplyTextAttributeKey(tokenType);
    }
}
