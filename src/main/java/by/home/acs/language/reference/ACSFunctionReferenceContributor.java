package by.home.acs.language.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSFunctionReferenceContributor extends PsiReferenceContributor {
    private static final String FUNCTION_IDENTIFIER = "function";

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                                                 @NotNull ProcessingContext context) {
                        PsiLiteralExpression function = (PsiLiteralExpression) element;
                        String functionName = function.getValue() instanceof String ? (String) function.getValue() : null;
                        if ((functionName != null)) {
                            System.out.println("AHAHAHA");
                            TextRange property = new TextRange(functionName.length(), functionName.length());
                            return new PsiReference[]{new ACSFunctionReference(element, property)};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }
}
