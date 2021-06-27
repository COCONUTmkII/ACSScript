package by.home.acs.language.completion;


import by.home.acs.language.ACSScriptTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.openapi.util.IconLoader;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

import static by.home.acs.language.completion.lookup.VariableLookupElement.createLookupElementWithTail;
import static by.home.acs.language.completion.lookup.VariableLookupElement.createLookupElementWithTailAndIcon;
import static by.home.acs.language.util.PsiHelper.psiEquals;
import static com.intellij.openapi.util.IconLoader.getIcon;

import com.intellij.icons.AllIcons;

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
                            result.addElement(createLookupElementWithTailAndIcon("OPEN", " World", getIcon("/icons/zd.png")));
                            result.addElement(createLookupElementWithTailAndIcon("ENTER", " Player", getIcon("/icons/zd.png")));
                            result.addElement(createLookupElementWithTailAndIcon("REOPEN", " World", getIcon("/icons/zd.png")));
                            result.addElement(createLookupElementWithTailAndIcon("RETURN", " Player", getIcon("/icons/zd.png")));
                            result.addElement(createLookupElementWithTailAndIcon("DEATH", " Player", getIcon("/icons/zd.png")));
                            result.addElement(createLookupElementWithTailAndIcon("RESPAWN", " Player", getIcon("/icons/zd.png")));
                            result.addElement(createLookupElementWithTailAndIcon("LIGHTNING", " World", getIcon("/icons/zd.png")));
                            result.addElement(createLookupElementWithTailAndIcon("UNLOADING", " World", getIcon("/icons/zd.png")));
                            result.addElement(createLookupElementWithTailAndIcon("KILL", " Thing", getIcon("/icons/zd.png")));
                            result.addElement(createLookupElementWithTailAndIcon("DISCONNECT", " World", getIcon("/icons/zd.png")));
                            result.addElement(createLookupElementWithTailAndIcon("PICKUP", "Player", getIcon("/icons/gz.png")));
                            result.addElement(createLookupElementWithTailAndIcon("BLUERETURN", "World", getIcon("/icons/gz.png")));
                            result.addElement(createLookupElementWithTailAndIcon("REDRETURN", "World", getIcon("/icons/gz.png")));
                            result.addElement(createLookupElementWithTailAndIcon("WHITERETURN", "World", getIcon("/icons/gz.png")));
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
