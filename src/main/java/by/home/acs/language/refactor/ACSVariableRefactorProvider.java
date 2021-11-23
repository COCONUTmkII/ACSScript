package by.home.acs.language.refactor;

import by.home.acs.language.psi.ACSScriptVariableName;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ACSVariableRefactorProvider extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement elementToRename, @Nullable PsiElement context) {
        return elementToRename instanceof ACSScriptVariableName;
    }

}
