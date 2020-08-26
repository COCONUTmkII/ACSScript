package by.home.acs.language.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiPolyVariantReference;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * Reference class that will be resolve some properties from it's usage.
 * The latter enables the reference to resolve to more than one element or to resolve
 * result(s) for a superset of valid resolve cases.
 * Currently not implemented
 */
public class ACSScriptReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    public ACSScriptReference(@NotNull PsiElement element, TextRange rangeInElement, boolean soft) {
        super(element, rangeInElement, soft);
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        return new ResolveResult[0];
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        return null;
    }
}
