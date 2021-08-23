package by.home.acs.language.inspection;

import by.home.acs.language.method.ACSZspecialMethodLoader;
import by.home.acs.language.psi.ACSScriptFunctionInvocation;
import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

public class ACSTestFuncInspection extends AbstractBaseJavaLocalInspectionTool {

    @Override
    @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    public String getGroupDisplayName() {
        return "ACS zcommon methods";
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
            if (element instanceof ACSScriptFunctionInvocation) {
                try {
                    PsiElement typeElement = element.getFirstChild().getFirstChild();
                    boolean isZspecialMethod = checkSomething(typeElement);
                    if (isZspecialMethod) {
                        PsiElement includeDeclaration = element.getContainingFile().getFirstChild();

                        if (includeDeclaration != null) {
                            System.out.println(includeDeclaration);
                        } else {
                            //System.out.println(element.getContainingFile().getNode().getPsi());
                        }
                    }
                } catch (NullPointerException ignored) {

                }
            }
        }

        public boolean checkSomething(PsiElement element) {
            return ACSZspecialMethodLoader.checkZpecialMethod(element.getText());
        }

    }

}
