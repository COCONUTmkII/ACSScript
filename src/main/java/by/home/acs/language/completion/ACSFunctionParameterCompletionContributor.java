package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptLanguage;
import by.home.acs.language.ACSScriptTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import sun.tools.jstat.Token;

public class ACSFunctionParameterCompletionContributor extends CompletionContributor {
    public ACSFunctionParameterCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ACSScriptTypes.FUNCTION_PARAMETER)
                //.withParent(PlatformPatterns.psiElement(ACSScriptTypes.IDENTIFIER))
                ,
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters,
                                                  @NotNull ProcessingContext context,
                                                  @NotNull CompletionResultSet result) {
                        result.addElement(LookupElementBuilder.create("void"));
                        result.addElement(LookupElementBuilder.create("int"));
                        result.addElement(LookupElementBuilder.create("str"));
                        result.addElement(LookupElementBuilder.create("bool"));
                    }
                });
    }
}
