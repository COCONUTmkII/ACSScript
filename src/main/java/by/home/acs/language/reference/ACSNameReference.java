package by.home.acs.language.reference;

import by.home.acs.language.ACSScriptIcon;
import by.home.acs.language.ACSUtil;
import by.home.acs.language.psi.ACSScriptScriptName;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ACSNameReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    public ACSNameReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final List<ACSScriptScriptName> properties = ACSUtil.findScriptName(project);
        List<ResolveResult> results = new ArrayList<>();
        properties.forEach(property -> results.add(new PsiElementResolveResult(property)));
        System.out.println(properties.size());
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Override
    public @Nullable PsiElement resolve() {
        ResolveResult[]resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        Project project = myElement.getProject();
        List<ACSScriptScriptName> properties = ACSUtil.findScriptName(project);
        List<LookupElement> variants = new ArrayList<>();
        for (final ACSScriptScriptName property : properties) {
            if (property != null && property.getText().length() > 0) {
                variants.add(LookupElementBuilder
                        .create(property).withIcon(ACSScriptIcon.FILE)
                        .withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
