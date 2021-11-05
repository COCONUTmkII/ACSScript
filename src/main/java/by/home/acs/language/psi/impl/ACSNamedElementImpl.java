package by.home.acs.language.psi.impl;

import by.home.acs.language.psi.ACSFunctionElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class ACSNamedElementImpl extends ASTWrapperPsiElement implements ACSFunctionElement {
    public ACSNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
