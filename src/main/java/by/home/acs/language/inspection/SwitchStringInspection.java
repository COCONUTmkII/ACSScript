package by.home.acs.language.inspection;

import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

//TODO implement other and check architecture for flexibility in creation visitor classes
public class SwitchStringInspection extends AbstractBaseJavaLocalInspectionTool {
    public static final String DESCRIPTION = "switch with string parameter is compilable, but it's not working normally in game";

    @Override
    public @NotNull
    PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly) {
        return super.buildVisitor(holder, isOnTheFly);
    }

}
