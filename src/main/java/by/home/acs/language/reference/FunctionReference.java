package by.home.acs.language.reference;

import by.home.acs.language.psi.ACSScriptElementFactory;
import by.home.acs.language.psi.ACSScriptFunctionDefinition;
import by.home.acs.language.psi.ACSScriptFunctionName;
import by.home.acs.language.util.ACSUtil;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionReference extends PsiReferenceBase<ACSScriptFunctionName> implements PsiPolyVariantReference {

    public FunctionReference(@NotNull ACSScriptFunctionName element) {
        super(element);
    }

    @Override
    @NotNull
    public TextRange getRangeInElement() {
        return TextRange.from(0, myElement.getTextLength());
    }

    @Override
    public @Nullable
    PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        for (ResolveResult result : resolveResults) {
            return result.getElement();
        }
        return null;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        List<ACSScriptFunctionDefinition> functionDefinitions = ACSUtil.findFunctionDefinition(project, myElement.getName());
        List<ResolveResult> results = new ArrayList<>();
        functionDefinitions.forEach(acsScriptFunctionDefinition -> results.add(new PsiElementResolveResult(acsScriptFunctionDefinition.getFunctionName())));
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Override
    public boolean isReferenceTo(@NotNull PsiElement element) {
        return element instanceof ACSScriptFunctionName;
    }


    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        final ACSScriptFunctionDefinition functionWithProvidedName = ACSScriptElementFactory.createSimpleFunction(myElement.getProject(), newElementName);
        ACSScriptFunctionName functionName = functionWithProvidedName.getFunctionName();
        myElement.replace(functionName);
        return myElement;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        List<LookupElement> variants = new ArrayList<>();
        List<ACSScriptFunctionName> functionNames =
                ACSUtil.findFunctionDefinition(myElement.getProject()).stream()
                        .map(ACSScriptFunctionDefinition::getFunctionName).collect(Collectors.toList());
        functionNames.forEach(function -> variants.add(
                LookupElementBuilder.create(function).withIcon(AllIcons.Nodes.Function)
                        .withTypeText(function.getContainingFile().getText())));
        return variants.toArray();
    }
}
