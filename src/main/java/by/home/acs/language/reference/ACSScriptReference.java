package by.home.acs.language.reference;

import by.home.acs.language.ACSScriptIcon;
import by.home.acs.language.ACSUtil;
import by.home.acs.language.psi.ACSScriptDefinition;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


/**
 * Reference class that will be resolve some properties from it's usage.
 * The latter enables the reference to resolve to more than one element or to resolve
 * result(s) for a superset of valid resolve cases.
 * Currently not implemented
 */
public class ACSScriptReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String script;

    public ACSScriptReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        script = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<ACSScriptDefinition> properties = ACSUtil.findScript(project, script);
        List<ResolveResult> results = new ArrayList<>();
        properties.forEach(property -> results.add(new PsiElementResolveResult(property)));
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[]resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<ACSScriptDefinition> properties = ACSUtil.findScript(project);
        List<LookupElement> variants = new ArrayList<>();
        for (final ACSScriptDefinition property : properties) {
            if (property.getScriptDefinition() != null && property.getScriptDefinition().getText().length() > 0) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(ACSScriptIcon.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
