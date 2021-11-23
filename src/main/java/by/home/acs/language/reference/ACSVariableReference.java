package by.home.acs.language.reference;

import by.home.acs.language.psi.ACSScriptRepeatableVariable;
import by.home.acs.language.psi.ACSScriptVariableDefinition;
import by.home.acs.language.psi.ACSScriptVariableName;
import by.home.acs.language.psi.ACSVariableElement;
import by.home.acs.language.util.ACSUtil;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ACSVariableReference extends PsiReferenceBase<ACSVariableElement> implements PsiPolyVariantReference {

    public ACSVariableReference(@NotNull ACSVariableElement element) {
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
        Collection<ACSScriptVariableDefinition> variableNames = ACSUtil.findVariableDefinitions(myElement.getContainingFile(), myElement.getVariableName());
        Collection<ResolveResult> results = new ArrayList<>();
        variableNames.forEach(acsScriptVariableName -> results.add(new PsiElementResolveResult(acsScriptVariableName)));
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Override
    public boolean isReferenceTo(@NotNull PsiElement element) {
        return element instanceof ACSVariableElement;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        List<LookupElement> variants = new ArrayList<>();
        List<ACSScriptVariableName> varNames =
                ACSUtil.findVariableDefinitions(myElement.getContainingFile())
                        .stream().map(ACSScriptVariableDefinition::getRepeatableVariable)
                        .map(ACSScriptRepeatableVariable::getVariableName)
                        .collect(Collectors.toList());
        varNames.forEach(var -> variants.add(
                LookupElementBuilder.create(var).withIcon(AllIcons.Nodes.Function)
                        .withTypeText(var.getContainingFile().getText())));
        return variants.toArray();

    }
}
