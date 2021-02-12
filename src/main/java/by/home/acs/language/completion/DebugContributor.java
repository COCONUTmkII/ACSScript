package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class DebugContributor extends CompletionContributor {
    public DebugContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                        System.out.println(parameters.getOriginalPosition());
                        System.out.println(parameters.getPosition().getContext());
                        PsiElement element = parameters.getOriginalPosition();
                        try {
                            System.out.println(element.getNode());
                        } catch (NullPointerException e) {
                            e.getMessage();
                        }
                        result.addElement(LookupElementBuilder.create("function"));

                    }
                });
    }
}
