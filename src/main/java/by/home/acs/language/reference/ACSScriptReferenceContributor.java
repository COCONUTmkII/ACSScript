package by.home.acs.language.reference;

import by.home.acs.language.psi.ACSScriptScriptName;
import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSScriptReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element,
                                                                 @NotNull ProcessingContext context) {
                        ACSScriptScriptName scriptName = (ACSScriptScriptName) element;
                        PsiElement stringNumber = scriptName.getString();
                        PsiElement number = scriptName.getNumber();
                        if (stringNumber != null || number == null) {
                            return PsiReference.EMPTY_ARRAY;
                        } else {
                            TextRange textRange = new TextRange(scriptName.getNode().getStartOffset(), scriptName.getNode().getTextRange().getEndOffset());
                            return new PsiReference[]{new ACSScriptReference(element, textRange)};
                        }
                    }
                });
    }
}
