package by.home.acs.language.psi.impl;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSScriptDefinition;
import by.home.acs.language.psi.ACSScriptElementFactory;
import by.home.acs.language.psi.ACSScriptScriptDefinition;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

public class ACSScriptPsiImplUtil {
    public static String getScript (ACSScriptDefinition scriptElement) {
        ASTNode scriptNode = scriptElement.getNode().findChildByType(ACSScriptTypes.SCRIPT);
        if (scriptNode != null) {
            return scriptNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getScriptNumberValue (ACSScriptDefinition scriptElement) {
        ASTNode scriptValueNode = scriptElement.getNode().findChildByType(ACSScriptTypes.NUMBER);
        if (scriptValueNode != null) {
            return scriptValueNode.getText();
        } else {
            return null;
        }
    }

    public static String getScriptWord(ACSScriptDefinition scriptWord) {
        return getScript(scriptWord);
    }

    public static PsiElement setScriptWord(ACSScriptScriptDefinition scriptWord, String newScript) {
        ASTNode keyNode = scriptWord.getNode().findChildByType(ACSScriptTypes.SCRIPT);
        if (keyNode != null) {
            ACSScriptDefinition script = ACSScriptElementFactory.createScript(scriptWord.getProject(), newScript);
            ASTNode newKeyNode = script.getFirstChild().getNode();
            scriptWord.getNode().replaceChild(keyNode, newKeyNode);
        }
        return scriptWord;
    }

    public static PsiElement getScriptIdentifier(ACSScriptScriptDefinition scriptWord) {
        ASTNode keyNode = scriptWord.getNode().findChildByType(ACSScriptTypes.SCRIPT);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }
}
