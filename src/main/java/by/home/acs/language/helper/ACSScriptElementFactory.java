package by.home.acs.language.helper;

import by.home.acs.language.ACSScriptType;
import by.home.acs.language.psi.ACSScriptFile;
import by.home.acs.language.psi.ACSScriptScriptDefinition;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class ACSScriptElementFactory {
    public static ACSScriptScriptDefinition createScript(Project project, String name) { // rename name if it works
        final ACSScriptFile file = createACSFile(project, name);
        return (ACSScriptScriptDefinition) file.getFirstChild();
    }

    public static ACSScriptFile createACSFile(Project project, String text) {
        String name = "simple.acs";
        return (ACSScriptFile) PsiFileFactory.getInstance(project)
                .createFileFromText(name, ACSScriptType.INSTANCE, text);
    }
}
