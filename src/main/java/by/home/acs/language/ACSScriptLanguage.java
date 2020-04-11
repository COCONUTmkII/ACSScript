package by.home.acs.language;

import com.intellij.lang.Language;

public class ACSScriptLanguage extends Language {
    public static final ACSScriptLanguage INSTANCE = new ACSScriptLanguage();

    private ACSScriptLanguage(){
        super("ACSScript");
    }
}
