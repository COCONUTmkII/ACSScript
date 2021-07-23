package by.home.acs.language.completion;

import by.home.acs.language.psi.ACSScriptAssignmentStatement;
import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static by.home.acs.language.completion.lookup.VariableLookupElement.createBoldLookupElement;


public class ACSScriptAssignmentCompletionContributor extends CompletionContributor {

    public ACSScriptAssignmentCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {

            //FIXME not working right now
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                final PsiElement element = parameters.getPosition().getParent();

                if (element instanceof ACSScriptAssignmentStatement) {
                    result.addElement(createBoldLookupElement("void"));
                    result.addElement(createBoldLookupElement("int"));
                    result.addElement(createBoldLookupElement("bool"));
                    result.addElement(createBoldLookupElement("str"));
                    result.addElement(createBoldLookupElement("for"));
                    result.addElement(createBoldLookupElement("if"));
                    result.addElement(createBoldLookupElement("do"));
                    result.addElement(createBoldLookupElement("switch"));
                    result.addElement(createBoldLookupElement("until"));
                }
            }
        });
    }
}
