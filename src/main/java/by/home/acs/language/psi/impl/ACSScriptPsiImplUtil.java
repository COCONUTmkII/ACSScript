package by.home.acs.language.psi.impl;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSScriptDefinition;
import by.home.acs.language.psi.ACSScriptElementFactory;
import by.home.acs.language.psi.ACSScriptScriptDefinition;
import by.home.acs.language.psi.ACSScriptScriptIdentifier;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

public class ACSScriptPsiImplUtil {
    public static String getScript (ACSScriptScriptDefinition scriptElement) {
        System.out.println("privet");
        ASTNode scriptNode = scriptElement.getNode().findChildByType(ACSScriptTypes.SCRIPT_IDENTIFIER);
        if (scriptNode != null) {
            return scriptNode.getText().replaceAll("\\\\ ", "");
        } else {
            return null;
        }
    }

    public static String getScriptNumberValue (ACSScriptScriptDefinition scriptElement) {
        ASTNode scriptValueNode = scriptElement.getNode().findChildByType(ACSScriptTypes.SCRIPT_IDENTIFIER);
        if (scriptValueNode != null) {
            return scriptValueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(ACSScriptScriptDefinition scriptWord) {
        return getScript(scriptWord);
    }

    public static PsiElement setName(ACSScriptScriptDefinition scriptWord, String newScript) {
        ASTNode keyNode = scriptWord.getNode().findChildByType(ACSScriptTypes.SCRIPT_IDENTIFIER);
        if (keyNode != null) {
            System.out.println("m here!");
            ACSScriptScriptIdentifier script = ACSScriptElementFactory.createScript(scriptWord.getProject(), newScript);
            System.out.println(script + " script ");
            System.out.println(keyNode + "keyNode");
            ASTNode newKeyNode = script.getNode();
            System.out.println(newKeyNode + "newKeyNode");
            scriptWord.getNode().replaceChild(keyNode, newKeyNode);
        }
        return scriptWord;
    }

    public static PsiElement getNameIdentifier(ACSScriptScriptDefinition scriptWord) {
        ASTNode keyNode = scriptWord.getNode().findChildByType(ACSScriptTypes.SCRIPT_IDENTIFIER);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static String getIdentifier(ACSScriptScriptDefinition element) {
        ASTNode identifier = element.getNode().findChildByType(ACSScriptTypes.IDENTIFIER);
        if (identifier != null) {
            return identifier.getText().replaceAll("\\\\", " "); //not sure
        } else  {
            return null;
        }
    }
}
