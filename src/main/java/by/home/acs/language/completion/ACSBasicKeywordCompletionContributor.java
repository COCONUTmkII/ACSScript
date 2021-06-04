package by.home.acs.language.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ACSBasicKeywordCompletionContributor extends CompletionContributor {
    public ACSBasicKeywordCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(),
                new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters,
                                          @NotNull ProcessingContext context,
                                          @NotNull CompletionResultSet result) {

                System.out.println(parameters.getPosition());
                System.out.println(Objects.requireNonNull(parameters.getOriginalPosition()).getParent());
                System.out.println(Objects.requireNonNull(parameters.getPosition().getParent()));

                result.addElement(LookupElementBuilder.create("script"));
                result.addElement(LookupElementBuilder.create("function"));
                result.addElement(LookupElementBuilder.create("int"));
                result.addElement(LookupElementBuilder.create("str"));
                result.addElement(LookupElementBuilder.create("bool"));
                result.addElement(LookupElementBuilder.create("void"));
            }
        });
    }
}

