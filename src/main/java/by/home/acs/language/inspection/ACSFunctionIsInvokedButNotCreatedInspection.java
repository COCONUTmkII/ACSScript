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
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

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
                PsiElement functionName = element.getFirstChild().getFirstChild();
                boolean isZspecialFunction = checkIsFunctionBuiltInWithZcommon(functionName);
                boolean isBuiltInFunction = checkIsFunctionBuiltIn(functionName);
                if (!(isZspecialFunction || isBuiltInFunction)) {
                    checkIsFunctionDeclared(functionName);
                }
            }
        }

        private boolean checkIsFunctionBuiltInWithZcommon(PsiElement functionName) {
            return ACSUtil.checkPsiElementIsZspecialFunction(functionName);
        }

        private boolean checkIsFunctionBuiltIn(PsiElement functionName) {
            return ACSUtil.checkPsiElementIsBuiltInFunction(functionName);
        }

        private void checkIsFunctionDeclared(PsiElement functionName) {
            PsiFile currentFile = functionName.getContainingFile();
            String fileName = currentFile.getName();
            currentFile.accept(new ACSFunctionDefinitionVisitor());
            Collection<ACSScriptFunctionDefinition> functionDefinitions = PsiTreeUtil.findChildrenOfType(currentFile, ACSScriptFunctionDefinition.class);
            String functionNameAsString = functionName.getText();
            String DESCRIPTION = ACSInspectionBundle.message("acs.inspection.function.invoke.not.created", functionNameAsString, fileName);
            if (functionDefinitions.size() == 0) {
                checkIsFunctionDeclaredInImport(functionName);
                registerFunctionInvokeProblem(functionName, DESCRIPTION, functionNameAsString, fileName);
            } else {
                boolean isFind = findInvokedFunctionInFunctionDefinitions(functionDefinitions, functionNameAsString);
                if (!isFind) {
                    registerFunctionInvokeProblem(functionName, DESCRIPTION, functionNameAsString, fileName);
                }

            }
        }

        //TODO find info how to do that. Maybe reference contributor?
        private void checkIsFunctionDeclaredInImport(PsiElement element) {

        }


        private void registerFunctionInvokeProblem(PsiElement element, String description, String functionName, String fileName) {
            holder.registerProblem(element, description, ProblemHighlightType.GENERIC_ERROR, new ACSFunctionIsInvokedButNotCreatedFix(functionName, fileName, "void", List.of("void")));
        }

        private boolean findInvokedFunctionInFunctionDefinitions(Collection<ACSScriptFunctionDefinition> functionDefinitions, String currentFunction) {
            return functionDefinitions.stream().anyMatch(acsScriptFunctionDefinition -> acsScriptFunctionDefinition.getFunctionName().getText().equals(currentFunction));
        }


        private static class ACSFunctionIsInvokedButNotCreatedFix implements LocalQuickFix {
            private final String functionName;
            private final String fileName;
            private final String functionReturnType;
            private final List<String> functionParameter;

            public ACSFunctionIsInvokedButNotCreatedFix(String functionName, String fileName, String functionReturnType, List<String> functionParameter) {
                this.functionName = functionName;
                this.fileName = fileName;
                this.functionReturnType = functionReturnType;
                this.functionParameter = functionParameter;
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
                ACSScriptFunctionDefinition functionWithProvidedName = ACSScriptElementFactory.createFunctionWithProvidedName(project, functionName, functionReturnType, functionParameter);
                if (lastChild instanceof PsiWhiteSpace) {
                    lastChild.replace(functionWithProvidedName);
                } else {
                    lastChild.addAfter(functionWithProvidedName, lastChild);
                }
            }
        }
    }
}
