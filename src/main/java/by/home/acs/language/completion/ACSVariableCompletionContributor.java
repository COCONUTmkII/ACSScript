package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptLanguage;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSVariableCompletionContributor extends CompletionContributor {
    public ACSVariableCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().withLanguage(ACSScriptLanguage.INSTANCE), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                result.addElement(LookupElementBuilder.create("int"));
                result.addElement(LookupElementBuilder.create("str"));
                result.addElement(LookupElementBuilder.create("bool"));
                // TODO change this for appearance after SCRIPT type.
            }
        });
    }
}
