package by.home.acs.language.inspection;

import by.home.acs.language.psi.ACSScriptElementFactory;
import by.home.acs.language.psi.ACSScriptFunctionDefinition;
import by.home.acs.language.psi.ACSScriptFunctionInvocation;
import by.home.acs.language.psi.visitor.ACSFunctionDefinitionVisitor;
import by.home.acs.language.util.ACSUtil;
import com.intellij.codeInspection.*;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class ACSFunctionIsInvokedButNotCreatedInspection extends AbstractBaseJavaLocalInspectionTool {

    @Override
    public @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    String getGroupDisplayName() {
        return "ACS functions";
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }

    @Override
    public @NotNull
    PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return new ACSFunctionInvocationVisitor(holder);
    }

    private static class ACSFunctionInvocationVisitor extends PsiElementVisitor {
        private final ProblemsHolder holder;

        public ACSFunctionInvocationVisitor(ProblemsHolder holder) {
            this.holder = holder;
        }

        @Override
        public void visitElement(@NotNull PsiElement element) {
            super.visitElement(element);
            if (element instanceof ACSScriptFunctionInvocation) {
                boolean isZspecialFunction = checkIsFunctionBuiltInWithZcommon(element);
                if (!isZspecialFunction) {
                    checkIsFunctionDeclared(element);
                }
            }
        }

        private boolean checkIsFunctionBuiltInWithZcommon(PsiElement functionInvocation) {
            PsiElement functionName = functionInvocation.getFirstChild().getFirstChild();
            return ACSUtil.checkPsiElementIsZspecialFunction(functionName);
        }

        private void checkIsFunctionDeclared(PsiElement element) {
            PsiFile currentFile = element.getContainingFile();
            String fileName = currentFile.getName();
            currentFile.accept(new ACSFunctionDefinitionVisitor());
            Collection<ACSScriptFunctionDefinition> functionDefinitions = PsiTreeUtil.findChildrenOfType(currentFile, ACSScriptFunctionDefinition.class);
            String functionName = element.getFirstChild().getFirstChild().getText();
            String DESCRIPTION = ACSInspectionBundle.message("acs.inspection.function.invoke.not.created", functionName, fileName);

            if (functionDefinitions.size() == 0) {
                checkIsFunctionDeclaredInImport(element);
                registerFunctionInvokeProblem(element, DESCRIPTION, functionName, fileName);
            } else {
                boolean isFind = findInvokedFunctionInFunctionDefinitions(functionDefinitions, functionName);
                if (!isFind) {
                    registerFunctionInvokeProblem(element, DESCRIPTION, functionName, fileName);
                }
            }
        }

        //TODO find info how to do that. Maybe reference contributor?
        private void checkIsFunctionDeclaredInImport(PsiElement element) {
//
        }

        private void registerFunctionInvokeProblem(PsiElement element, String description, String functionName, String fileName) {
            holder.registerProblem(element, description, ProblemHighlightType.GENERIC_ERROR, new ACSFunctionIsInvokedButNotCreatedFix(functionName, fileName));
        }

        private boolean findInvokedFunctionInFunctionDefinitions(Collection<ACSScriptFunctionDefinition> functionDefinitions, String currentFunction) {
            return functionDefinitions.stream().anyMatch(acsScriptFunctionDefinition -> acsScriptFunctionDefinition.getFunctionNameAndParams().getIdentifier().getText().equals(currentFunction));
        }


        private static class ACSFunctionIsInvokedButNotCreatedFix implements LocalQuickFix {
            private final String functionName;
            private final String fileName;

            public ACSFunctionIsInvokedButNotCreatedFix(String functionName, String fileName) {
                this.functionName = functionName;
                this.fileName = fileName;
            }

            @Override
            public @IntentionFamilyName
            @NotNull
            String getFamilyName() {
                return ACSInspectionBundle.message("acs.inspection.function.invoke.create", functionName, fileName);
            }

            @Override
            public void applyFix(@NotNull Project project, @NotNull ProblemDescriptor descriptor) {
                PsiFile psiFile = descriptor.getPsiElement().getContainingFile();
                PsiElement lastChild = psiFile.getLastChild();
                if (lastChild instanceof PsiWhiteSpace) {
                    lastChild.addAfter(ACSScriptElementFactory.createFunctionWithProvidedName(project, functionName, "void", "void"), new PsiWhiteSpaceImpl(""));
                    System.out.println("==============================");
                    System.out.println(lastChild);
                    System.out.println("==============================");

                    System.out.println("==============================");
                    /*PsiElement newLastChild = descriptor.getPsiElement().getContainingFile().getLastChild();
                    lastChild.addAfter(newLastChild, ACSScriptElementFactory
                            .createFunctionWithProvidedName(project, functionName, "void", "void"));*/
//                    lastChild.addAfter(ACSScriptElementFactory.createFunctionWithProvidedName(project, functionName, "void", "void"));
                }
//                System.out.println(lastChild);
            }

        }
    }
}
