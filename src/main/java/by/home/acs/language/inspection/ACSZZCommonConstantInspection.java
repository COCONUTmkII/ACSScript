package by.home.acs.language.inspection;

import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

//TODO this inspection would be a nightmare without references
public class ACSZZCommonConstantInspection extends AbstractBaseJavaLocalInspectionTool {
    @Override
    public @Nls(capitalization = Nls.Capitalization.Sentence)
    @NotNull
    String getGroupDisplayName() {
        return "ACS constants";
    }

    @Override
    public boolean isEnabledByDefault() {
        return true;
    }

    @Override
    public @NotNull
    PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return null;
    }
}
