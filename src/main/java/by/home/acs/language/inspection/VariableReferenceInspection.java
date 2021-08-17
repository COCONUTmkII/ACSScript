package by.home.acs.language.inspection;

import by.home.acs.language.psi.ACSScriptElementFactory;
import by.home.acs.language.psi.ACSScriptVariableDefinition;
import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.ProblemDescriptor;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import static by.home.acs.language.ACSScriptTypes.*;
import static by.home.acs.language.util.PsiHelper.psiEquals;

public class VariableReferenceInspection extends AbstractBaseJavaLocalInspectionTool {
    public static final String DESCRIPTION = "typecast compilable, but it may lead to errors";

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
        return new ACSPsiVisitor(holder);
    }

    public static class ACSPsiVisitor extends PsiElementVisitor {
        private final ProblemsHolder myHolder;

        public ACSPsiVisitor(ProblemsHolder holder) {
            this.myHolder = holder;
        }

        @Override
        public void visitElement(@NotNull PsiElement element) {
            super.visitElement(element);
            if (element instanceof ACSScriptVariableDefinition) {
                try {
                    PsiElement typeElement = element.getFirstChild().getFirstChild().getFirstChild().getFirstChild();
                    PsiElement initializedType = element.getNavigationElement().getLastChild().getPrevSibling().getFirstChild();
                    checkVariableTypes(element, typeElement, initializedType);
                } catch (NullPointerException ignored) {

                }
            }
        }

        //TODO refactor this mess...
        private void checkVariableTypes(PsiElement currentElement, PsiElement variableType, PsiElement variableInitializedType) {
            if (psiEquals(variableType, INT) && (!psiEquals(variableInitializedType, NUMBER, FLOAT, CHARACTER))) {
                myHolder.registerProblem(currentElement, DESCRIPTION, new ACSVariableTypeFix("str", "int"));
            } else if (psiEquals(variableType, STR) && (!psiEquals(variableInitializedType, STRING))) {
                myHolder.registerProblem(currentElement, DESCRIPTION, new ACSVariableTypeFix("int", "str"));
            } else if (psiEquals(variableType, BOOL) && psiEquals(variableInitializedType, STRING)) {
                myHolder.registerProblem(currentElement, DESCRIPTION, new ACSVariableTypeFix("str", "bool"));
            }
        }
    }

    private static class ACSVariableTypeFix implements LocalQuickFix {
        private final String newVariableType;
        private final String currentVariableType;

        public ACSVariableTypeFix(String newVariableType, String currentVariableType) {
            this.newVariableType = newVariableType;
            this.currentVariableType = currentVariableType;
        }

        @Override
        public @IntentionFamilyName
        @NotNull
        String getFamilyName() {
            return ACSInspectionBundle.message("acs.inspection.comparing.variable.type-cast", currentVariableType, newVariableType);
        }

        @Override
        public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
            PsiManager instance = PsiManager.getInstance(project);
            PsiElement newKeyword = ACSScriptElementFactory.createACSKeyword(instance, newVariableType);
            descriptor.getPsiElement().getFirstChild().getFirstChild().getFirstChild().getFirstChild()
                    .replace(newKeyword);
        }
    }
}


