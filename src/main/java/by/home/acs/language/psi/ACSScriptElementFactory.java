package by.home.acs.language.psi;

import by.home.acs.language.ACSScriptLanguage;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiManager;

import java.util.List;

public class ACSScriptElementFactory {
    private static final String ACS_DUMMY = "script.acs";

    public static ACSScriptFile createACSFile(Project project, String text) {
        return (ACSScriptFile) PsiFileFactory.getInstance(project)
                .createFileFromText(ACS_DUMMY, ACSScriptLanguage.INSTANCE, text);
    }

    public static PsiElement createACSKeyword(PsiManager instance, String text) {
        return new ACSKeywordElement(instance, text);
    }

    //FIXME try to implement this without \n cuz this is bad code
    public static PsiElement createIncludeStatement(Project project, String includeFileName) {
        return PsiFileFactory.getInstance(project)
                .createFileFromText(ACS_DUMMY, ACSScriptLanguage.INSTANCE, "#include \"" + includeFileName + "\"\n\n");
    }

    //TODO check parameters. If not void - create extra field with parameter name
    public static ACSScriptFunctionDefinition createFunctionWithProvidedName(Project project, String functionName, String functionReturnType, List<String> parameters) {
        return (ACSScriptFunctionDefinition) PsiFileFactory.getInstance(project)
                .createFileFromText(ACS_DUMMY, ACSScriptLanguage.INSTANCE, "function " + functionReturnType
                        + " " + functionName + "(" + "int a" + ")" + "{" + "}").getFirstChild().getFirstChild();
    }

    public static ACSScriptScriptDefinition createScript(Project project, String newScriptName) {
        return (ACSScriptScriptDefinition) PsiFileFactory.getInstance(project)
                .createFileFromText(ACS_DUMMY, ACSScriptLanguage.INSTANCE, "script \"" + newScriptName + "\" OPEN NET {}").getFirstChild().getFirstChild();
    }

    public static ACSScriptFunctionDefinition createSimpleFunction(Project project, String functionName) {
        return (ACSScriptFunctionDefinition) PsiFileFactory.getInstance(project)
                .createFileFromText(ACS_DUMMY, ACSScriptLanguage.INSTANCE, "function void " + functionName + "(void){}").getFirstChild().getFirstChild();
    }

    public static ACSScriptVariableDefinition createDummyVariable(Project project, String variableName) {
        return (ACSScriptVariableDefinition) PsiFileFactory.getInstance(project)
                .createFileFromText(ACS_DUMMY, ACSScriptLanguage.INSTANCE, "int " + variableName + " =1;").getFirstChild().getFirstChild();
    }
}
