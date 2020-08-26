package by.home.acs.language.refactor;

import by.home.acs.language.psi.ACSScriptDefinition;
import by.home.acs.language.psi.ACSScriptFile;
import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.intellij.refactoring.RefactoringActionHandler;
import com.intellij.refactoring.changeSignature.ChangeSignatureHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ACSScriptRefactoringSupportProvider extends RefactoringSupportProvider {

    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement elementToRename, @Nullable PsiElement context) {
        return (elementToRename instanceof ACSScriptFile);
    }

    @Override
    public boolean isAvailable(@NotNull PsiElement context) {
        return context instanceof ACSScriptFile;
    }

    @Override
    public boolean isSafeDeleteAvailable(@NotNull PsiElement element) {
        return element instanceof ACSScriptFile;
    }

    @Nullable
    @Override
    public RefactoringActionHandler getIntroduceVariableHandler() {
        return super.getIntroduceVariableHandler();
    }

    @Nullable
    @Override
    public RefactoringActionHandler getIntroduceVariableHandler(PsiElement element) {
        return super.getIntroduceVariableHandler(element);
    }

    @Nullable
    @Override
    public RefactoringActionHandler getExtractMethodHandler() {
        return super.getExtractMethodHandler();
    }

    @Nullable
    @Override
    public RefactoringActionHandler getIntroduceConstantHandler() {
        return super.getIntroduceConstantHandler();
    }

    @Nullable
    @Override
    public RefactoringActionHandler getIntroduceFieldHandler() {
        return super.getIntroduceFieldHandler();
    }

    @Nullable
    @Override
    public RefactoringActionHandler getIntroduceParameterHandler() {
        return super.getIntroduceParameterHandler();
    }

    @Nullable
    @Override
    public RefactoringActionHandler getIntroduceFunctionalParameterHandler() {
        return super.getIntroduceFunctionalParameterHandler();
    }

    @Override
    public RefactoringActionHandler getIntroduceFunctionalVariableHandler() {
        return super.getIntroduceFunctionalVariableHandler();
    }

    @Nullable
    @Override
    public RefactoringActionHandler getPullUpHandler() {
        return super.getPullUpHandler();
    }

    @Nullable
    @Override
    public RefactoringActionHandler getPushDownHandler() {
        return super.getPushDownHandler();
    }

    @Nullable
    @Override
    public RefactoringActionHandler getExtractInterfaceHandler() {
        return super.getExtractInterfaceHandler();
    }

    @Nullable
    @Override
    public RefactoringActionHandler getExtractModuleHandler() {
        return super.getExtractModuleHandler();
    }

    @Nullable
    @Override
    public RefactoringActionHandler getExtractSuperClassHandler() {
        return super.getExtractSuperClassHandler();
    }

    @Nullable
    @Override
    public ChangeSignatureHandler getChangeSignatureHandler() {
        return super.getChangeSignatureHandler();
    }

    @Override
    public boolean isInplaceRenameAvailable(@NotNull PsiElement element, PsiElement context) {
        return element instanceof ACSScriptFile;
    }

    @Override
    public boolean isInplaceIntroduceAvailable(@NotNull PsiElement element, PsiElement context) {
        return element instanceof ACSScriptFile;
    }

    @Nullable
    @Override
    public RefactoringActionHandler getExtractClassHandler() {
        return super.getExtractClassHandler();
    }
}
