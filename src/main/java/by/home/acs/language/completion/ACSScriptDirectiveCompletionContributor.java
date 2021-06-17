package by.home.acs.language.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static by.home.acs.language.completion.lookup.VariableLookupElement.createBoldLookupElement;

public class ACSScriptDirectiveCompletionContributor extends CompletionContributor {
    public ACSScriptDirectiveCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf("#"), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                result.addElement(createBoldLookupElement("include"));
                result.addElement(createBoldLookupElement("library"));
                result.addElement(createBoldLookupElement("import"));
                result.addElement(createBoldLookupElement("define"));
            }
        });
    }
}
