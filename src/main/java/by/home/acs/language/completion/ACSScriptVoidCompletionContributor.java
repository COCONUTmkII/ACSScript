package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.completion.lookup.VariableLookupElement;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.PlatformIcons;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSScriptVoidCompletionContributor extends CompletionContributor {
    private final VariableLookupElement voidVariable = new VariableLookupElement("void");
    private final VariableLookupElement intVariable = new VariableLookupElement("int");
    private final VariableLookupElement boolVariable = new VariableLookupElement("bool");
    private final VariableLookupElement strVariable = new VariableLookupElement("str");
    public ACSScriptVoidCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ACSScriptTypes.FUNCTION_RETURN_TYPE), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                result.addElement(voidVariable.getVariableLookupElement());
                result.addElement(intVariable.getVariableLookupElement());
                result.addElement(boolVariable.getVariableLookupElement());
                result.addElement(strVariable.getVariableLookupElement());
            }
        });
    }
}
