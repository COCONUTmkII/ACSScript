package by.home.acs.language.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSNameReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                                                 @NotNull ProcessingContext context) {
                        PsiLiteralExpression test = (PsiLiteralExpression) element;
                        Integer testName = test.getValue() instanceof Integer ? (Integer) test.getValue() : null;
                        if (testName != null) {
                            TextRange textRange = new TextRange(element.getTextRange().getStartOffset(), element.getTextRange().getEndOffset());
                            return new PsiReference[]{new ACSNameReference(element, textRange)};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }
}
