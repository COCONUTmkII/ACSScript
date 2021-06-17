package by.home.acs.language.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSScriptReferenceContributor extends PsiReferenceContributor {
    private static final String SCRIPT_IDENTIFIER = "script";

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                                                 @NotNull ProcessingContext context) {
                        PsiLiteralExpression scriptName = (PsiLiteralExpression) element;
                        String scriptNameValue = scriptName.getValue() instanceof String ? (String) scriptName.getValue() : null;
                        if (scriptNameValue != null && scriptNameValue.startsWith("script")) {
                            TextRange textRange = new TextRange(SCRIPT_IDENTIFIER.length(), SCRIPT_IDENTIFIER.length());
                            return new PsiReference[]{new ACSScriptReference(element, textRange)};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }
}
