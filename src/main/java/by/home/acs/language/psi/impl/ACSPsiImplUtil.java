package by.home.acs.language.psi.impl;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSScriptDefinition;
import com.intellij.lang.ASTNode;

public class ACSPsiImplUtil {
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
}
