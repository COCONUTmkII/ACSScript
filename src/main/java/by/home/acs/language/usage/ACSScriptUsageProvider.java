package by.home.acs.language.usage;

import by.home.acs.language.ACSScriptLexerAdapter;
import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSScriptFunctionName;
import by.home.acs.language.psi.ACSScriptVariableName;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ACSScriptUsageProvider implements FindUsagesProvider {
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new ACSScriptLexerAdapter(),
                TokenSet.create(ACSScriptTypes.FUNCTION_DEFINITION),
                TokenSet.create(ACSScriptTypes.COMMENT),
                TokenSet.EMPTY);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof ACSScriptFunctionName) {
            return "function";
        } else if (element instanceof ACSScriptVariableName) {
            return "variable";
        } else {
            return "element";
        }
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof ACSScriptFunctionName) {
            return ((ACSScriptFunctionName) element).getName();
        } else {
            return "element";
        }
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        if (element instanceof ACSScriptFunctionName) {
            return element.getText();
        } else {
            return "element";
        }
    }
}
