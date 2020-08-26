package by.home.acs.language.psi;

import by.home.acs.language.ACSScriptFileDefinition;
import by.home.acs.language.ACSScriptType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class ACSScriptElementFactory {
    public static ACSScriptDefinition createScript(Project project, String name) { // rename name if it works
        final ACSScriptFile file = createACSFile(project, name);
        return (ACSScriptDefinition) file.getFirstChild();
    }

    public static ACSScriptFile createACSFile(Project project, String text) {
        String name = "simple.acs";
        return (ACSScriptFile) PsiFileFactory.getInstance(project)
                .createFileFromText(name, ACSScriptType.INSTANCE, text);
    }
}
