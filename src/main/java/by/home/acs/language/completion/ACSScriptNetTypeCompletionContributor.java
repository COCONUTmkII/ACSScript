package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static by.home.acs.language.completion.lookup.VariableLookupElement.createBoldLookupElement;
import static by.home.acs.language.util.PsiHelper.psiEquals;
import static com.intellij.patterns.PsiJavaPatterns.psiElement;

public class ACSScriptNetTypeCompletionContributor extends CompletionContributor {
    private final IElementType[] scriptTypes = {ACSScriptTypes.OPEN, ACSScriptTypes.ENTER, ACSScriptTypes.REOPEN,
            ACSScriptTypes.RETURN, ACSScriptTypes.DEATH, ACSScriptTypes.RESPAWN, ACSScriptTypes.RESPAWN,
            ACSScriptTypes.LIGHTNING, ACSScriptTypes.UNLOADING, ACSScriptTypes.KILL, ACSScriptTypes.DISCONNECT};

    public ACSScriptNetTypeCompletionContributor() {
        extend(CompletionType.BASIC, psiElement(), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                try {
                    Optional<PsiElement> element = Optional.of(parameters.getPosition().getParent().getPrevSibling().getPrevSibling());
                    element.ifPresent(psiElement -> {
                        if (psiEquals(psiElement.toString(), scriptTypes)) {
                            result.addElement(createBoldLookupElement("NET"));
                        }
                    });
                } catch (NullPointerException e) {

                }
            }
        });
    }
}
