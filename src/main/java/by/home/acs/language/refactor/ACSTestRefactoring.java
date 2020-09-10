package by.home.acs.language.refactor;

import by.home.acs.language.psi.ACSScriptFunctionIdentifier;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ACSTestRefactoring extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
        return (element instanceof ACSScriptFunctionIdentifier);
    }
}
