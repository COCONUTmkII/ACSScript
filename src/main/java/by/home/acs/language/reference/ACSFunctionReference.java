package by.home.acs.language.reference;

import by.home.acs.language.ACSScriptIcon;
import by.home.acs.language.psi.ACSScriptFunctionDefinition;
import by.home.acs.language.psi.ACSScriptFunctionInvocation;
import by.home.acs.language.psi.ACSScriptFunctionName;
import by.home.acs.language.util.ACSUtil;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import kotlin.jvm.Throws;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ACSFunctionReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String functionName;

    public ACSFunctionReference(@NotNull PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
        functionName = element.getText().substring(1, element.getText().length() - 1);
    }

    @Override
    @NotNull
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<ACSScriptFunctionDefinition> functionDefinitions = ACSUtil.findFunctionDefinition(project, functionName);
        final List<ACSScriptFunctionInvocation> functionInvocations = ACSUtil.findFunctionInvocation(project, functionName);
        List<ResolveResult> results = new ArrayList<>();
        functionDefinitions.forEach(acsScriptFunctionDefinition -> results.add(new PsiElementResolveResult(acsScriptFunctionDefinition.getFunctionName())));
        functionInvocations.forEach(acsScriptFunctionInvocation -> results.add(new PsiElementResolveResult(acsScriptFunctionInvocation.getFunctionName())));
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Override
    public @Nullable PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    @NotNull
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<ACSScriptFunctionDefinition> definitions = ACSUtil.findFunctionDefinition(project);
        List<LookupElement> variants = new ArrayList<>();
        for (final ACSScriptFunctionDefinition property : definitions) {
            if (property != null) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(ACSScriptIcon.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }

    @Override
    public boolean isReferenceTo(@NotNull PsiElement element) {
        if (element instanceof ACSScriptFunctionName) {
            String name = ((ACSScriptFunctionName) element).getName();
            assert name != null;
            return name.equals(functionName);
        }
        return false;
    }

    @Override
    @Throws(exceptionClasses = IncorrectOperationException.class)
    public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
        if (element instanceof ACSScriptFunctionName) {
            String name = ((ACSScriptFunctionName) element).getName();
            return name != null ? super.handleElementRename(name) : element;
        } else {
            System.out.println(element);
        }
        return element;
    }
}
