package by.home.acs.language.helper;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class ACSScriptNamedElementImpl extends ASTWrapperPsiElement implements ACSScriptNamedElement {
    public ACSScriptNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
