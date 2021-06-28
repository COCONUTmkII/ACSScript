package by.home.acs.language.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

import java.util.Arrays;

public class PsiHelper {

    private static final String PSI_ELEMENT_WITH_OPENED_BRACE = "PsiElement(";
    private static final String CLOSED_BRACE = ")";

    public static boolean psiEquals(PsiElement element, IElementType type) {
        return element.toString().equals(PSI_ELEMENT_WITH_OPENED_BRACE + type + CLOSED_BRACE);
    }

    public static boolean psiEquals(PsiElement element, IElementType... type) {
        return Arrays.stream(type).anyMatch(iElementType -> element.toString().equals(PSI_ELEMENT_WITH_OPENED_BRACE + iElementType + CLOSED_BRACE));
    }
}
