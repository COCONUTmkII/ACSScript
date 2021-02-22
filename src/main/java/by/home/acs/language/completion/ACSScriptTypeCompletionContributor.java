package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptLanguage;
import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.completion.lookup.VariableLookupElement;
import by.home.acs.language.psi.ACSScriptElementType;
import by.home.acs.language.psi.ACSScriptType;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class ACSScriptTypeCompletionContributor extends CompletionContributor {
    private final VariableLookupElement openType = new VariableLookupElement("OPEN", " World");
    private final VariableLookupElement enterType = new VariableLookupElement("ENTER", " Player");
    private final VariableLookupElement returnType = new VariableLookupElement("RETURN", " Player");
    private final VariableLookupElement deathType = new VariableLookupElement("DEATH", " Player");
    private final VariableLookupElement respawnType = new VariableLookupElement("RESPAWN", " Player");
    private final VariableLookupElement lightningType = new VariableLookupElement("LIGHTNING", " World");
    private final VariableLookupElement unloadingType = new VariableLookupElement("UNLOADING", " World");
    private final VariableLookupElement killType = new VariableLookupElement("KILL", " Thing");
    private final VariableLookupElement reopenType = new VariableLookupElement("REOPEN", " World");
    private final VariableLookupElement disconnectType = new VariableLookupElement("DISCONNECT", " World");
    private final VariableLookupElement netType = new VariableLookupElement("NET");

    public ACSScriptTypeCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ACSScriptTypes.SCRIPT_TYPE), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                result.addElement(openType.getVariableLookupElement());
                result.addElement(enterType.getVariableLookupElement());
                result.addElement(reopenType.getVariableLookupElement());
                result.addElement(returnType.getVariableLookupElement());
                result.addElement(deathType.getVariableLookupElement());
                result.addElement(respawnType.getVariableLookupElement());
                result.addElement(lightningType.getVariableLookupElement());
                result.addElement(unloadingType.getVariableLookupElement());
                result.addElement(killType.getVariableLookupElement());
                result.addElement(disconnectType.getVariableLookupElement());
                result.addElement(netType.getVariableLookupElement());
            }
        });
    }
}
