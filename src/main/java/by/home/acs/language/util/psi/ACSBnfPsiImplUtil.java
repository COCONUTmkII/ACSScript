package by.home.acs.language.util.psi;

import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.*;
import by.home.acs.language.reference.FunctionReference;
import by.home.acs.language.reference.VariableReference;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public class ACSBnfPsiImplUtil {

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
        }
        return functionDefinition;
    }

    public static ACSScriptVariableName changeName(ACSScriptVariableName variableName, String newVariableName) {
        if (variableName != null) {
            ACSScriptVariableDefinition variableDefinition = ACSScriptElementFactory.createDummyVariable(variableName.getProject(), newVariableName);
            variableName.replace(variableDefinition.getRepeatableVariable().getVariableName());
        }
        return variableName;
    }

    public static String getName(ACSScriptFunctionName functionElement) {
        return functionElement != null ? functionElement.getFunctionName() : null;
    }

    public static String getName(ACSScriptVariableName variableDefinition) {
        return variableDefinition != null ? variableDefinition.getVariableName() : null;
    }

    public static ACSScriptVariableName setName(ACSScriptVariableName variableName, String newVariableName) {
        ASTNode childByType = variableName.getNode().findChildByType(ACSScriptTypes.VARIABLE_NAME);
        if (childByType != null) {
            ACSScriptVariableDefinition dummyVariable = ACSScriptElementFactory.createDummyVariable(variableName.getProject(), newVariableName);
            variableName.replace(dummyVariable.getRepeatableVariable().getVariableName());
        }
        return variableName;
    }

    public static PsiElement getNameIdentifier(ACSScriptVariableName variableDefinition) {
        return variableDefinition.getIdentifier();
    }

    public static PsiReference getReference(ACSScriptVariableName varName) {
        return new VariableReference(varName);
    }

    public static PsiReference getReference(ACSScriptFunctionName functionDefinition) {
        return new FunctionReference(functionDefinition);
    }
}
