package by.home.acs.language.highlight;

import by.home.acs.language.ACSLexerAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class ACSSyntaxHighlighter extends SyntaxHighlighterBase {
    @NotNull
    @Override
    public  Lexer getHighlightingLexer() {
        return new ACSLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return ACSSyntaxAttributeKeySupplier.supplyTextAttributeKey(tokenType);
    }
}
