package by.home.acs.language.reference;

import by.home.acs.language.psi.ACSScriptFunctionDefinition;
import by.home.acs.language.psi.ACSScriptFunctionName;
import by.home.acs.language.util.ACSUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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
        List<ACSScriptFunctionDefinition> functionDefinitions = ACSUtil.findFunctionDefinition(myElement.getProject(), myElement.getName());
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
}
