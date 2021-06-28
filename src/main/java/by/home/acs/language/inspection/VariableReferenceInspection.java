package by.home.acs.language.inspection;

import by.home.acs.language.psi.ACSScriptVariableDefinition;
import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import static by.home.acs.language.ACSScriptTypes.*;
import static by.home.acs.language.util.PsiHelper.psiEquals;

public class VariableReferenceInspection extends AbstractBaseJavaLocalInspectionTool {
    public static final String DESCRIPTION = "typecast compilable, but it can lead to errors";
    public static final String QUICK_FIX_NAME = "change variable type to";

    @Override
    @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    public String getGroupDisplayName() {
        return "ACS type-cast";
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }

    @Override
    public @NotNull
    PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new TestPsiVisitor(holder);
    }

    public static class TestPsiVisitor extends PsiElementVisitor {
        private final ProblemsHolder myHolder;

        public TestPsiVisitor(ProblemsHolder holder) {
            this.myHolder = holder;
        }

        @Override
        public void visitElement(@NotNull PsiElement element) {
            super.visitElement(element);
            if (element instanceof ACSScriptVariableDefinition) {
                PsiElement typeElement = element.getFirstChild().getFirstChild().getFirstChild().getFirstChild();
                PsiElement initializedType = element.getNavigationElement().getLastChild().getPrevSibling().getFirstChild();
                boolean isProblemNeeded = checkVariableTypes(typeElement, initializedType);
                if (isProblemNeeded) {
                    myHolder.registerProblem(element, DESCRIPTION, new MyQuickFix());
                }
            }
        }

        private boolean checkVariableTypes(PsiElement variableType, PsiElement variableInitializedType) {
            if (psiEquals(variableType, INT) && (!psiEquals(variableInitializedType, NUMBER, FLOAT, CHARACTER))) {
                return true;
            } else return psiEquals(variableType, STR) && (!psiEquals(variableInitializedType, STRING));
        }
    }


    private static class MyQuickFix implements LocalQuickFix {

        @Override
        public @IntentionFamilyName
        @NotNull
        String getFamilyName() {
            return QUICK_FIX_NAME;
        }

        @Override
        public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
            System.out.println("Applying fix");
        }
    }
}


