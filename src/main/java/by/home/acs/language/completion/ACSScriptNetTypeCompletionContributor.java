package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.completion.lookup.VariableLookupElement;
import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSScriptNetTypeCompletionContributor extends CompletionContributor {
    private final VariableLookupElement netTypeLookupElement = new VariableLookupElement("NET");

    public ACSScriptNetTypeCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ACSScriptTypes.NET_TYPE), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                result.addElement(netTypeLookupElement.getVariableLookupElement());
            }
        });
    }
}
