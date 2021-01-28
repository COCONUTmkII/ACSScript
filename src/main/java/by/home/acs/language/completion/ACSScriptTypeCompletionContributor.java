package by.home.acs.language.completion;

import by.home.acs.language.ACSScriptLanguage;
import by.home.acs.language.ACSScriptTypes;
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
    public ACSScriptTypeCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ACSScriptTypes.SCRIPT_PARAMETER), new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                result.addElement(LookupElementBuilder.create("OPEN"));
                result.addElement(LookupElementBuilder.create("ENTER"));
                result.addElement(LookupElementBuilder.create("RETURN"));
                result.addElement(LookupElementBuilder.create("DEATH"));
                result.addElement(LookupElementBuilder.create("RESPAWN"));
                result.addElement(LookupElementBuilder.create("LIGHTNING"));
                result.addElement(LookupElementBuilder.create("UNLOADING"));
                result.addElement(LookupElementBuilder.create("KILL"));
                result.addElement(LookupElementBuilder.create("REOPEN"));
                result.addElement(LookupElementBuilder.create("DISCONNECT"));
            }
        });
    }
}
