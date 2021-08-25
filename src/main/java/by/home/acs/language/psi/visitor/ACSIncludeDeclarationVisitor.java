package by.home.acs.language.psi.visitor;

import by.home.acs.language.psi.ACSScriptIncludeDeclaration;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

public class ACSIncludeDeclarationVisitor extends PsiElementVisitor {
    @Override
    public void visitElement(@NotNull PsiElement element) {
        if (element instanceof ACSScriptIncludeDeclaration) {
            super.visitElement(element);
        }
    }
}
