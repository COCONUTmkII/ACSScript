package by.home.acs.language.inspection;

import by.home.acs.language.psi.ACSScriptElementFactory;
import by.home.acs.language.psi.ACSScriptFunctionInvocation;
import by.home.acs.language.psi.ACSScriptIncludeDeclaration;
import by.home.acs.language.psi.visitor.ACSIncludeDeclarationVisitor;
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

import static by.home.acs.language.util.ACSUtil.checkPsiElementIsZspecialFunction;

public class ACSZcommonFunctionInspection extends AbstractBaseJavaLocalInspectionTool {
    private static final String DESCRIPTION = "'zcommon.acs' is not included to use this function";


    @Override
    @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    public String getGroupDisplayName() {
        return "ACS zcommon functions";
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

    //maybe I can refactor everything with ACSIncludeDeclarationVisitor instead of static class?
    public static class ACSPsiVisitor extends PsiElementVisitor {
        private final ProblemsHolder myHolder;

        public ACSPsiVisitor(ProblemsHolder holder) {
            this.myHolder = holder;
        }

        @Override
        public void visitElement(@NotNull PsiElement element) {
            super.visitElement(element);
            if (element instanceof ACSScriptFunctionInvocation) {
                PsiElement typeElement = element.getFirstChild().getFirstChild();
                boolean isZspecialFunction = checkPsiElementIsZspecialFunction(typeElement);
                if (isZspecialFunction) {
                    PsiElement psiFile = element.getContainingFile();
                    psiFile.accept(new ACSIncludeDeclarationVisitor());
                    Collection<ACSScriptIncludeDeclaration> includeDeclarations = PsiTreeUtil.findChildrenOfType(psiFile, ACSScriptIncludeDeclaration.class);
                    if (includeDeclarations.size() == 0) {
                        registerIncludeProblem(myHolder, element);
                    } else {
                        checkIncludeZcommonACSStatement(includeDeclarations, element);
                    }
                }
            }
        }

        private void checkIncludeZcommonACSStatement(Collection<ACSScriptIncludeDeclaration> allIncludes, PsiElement function) {
            allIncludes.forEach(acsScriptIncludeDeclaration -> {
                String includedACS = acsScriptIncludeDeclaration.getString()
                        .getText().substring(1, acsScriptIncludeDeclaration.getString().getText().length() - 1);
                if (!(includedACS.equalsIgnoreCase("zcommon.acs"))) {
                    registerIncludeProblem(myHolder, function);
                }
            });
        }

        private void registerIncludeProblem(ProblemsHolder holder, PsiElement function) {
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
