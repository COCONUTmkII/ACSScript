package by.home.acs.language.usage;

import by.home.acs.language.psi.ACSScriptFunctionName;
import by.home.acs.language.search.ACSFunctionSearch;
import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesHandlerFactory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.util.MergeQuery;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;

public class ACSFindUsagesHandlerFactory extends FindUsagesHandlerFactory {
    @Override
    public boolean canFindUsages(@NotNull PsiElement element) {
        return element instanceof ACSScriptFunctionName;
    }

    @Override
    public @Nullable
    FindUsagesHandler createFindUsagesHandler(@NotNull PsiElement element, boolean forHighlightUsages) {
        return new FindACSFunctionUsagesHandler(element);
    }

    private static class FindACSFunctionUsagesHandler extends FindUsagesHandler {

        protected FindACSFunctionUsagesHandler(@NotNull PsiElement psiElement) {
            super(psiElement);
        }

        //FIXME query is always null. Because stubs not implemented?
        @Override
        public @NotNull
        Collection<PsiReference> findReferencesToHighlight(@NotNull PsiElement target, @NotNull SearchScope searchScope) {
            var result = new ArrayList<PsiReference>();
            if (target instanceof ACSScriptFunctionName) {
                System.out.println("HERE");
                ACSScriptFunctionName functionName = (ACSScriptFunctionName) target;
                var referencesToHighlight = super.findReferencesToHighlight(target, searchScope);
                MergeQuery<ACSScriptFunctionName> query = new MergeQuery<>(ACSFunctionSearch.search(functionName), ACSFunctionSearch.search(functionName));
                var psiFile = target.getContainingFile();

                query.forEach(func -> {
                    if (psiFile == func.getContainingFile()) {
                        referencesToHighlight.add(functionName.getReference());
                        referencesToHighlight.addAll(ReferencesSearch.search(func, searchScope).findAll());
                    }
                });
                result.addAll(referencesToHighlight);
                return result;
            }

            return result;
        }
    }
}
