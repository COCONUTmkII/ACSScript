package by.home.acs.language.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSScriptDirectiveCompletionContributor extends CompletionContributor {
    public ACSScriptDirectiveCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf("#"), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                result.addElement(LookupElementBuilder.create("include"));
                result.addElement(LookupElementBuilder.create("library"));
                result.addElement(LookupElementBuilder.create("import"));
                result.addElement(LookupElementBuilder.create("define"));

            }
        });
    }
}
