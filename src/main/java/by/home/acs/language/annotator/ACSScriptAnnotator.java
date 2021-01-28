package by.home.acs.language.annotator;
import by.home.acs.language.ACSUtil;
import by.home.acs.language.highlight.ACSScriptTextAttributeKeyValue;
import by.home.acs.language.psi.ACSScriptDefinition;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralValue;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class ACSScriptAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof PsiLiteralValue)) return;
        PsiLiteralValue psiLiteralValue = (PsiLiteralValue) element;
        String value  = psiLiteralValue.getValue() instanceof String ? (String) psiLiteralValue.getValue() : null;
        if ((value == null) || !value.startsWith(ACSScriptAnnotatorPrefix.SCRIPT_LOWERCASE_PREFIX)) return;
        TextRange prefixRange = TextRange.from(element.getTextRange().getStartOffset(), ACSScriptAnnotatorPrefix.SCRIPT_LOWERCASE_PREFIX.length() + 1);
        TextRange scriptTypeRange = TextRange.from(prefixRange.getEndOffset(), ACSScriptAnnotatorPrefix.SCRIPT_LOWERCASE_PREFIX.length());
        TextRange scriptNumberRange = new TextRange(scriptTypeRange.getEndOffset(), element.getTextRange().getEndOffset() - 1);

        String possibleScriptRange = value.substring(ACSScriptAnnotatorPrefix.SCRIPT_LOWERCASE_PREFIX.length() + ACSScriptAnnotatorPrefix.SCRIPT_LOWERCASE_PREFIX.length() + 1); //Might not work
        Project project = element.getProject();
        List<ACSScriptDefinition> script = ACSUtil.findScript(project, possibleScriptRange); //Might cause error

        Annotation scriptAnnotation = holder.createInfoAnnotation(prefixRange, null);
        scriptAnnotation.setTextAttributes(DefaultLanguageHighlighterColors.KEYWORD);
        Annotation scriptNumberAnnotation = holder.createInfoAnnotation(prefixRange, null);
        scriptNumberAnnotation.setTextAttributes(DefaultLanguageHighlighterColors.NUMBER);
        if (script.isEmpty()) {
            Annotation bad = holder.createErrorAnnotation(scriptNumberRange, "Unresolved");
            bad.setTextAttributes(ACSScriptTextAttributeKeyValue.BAD_CHARACTER);
            // NOT Registered quick fix!!!
        } else {
            Annotation annotation = holder.createInfoAnnotation(scriptNumberRange, null);
            annotation.setTextAttributes(ACSScriptTextAttributeKeyValue.INT_VALUE);
        }
    }
}