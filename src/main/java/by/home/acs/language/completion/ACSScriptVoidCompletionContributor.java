package by.home.acs.language.completion;

import by.home.acs.language.psi.impl.ACSScriptFunctionIdentifierImpl;
import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static by.home.acs.language.completion.lookup.VariableLookupElement.createBoldLookupElement;

public class ACSScriptVoidCompletionContributor extends CompletionContributor {

    public ACSScriptVoidCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {

            //FIXME not working right now
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                final PsiElement element = parameters.getPosition().getParent();

                if (element instanceof ACSScriptFunctionIdentifierImpl) {
                    result.addElement(createBoldLookupElement("void"));
                    result.addElement(createBoldLookupElement("int"));
                    result.addElement(createBoldLookupElement("bool"));
                    result.addElement(createBoldLookupElement("str"));
                }
            }
        });
    }
}
