package by.home.acs.language.psi.impl;

import by.home.acs.language.psi.*;
import by.home.acs.language.stub.ACSFunctionStub;
import by.home.acs.language.stub.ACSStubElementImpl;
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
        ACSScriptFunctionDefinition functionWithProvidedName = ACSScriptElementFactory.createFunctionWithProvidedName(getProject(), name, "void", List.of("void"));
        ASTNode node = getFunctionNamesNode();
        ASTNode newNode = functionWithProvidedName.getFunctionName().getNode();
        if (node != null) {
            getNode().replaceChild(node, newNode);
        }
        return this;
    }

    @Nullable
    public ASTNode getFunctionNamesNode() {
        return getNode();
    }

    @Override
    public String getName() {
        ASTNode astNode = getFunctionNamesNode();
        if (astNode != null)
            return astNode.getText();
        return null;
    }


    @Override
    public String toString() {
        return "ACSFunctionElementImpl{ name + " + getName() + " }";
    }

    @Override
    public @NotNull SearchScope getUseScope() {
        return GlobalSearchScope.allScope(getProject());
    }


    @Override
    public String getFunctionName() {
        final ACSFunctionStub stub = getStub();
        if (stub != null) {
            return stub.getFunctionName();
        }
        final ASTNode node = getFunctionNamesNode();
        if (node == null) {
            System.out.println("node is null");
            return null;
        }
        return node.getText();
    }
}
