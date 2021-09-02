package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSVariableCompletionContributor extends CompletionContributor {
    public ACSVariableCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ACSScriptTypes.SCRIPT_BODY),
                new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                {
                    result.addElement(LookupElementBuilder.create("int"));
                    result.addElement(LookupElementBuilder.create("str"));
                    result.addElement(LookupElementBuilder.create("bool"));
                }
            }
        });
    }
}
