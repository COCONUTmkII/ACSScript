package by.home.acs.language;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class ACSScriptLexerAdapter extends FlexAdapter {
    public ACSScriptLexerAdapter() {
        super(new ACSScriptLexer((Reader) null));
    }
}
