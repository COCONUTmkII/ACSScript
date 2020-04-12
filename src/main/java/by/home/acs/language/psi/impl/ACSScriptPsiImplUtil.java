package by.home.acs.language.psi.impl;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSScriptScriptDefinition;
import com.intellij.lang.ASTNode;

public class ACSScriptPsiImplUtil {
    public static String getScript (ACSScriptScriptDefinition scriptElement) {
        ASTNode scriptNode = scriptElement.getNode().findChildByType(ACSScriptTypes.SCRIPT);
        if (scriptNode != null) {
            return scriptNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getScriptNumberValue (ACSScriptScriptDefinition scriptElement) {
        ASTNode scriptValueNode = scriptElement.getNode().findChildByType(ACSScriptTypes.NUMBER);
        if (scriptValueNode != null) {
            return scriptValueNode.getText();
        } else {
            return null;
        }
    }
}
