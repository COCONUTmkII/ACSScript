package by.home.acs.language.psi.impl;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.*;
import by.home.acs.language.stub.ACSStubElementImpl;
import by.home.acs.language.stub.variable.ACSVariableStub;
import com.intellij.lang.ASTNode;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ACSVariableElementImpl extends ACSStubElementImpl<ACSVariableStub> implements ACSVariableElement, PsiLanguageInjectionHost, PsiNameIdentifierOwner {

    public ACSVariableElementImpl(@NotNull ACSVariableStub stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public ACSVariableElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getVariableName() {
        final ACSVariableStub stub = getStub();
        if (stub != null) {
            return stub.getVariableName();
        }
        final ASTNode node = getVariableNameNode();
        return node.getText();
    }

    @Override
    public boolean isValidHost() {
        return true;
    }

    @Override
    public PsiLanguageInjectionHost updateText(@NotNull String text) {
        return new ACSVariableManipulator().handleContentChange(this, text);
    }

    @Override
    public @NotNull
    LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper() {
        return new ACSVariableEscaper(this);
    }


    @Override
    public @Nullable
    PsiElement getNameIdentifier() {
        final ASTNode node = getVariableNameNode();
        return node.getPsi();
    }

    private ASTNode getVariableNameNode() {
        return getNode();
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        final ACSScriptVariableDefinition varWithProvidedName = ACSScriptElementFactory.createDummyVariable(getProject(), name);
        ASTNode node = getNode().findChildByType(ACSScriptTypes.VARIABLE_NAME);
        ASTNode newNode = varWithProvidedName.getNode().findChildByType(ACSScriptTypes.VARIABLE_NAME);
        if (node != null && newNode != null) {
            getNode().replaceChild(node, newNode);
        }
        return this;
    }

    @Override
    public String getName() {
        return getVariableNameNode().getText();
    }

    @Override
    public String toString() {
        return "ACSVariableElementImpl{" + getName() + "}";
    }

    @Override
    public @NotNull
    SearchScope getUseScope() {
        return GlobalSearchScope.allScope(getProject());
    }


}
