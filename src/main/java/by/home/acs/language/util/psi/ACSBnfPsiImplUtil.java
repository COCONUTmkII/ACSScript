package by.home.acs.language.util.psi;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.*;
import by.home.acs.language.reference.ACSVariableDefReference;
import by.home.acs.language.util.ACSUtil;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class ACSBnfPsiImplUtil {
    public static String getName(ACSScriptScriptDefinition scriptElement) {
        ASTNode scriptName = scriptElement.getNode().findChildByType(ACSScriptTypes.SCRIPT_NAME);
        if (scriptName != null) {
            return scriptName.getText().replaceAll("\\\\ ", "");
        } else {
            return null;
        }
    }

    public static String getName(ACSScriptFunctionDefinition functionElement) {
        ASTNode scriptName = functionElement.getNode().findChildByType(ACSScriptTypes.FUNCTION_NAME);
        if (scriptName != null) {
            return scriptName.getText();
        } else {
            System.out.println("NULL");
            return null;
        }
    }

    public static String getName(ACSScriptFunctionInvocation functionElement) {
        ASTNode scriptName = functionElement.getNode().findChildByType(ACSScriptTypes.FUNCTION_NAME);
        if (scriptName != null) {
            return scriptName.getText();
        } else {
            return null;
        }
    }

    public static ACSScriptScriptDefinition changeName(ACSScriptScriptDefinition scriptWord, String newScriptName) {
        ASTNode scriptName = scriptWord.getNode().findChildByType(ACSScriptTypes.SCRIPT_NAME);
        if (scriptName != null) {
            ACSScriptScriptDefinition acsScriptDefinition = ACSScriptElementFactory.createScript(scriptWord.getProject(), newScriptName);
            PsiElement psi = scriptName.getPsi();
            psi.replace(acsScriptDefinition.getScriptName());
        } else {
            return null;
        }
        return scriptWord;
    }

    public static ACSScriptFunctionInvocation changeName(ACSScriptFunctionInvocation scriptWord, String newScriptName) {
        ASTNode scriptName = scriptWord.getNode().findChildByType(ACSScriptTypes.SCRIPT_NAME);
        if (scriptName != null) {
            ACSScriptScriptDefinition acsScriptDefinition = ACSScriptElementFactory.createScript(scriptWord.getProject(), newScriptName);
            PsiElement psi = scriptName.getPsi();
            psi.replace(acsScriptDefinition.getScriptName());
        } else {
            return null;
        }
        return scriptWord;
    }

    public static ACSScriptFunctionDefinition changeName(ACSScriptFunctionDefinition functionDefinition, String newScriptName) {
        ASTNode scriptName = functionDefinition.getNode().findChildByType(ACSScriptTypes.FUNCTION_NAME);
        if (scriptName != null) {
            ACSScriptFunctionDefinition acsScriptDefinition = ACSScriptElementFactory.createSimpleFunction(functionDefinition.getProject(), newScriptName);
            PsiElement psi = scriptName.getPsi();
            psi.replace(acsScriptDefinition.getFunctionName());
        } else {
            return null;
        }
        return functionDefinition;
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

    public static PsiElement getNameIdentifier(ACSScriptScriptDefinition scriptWord) {
        ASTNode keyNode = scriptWord.getNode().findChildByType(ACSScriptTypes.SCRIPT_NAME);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }


    public static PsiElement getNameIdentifier(ACSScriptFunctionDefinition scriptWord) {
        ASTNode keyNode = scriptWord.getNode().findChildByType(ACSScriptTypes.FUNCTION_NAME);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement getNameIdentifier(ACSScriptFunctionInvocation scriptWord) {
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

    public static PsiElement getNameIdentifier(ACSScriptFunctionName functionName) {
        if (functionName != null) {
            return functionName;
        } else {
            return null;
        }
    }

    public static ACSScriptFunctionName changeName(ACSScriptFunctionName functionDefinition, String newScriptName) {
        if (functionDefinition != null) {
            ACSScriptFunctionDefinition acsScriptDefinition = ACSScriptElementFactory.createSimpleFunction(functionDefinition.getProject(), newScriptName);
            functionDefinition.replace(acsScriptDefinition.getFunctionName());
        } else {
            System.out.println("function name null");
            return null;
        }
        return functionDefinition;
    }

    public static String getName(ACSScriptFunctionName functionElement) {
        return functionElement != null ? functionElement.getFunctionName() : null;
    }

    public static String getName(ACSScriptVariableName variableDefinition) {
        return variableDefinition != null ? variableDefinition.getText() : null;
    }

    public static ACSScriptVariableName setName(ACSScriptVariableName variableName, String newVariableName) {
        ASTNode childByType = variableName.getNode().findChildByType(ACSScriptTypes.VARIABLE_NAME);
        if (childByType != null) {
            ACSScriptVariableDefinition dummyVariable = ACSScriptElementFactory.createDummyVariable(variableName.getProject(), newVariableName);
            variableName.replace(dummyVariable.getVariableName());
        }
        return variableName;
    }

    public static PsiElement getNameIdentifier(ACSScriptVariableName variableDefinition) {
        return variableDefinition.getIdentifier();
    }

    public static PsiReference getReference(ACSScriptVariableName varName) {
        return new ACSVariableDefReference(varName) {
            @Nullable
            @Override
            public PsiElement resolve() {
                Collection<ACSScriptVariableName> childrenOfType = ACSUtil.findAllVarNames(varName.getContainingFile(), varName.getName());
                if (!childrenOfType.isEmpty()) {
                    for (ACSScriptVariableName variableName : childrenOfType) {
                        return variableName;
                    }
                }
                return null;
            }
        };
    }
}
