package by.home.acs.language.refactor;

import by.home.acs.language.psi.ACSScriptFunctionName;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ACSTestRefactoring extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
        System.out.println(element);
        if (element instanceof ACSScriptFunctionName) {
            System.out.println("element true");
            return true;
        } else {
            System.out.println(element);
        }
        return false;
    }
}
