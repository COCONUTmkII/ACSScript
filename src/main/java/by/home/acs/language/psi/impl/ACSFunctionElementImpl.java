package by.home.acs.language.psi.impl;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSFunctionElement;
import by.home.acs.language.psi.ACSFunctionEscaper;
import by.home.acs.language.psi.ACSManipulator;
import by.home.acs.language.psi.ACSScriptElementFactory;
import by.home.acs.language.stub.ACSFunctionStub;
import by.home.acs.language.stub.ACSStubElementImpl;
import com.intellij.lang.ASTNode;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class ACSFunctionElementImpl extends ACSStubElementImpl<ACSFunctionStub> implements ACSFunctionElement, PsiLanguageInjectionHost, PsiNameIdentifierOwner {

    public ACSFunctionElementImpl(@NotNull ACSFunctionStub stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public ACSFunctionElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public boolean isValidHost() {
        return true;
    }

    @Override
    public PsiLanguageInjectionHost updateText(@NotNull String text) {
        return new ACSManipulator().handleContentChange(this, text);
    }

    @Override
    public @NotNull
    LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper() {
        return new ACSFunctionEscaper(this);
    }

    @Override
    public @Nullable
    PsiElement getNameIdentifier() {
        final ASTNode node = getFunctionNamesNode();
        return node == null ? null : node.getPsi();
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        ACSFunctionElementImpl functionName = (ACSFunctionElementImpl) ACSScriptElementFactory.createFunctionWithProvidedName(getProject(), name, "void", List.of("void"));
        ASTNode node = getFunctionNamesNode();
        ASTNode newNode = functionName.getFunctionNamesNode();
        System.out.println(newNode != null);
        if (node != null) {
            getNode().addChild(newNode);
        } else {
            getNode().replaceChild(node, newNode);
        }
        return this;
    }

    @Nullable
    public ASTNode getFunctionNamesNode() {
        return getNode().findChildByType(ACSScriptTypes.FUNCTION);
    }

    @Override
    public String getName() {
        ASTNode astNode = getFunctionNamesNode();
        if (astNode != null)
            return astNode.getText();
        return null;
    }

}
