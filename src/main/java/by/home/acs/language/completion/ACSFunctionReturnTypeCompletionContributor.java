package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptLanguage;
import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSScriptFunctionReturnType;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiErrorElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSFunctionReturnTypeCompletionContributor extends CompletionContributor {
    public ACSFunctionReturnTypeCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ACSScriptTypes.FUNCTION_RETURN_TYPE),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                        result.addElement(LookupElementBuilder.create("int"));
                        result.addElement(LookupElementBuilder.create("str"));
                        result.addElement(LookupElementBuilder.create("bool"));
                        result.addElement(LookupElementBuilder.create("void"));
                    }
                });
    }
}
