package by.home.acs.language.completion;


import by.home.acs.language.ACSScriptTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static by.home.acs.language.completion.lookup.VariableLookupElement.createLookupElementWithTail;
import static by.home.acs.language.util.PsiHelper.psiEquals;

public class ACSScriptTypeCompletionContributor extends CompletionContributor {

    private final IElementType[] scriptNames = {ACSScriptTypes.STRING, ACSScriptTypes.NUMBER};

    public ACSScriptTypeCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {

                try {
                    Optional<PsiElement> element = Optional.of(parameters.getPosition().getParent().getPrevSibling().getPrevSibling());
                    element.ifPresent(psiElement -> {
                        if (psiEquals(psiElement.toString(), scriptNames)) {
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
                        } else {
                            /*System.out.println(psiElement + "SSSSSS");*/

                        }
                    });
                } catch (NullPointerException e) {

                }
            }
        });
    }
}
