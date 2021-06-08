package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static by.home.acs.language.completion.lookup.VariableLookupElement.createBoldLookupElement;

public class ACSScriptNetTypeCompletionContributor extends CompletionContributor {

    public ACSScriptNetTypeCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ACSScriptTypes.NET_TYPE), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                result.addElement(createBoldLookupElement("NET"));
            }
        });
    }
}
