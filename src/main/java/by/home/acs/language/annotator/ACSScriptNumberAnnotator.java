package by.home.acs.language.annotator;

import by.home.acs.language.ACSUtil;
import by.home.acs.language.psi.ACSScriptScriptName;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ACSScriptNumberAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {


        if (!(element instanceof ACSScriptScriptName)) {
            return;
        }

        ACSScriptScriptName acsScriptScriptName = (ACSScriptScriptName) element;
        PsiElement stringNumber = acsScriptScriptName.getString();
        PsiElement number = acsScriptScriptName.getNumber();
        if (stringNumber != null || number == null) {
            return;
        }

        try {
            List<ACSScriptScriptName> definitionList = ACSUtil.findScriptName(element.getProject());
            definitionList.forEach(acsScriptName -> {
                ACSScriptScriptName scriptName = Objects.requireNonNull(acsScriptName);
                Optional<ASTNode> scriptNumberNode = Optional.ofNullable(scriptName.getNode());
                scriptNumberNode.ifPresent(astNode -> {
                    TextRange textRange = new TextRange(astNode.getStartOffset(), astNode.getTextRange().getEndOffset());
                    checkScript(astNode, holder, textRange);
                });
            });
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void checkScript(ASTNode astNode, @NotNull AnnotationHolder holder, TextRange textRange) {
        BigInteger maxScriptNumber = BigInteger.valueOf(32767);
        BigInteger scriptNumber = new BigInteger(astNode.getText());
        if (scriptNumber.compareTo(BigInteger.ONE) < 0 || scriptNumber.compareTo(maxScriptNumber) > 0) {
            createScriptNumberErrorAnnotator(textRange, holder);
        }
    }

    private void createScriptNumberErrorAnnotator(TextRange textRange, @NotNull AnnotationHolder holder) {
        holder.newAnnotation(HighlightSeverity.ERROR, "Script number can be only > 1 and < 32767 inclusive")
                .range(textRange)
                .highlightType(ProblemHighlightType.ERROR)
                .create();
    }
}
