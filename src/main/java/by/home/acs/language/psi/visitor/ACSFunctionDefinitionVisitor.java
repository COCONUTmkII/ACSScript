package by.home.acs.language.psi.visitor;

import by.home.acs.language.psi.ACSScriptFunctionDefinition;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class ACSFunctionDefinitionVisitor extends PsiElementVisitor {
    @Override
    public void visitElement(@NotNull PsiElement element) {
        if (element instanceof ACSScriptFunctionDefinition) {
            super.visitElement(element);
        }
    }
}
