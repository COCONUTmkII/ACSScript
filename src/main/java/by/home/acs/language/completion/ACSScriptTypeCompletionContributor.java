package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static by.home.acs.language.completion.lookup.VariableLookupElement.createLookupElementWithTail;

public class ACSScriptTypeCompletionContributor extends CompletionContributor {

    public ACSScriptTypeCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ACSScriptTypes.SCRIPT_TYPE), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                result.addElement(createLookupElementWithTail("OPEN", " World"));
                result.addElement(createLookupElementWithTail("ENTER", " Player"));
                result.addElement(createLookupElementWithTail("REOPEN", " World"));
                result.addElement(createLookupElementWithTail("RETURN", " Player"));
                result.addElement(createLookupElementWithTail("DEATH", " Player"));
                result.addElement(createLookupElementWithTail("RESPAWN", " Player"));
                result.addElement(createLookupElementWithTail("LIGHTNING", " World"));
                result.addElement(createLookupElementWithTail("UNLOADING", " World"));
                result.addElement(createLookupElementWithTail("KILL", " Thing"));
                result.addElement(createLookupElementWithTail("DISCONNECT", " World"));
            }
        });
    }
}
