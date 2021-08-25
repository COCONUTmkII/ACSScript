package by.home.acs.language.annotator;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSScriptScriptName;
import by.home.acs.language.util.psi.PsiHelper;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class ACSScriptNumberAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {


        if (!(element instanceof ACSScriptScriptName)) {
            return;
        }

        ACSScriptScriptName acsScriptScriptName = (ACSScriptScriptName) element;
        if (PsiHelper.psiEquals(acsScriptScriptName.getFirstChild(), ACSScriptTypes.NUMBER)) {
            try {
                checkScript(acsScriptScriptName.getNode(), holder);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkScript(ASTNode astNode, @NotNull AnnotationHolder holder) {
        BigInteger maxScriptNumber = BigInteger.valueOf(32767);
        BigInteger scriptNumber = new BigInteger(astNode.getText());
        if (scriptNumber.compareTo(BigInteger.ONE) < 0 || scriptNumber.compareTo(maxScriptNumber) > 0) {
            createScriptNumberErrorAnnotator(astNode, holder);
        }
    }

    private void createScriptNumberErrorAnnotator(ASTNode astNode, @NotNull AnnotationHolder holder) {
        TextRange textRange = new TextRange(astNode.getStartOffset(), astNode.getTextRange().getEndOffset());
        holder.newAnnotation(HighlightSeverity.ERROR, "Script number can be only > 1 and < 32767 inclusive")
                .range(textRange)
                .highlightType(ProblemHighlightType.ERROR)
                .create();
    }
}
