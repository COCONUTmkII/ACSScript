package by.home.acs.language.util.psi;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;

public class ACSScriptPsiImplUtil {
    public static String getName(ACSScriptDefinition scriptElement) {
        PsiFile containingFile = scriptElement.getContainingFile();
        ACSScriptScriptName scriptName = PsiTreeUtil.findChildOfType(containingFile, ACSScriptScriptName.class);
        if (scriptName != null) {
            System.out.println(scriptName.getText());
            return scriptName.getText().replaceAll("\\\\ ", "");
        } else {
            return null;
        }
    }

    //FIXME throws exception
    public static PsiElement setName(ACSScriptDefinition scriptWord, String newScriptName) {
        PsiFile containingFile = scriptWord.getContainingFile();
        ACSScriptScriptName scriptName = PsiTreeUtil.findChildOfType(containingFile, ACSScriptScriptName.class);
        if (scriptName != null) {
            ACSScriptScriptDefinition acsScriptDefinition = ACSScriptElementFactory.createScript(scriptWord.getProject(), newScriptName);
            scriptName.replace(acsScriptDefinition);
        } else {
            System.out.println("Null");
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
        System.out.println("LOLOLOLO");
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

    public static PsiElement getFunctionInvocation(ACSScriptDefinition element) {
        System.out.println("SSS?");
        PsiFile containingFile = element.getContainingFile();
        ACSScriptFunctionInvocation functionInvocation = PsiTreeUtil.findChildOfType(containingFile, ACSScriptFunctionInvocation.class);
        if (functionInvocation != null) {
            System.out.println("HEHE BOI");
            return functionInvocation;
        } else {
            return null;
        }
    }
}
