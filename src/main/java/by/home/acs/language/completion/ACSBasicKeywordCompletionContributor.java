package by.home.acs.language.completion;

import by.home.acs.language.psi.ACSScriptFile;
import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static by.home.acs.language.completion.lookup.VariableLookupElement.createTypeLookupElement;

public class ACSBasicKeywordCompletionContributor extends CompletionContributor {

    public ACSBasicKeywordCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(),
                new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters,
                                          @NotNull ProcessingContext context,
                                          @NotNull CompletionResultSet result) {
                final PsiElement parent = parameters.getPosition().getParent().getParent();
                if (parent instanceof ACSScriptFile) {
                    result.addElement(createTypeLookupElement("script"));
                    result.addElement(createTypeLookupElement("function"));
                } else {
                    result.addElement(createTypeLookupElement("int"));
                    result.addElement(createTypeLookupElement("str"));
                    result.addElement(createTypeLookupElement("bool"));
                    result.addElement(createTypeLookupElement("void"));
                }
            }
        });
    }
}

