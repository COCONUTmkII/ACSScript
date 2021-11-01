package by.home.acs.language.usage;

import by.home.acs.language.psi.ACSScriptFunctionName;
import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesHandlerFactory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.SearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

        //TODO check how it works with static classes, especially search method
        @Override
        public @NotNull
        Collection<PsiReference> findReferencesToHighlight(@NotNull PsiElement target, @NotNull SearchScope searchScope) {
            var referencesToHighlight = super.findReferencesToHighlight(target, searchScope);
            //var query = new MergeQuery(ACSFunctionSearch, ACSFunctionSearch);
            var psiFile = target.getContainingFile();
//            query.forEach(o -> {
//                if (psiFile == o.)
//            });

//            System.out.println(referencesToHighlight.size());
//            final List<ACSScriptFunctionDefinition> functionDefinitions = ACSUtil.findFunctionDefinition(target.getProject(), target.getText());
//            final List<ACSScriptFunctionInvocation> functionInvocations = ACSUtil.findFunctionInvocation(target.getProject(), target.getText());
//            functionInvocations.forEach(acsScriptFunctionInvocation -> {
//                referencesToHighlight.addAll(ReferencesSearch.search(acsScriptFunctionInvocation, searchScope).findAll());
//            });
//            functionDefinitions.forEach(acsScriptFunctionDefinition -> {
//                referencesToHighlight.addAll(ReferencesSearch.search(acsScriptFunctionDefinition, searchScope).findAll());
//            });
            return referencesToHighlight;
        }
    }
}
