package by.home.acs.language;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import org.jetbrains.annotations.NotNull;

public class ACSLexerAdapter extends FlexAdapter {
    public ACSLexerAdapter() {
        super(new ACSScriptLexer(null));
    }
}
