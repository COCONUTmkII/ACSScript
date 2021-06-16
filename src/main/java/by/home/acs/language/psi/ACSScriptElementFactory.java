package by.home.acs.language.psi;

import by.home.acs.language.ACSScriptLanguage;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class ACSScriptElementFactory {
    public static ACSScriptDefinition createScript(Project project, String name) {
        final ACSScriptFile file = createACSFile(project, name);

        return (ACSScriptDefinition) file.getFirstChild(); //maybe not first child here
    }

    public static ACSScriptFile createACSFile(Project project, String text) {
        String name = "script.acs";
        return (ACSScriptFile) PsiFileFactory.getInstance(project)
            .createFileFromText(name, ACSScriptLanguage.INSTANCE, text);
    }
}
