package by.home.acs.language.psi;

import by.home.acs.language.ACSScriptLanguage;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;

public class ACSScriptElementFactory {
    public static ACSScriptScriptIdentifier createScript(Project project, String name) {
        final ACSScriptFile file = createACSFile(project, name);

        return (ACSScriptScriptIdentifier) file.getFirstChild();
    }

    public static ACSScriptFile createACSFile(Project project, String text) {
        String name = "script.acs";
        return (ACSScriptFile) PsiFileFactory.getInstance(project)
                //.createFileFromText(ACSScriptType.INSTANCE, text);
            .createFileFromText(ACSScriptLanguage.INSTANCE, text);
    }
}
