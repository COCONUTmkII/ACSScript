package by.home.acs.language.psi.impl;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSScriptDefinition;
import com.intellij.lang.ASTNode;

public class ACSPsiImplUtil {
    public static String getFunctionReturnType(ACSScriptDefinition element) {
        ASTNode functionReturnTypeNode = element.getNode().findChildByType(ACSScriptTypes.FUNCTION_RETURN_TYPE);
        if (functionReturnTypeNode != null) {
            return functionReturnTypeNode.getText();
        } else {
            return null;
        }
    }
}
