package by.home.acs.language.psi;

import by.home.acs.language.ACSScriptFileDefinition;
import by.home.acs.language.ACSScriptLanguage;
import com.intellij.lexer.Lexer;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiKeyword;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.light.LightElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class ACSKeywordElement extends LightElement implements PsiKeyword {
    private final String myText;
    private final PsiManager psiManager;

    protected ACSKeywordElement(@NotNull PsiManager manager, String myText) {
        super(manager, ACSScriptLanguage.INSTANCE);
        this.myText = myText;
        this.psiManager = manager;
    }

    @Override
    public String getText() {
        return myText;
    }

    @Override
    public IElementType getTokenType() {
        ACSScriptFileDefinition acsScriptFileDefinition = new ACSScriptFileDefinition();
        Lexer lexer = acsScriptFileDefinition.createLexer(psiManager.getProject());
        lexer.start(myText);
        return lexer.getTokenType();
    }

    @Override
    public PsiElement copy() {
        return new ACSKeywordElement(getManager(), myText);
    }

    @Override
    public String toString() {
        return "PsiACSKeyword:" + getText();
    }
}
