package by.home.acs.language.util.psi;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSScriptDefinition;
import by.home.acs.language.psi.ACSScriptElementFactory;
import by.home.acs.language.psi.ACSScriptScriptDefinition;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

public class ACSScriptPsiImplUtil {
    public static String getName(ACSScriptDefinition scriptElement) {
        ASTNode scriptNode = scriptElement.getNode().findChildByType(ACSScriptTypes.SCRIPT_NAME);
        if (scriptNode != null) {
            return scriptNode.getText().replaceAll("\\\\ ", "");
        } else {
            return null;
        }
    }

    public static PsiElement setName(ACSScriptDefinition scriptWord, String newScriptName) {
        ASTNode currentNameNode = scriptWord.getNode().findChildByType(ACSScriptTypes.SCRIPT_NAME);
        if (currentNameNode != null) {
            ACSScriptDefinition acsScriptDefinition = ACSScriptElementFactory.createScript(scriptWord.getProject(), newScriptName);
            ASTNode newNameNode = acsScriptDefinition.getFirstChild().getNode(); //maybe change this
            scriptWord.getNode().replaceChild(currentNameNode, newNameNode);
        } else {
            System.out.println("null");
        }
        return scriptWord;
    }


    public static String getIdentifier(ACSScriptScriptDefinition element) {
        ASTNode identifier = element.getNode().findChildByType(ACSScriptTypes.IDENTIFIER);
        if (identifier != null) {
            return identifier.getText().replaceAll("\\\\", " "); //not sure
        } else  {
            return null;
        }
    }

    public static String getFunctionKeyword(ACSScriptDefinition element) {
        ASTNode functionKeywordNode = element.getNode().findChildByType(ACSScriptTypes.FUNCTION);
        if (functionKeywordNode != null) {
            return functionKeywordNode.getText();
        } else {
            return null;
        }
    }

    public static String getFunctionStatementReturnType(ACSScriptDefinition element) {
        ASTNode functionReturnType = element.getNode().findChildByType(ACSScriptTypes.FUNCTION_RETURN_TYPE);
        if (functionReturnType != null) {
            return functionReturnType.getText();
        } else {
            return null;
        }
    }

    public static PsiElement getNameIdentifier(ACSScriptDefinition scriptWord) {
        ASTNode keyNode = scriptWord.getNode().findChildByType(ACSScriptTypes.SCRIPT_NAME);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
}
