package by.home.acs.language.annotator;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.highlight.ACSScriptTextAttributeKeyValue;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import java.util.*;

import static by.home.acs.language.annotator.ACSScriptAnnotatorPrefix.SCRIPT_LOWERCASE_PREFIX;

public class ACSScriptNumberAnnotator implements Annotator {
    private boolean testOne = false;
    private boolean testTwo = false;
    private final TextRange textRange
            = TextRange.from(SCRIPT_LOWERCASE_PREFIX.length(), SCRIPT_LOWERCASE_PREFIX.length() + 1);
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        try {
            List<IElementType> iElementTypes = new ArrayList<>();
            iElementTypes.add(element.getNode().getFirstChildNode().getElementType());
            for (IElementType i : iElementTypes) {
                if (i.equals(ACSScriptTypes.SCRIPT_IDENTIFIER)) {
                    testOne = true;
                    continue;
                }
                if (i.equals(ACSScriptTypes.NUMBER)) {
                    testTwo = true;
                    if (testOne && testTwo) {
                        ASTNode node = element.getNode();
                        checkScriptNumberRange(node, holder);
                        testOne = false;
                        testTwo = false;
                    }
                }
            }
        } catch (NullPointerException | NumberFormatException e) {
            e.getCause();
        }
    }

    private void checkScriptNumberRange(ASTNode node, @NotNull AnnotationHolder holder) {
        boolean isVotValid;
        int expectedScriptNumber = Integer.parseInt(node.getText());
        if (expectedScriptNumber < 1 || expectedScriptNumber > 32767) {
            isVotValid = true;
            createScriptNumberAnnotation(holder, isVotValid);
        }
    }

    private void createScriptNumberAnnotation(@NotNull AnnotationHolder holder, boolean isNotValid) throws NumberFormatException{
        if (isNotValid) {
            Annotation annotation = holder.createErrorAnnotation(textRange, "Script number must be > 0 or < 32768");
            annotation.setTextAttributes(ACSScriptTextAttributeKeyValue.BAD_CHARACTER);
        }
    }
}
