package by.home.acs.language.inspection;

import by.home.acs.language.method.ACSZspecialMethodLoader;
import by.home.acs.language.psi.ACSScriptElementFactory;
import by.home.acs.language.psi.ACSScriptFunctionInvocation;
import by.home.acs.language.psi.ACSScriptIncludeDeclaration;
import com.intellij.codeInspection.*;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class ACSZcommonFunctionInspection extends AbstractBaseJavaLocalInspectionTool {
    private static final String DESCRIPTION = "'zcommon.acs' is not included to use this function";


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
                        PsiElement psiDefinition = element.getContainingFile().getFirstChild();
                        Collection<ACSScriptIncludeDeclaration> includeDeclarations = PsiTreeUtil.findChildrenOfType(psiDefinition, ACSScriptIncludeDeclaration.class);
                        if (includeDeclarations.size() == 0) {
                            registerIncludeProblem(myHolder, element);
                        } else {
                            checkIncludeZcommonACSStatement(includeDeclarations, element);
                        }
                    }
                } catch (NullPointerException ignored) {

                }
            }
        }

        private void checkIncludeZcommonACSStatement(Collection<ACSScriptIncludeDeclaration> allIncludes, PsiElement function) {
            allIncludes.forEach(acsScriptIncludeDeclaration -> {
                String includedACS = acsScriptIncludeDeclaration.getString()
                        .getText().substring(1, acsScriptIncludeDeclaration.getString().getText().length() - 1);
                if (!(includedACS.equalsIgnoreCase("zcommon.acs"))) {
                    System.out.println(includedACS);
                    registerIncludeProblem(myHolder, function);
                }
            });
        }

        public boolean checkSomething(PsiElement element) {
            return ACSZspecialMethodLoader.checkZpecialMethod(element.getText());
        }

        public void registerIncludeProblem(ProblemsHolder holder, PsiElement function) {
            holder.registerProblem(function, DESCRIPTION, ProblemHighlightType.LIKE_UNKNOWN_SYMBOL, new ACSZcommonIncludeFix());
        }
    }

    private static class ACSZcommonIncludeFix implements LocalQuickFix {

        @Override
        public @IntentionFamilyName
        @NotNull
        String getFamilyName() {
            return ACSInspectionBundle.message("acs.inspection.zcommon.include");
        }

        @Override
        public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
            PsiElement includeStatement = ACSScriptElementFactory.createIncludeStatement(project, "zcommon.acs");
            PsiElement psi = descriptor.getPsiElement().getContainingFile().getFirstChild();
            if (psi instanceof PsiWhiteSpace) {
                psi.replace(includeStatement);
            } else {
                descriptor.getPsiElement().getContainingFile().addBefore(includeStatement, psi);
            }
            System.out.println(psi);
        }
    }

}
