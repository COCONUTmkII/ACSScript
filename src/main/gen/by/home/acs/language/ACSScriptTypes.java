// This is a generated file. Not intended for manual editing.
package by.home.acs.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import by.home.acs.language.psi.ACSScriptElementType;
import by.home.acs.language.psi.ACSScriptTokenType;
import by.home.acs.language.psi.impl.*;

public interface ACSScriptTypes {

  IElementType ASSIGNMENT_STATEMENT = new ACSScriptElementType("ASSIGNMENT_STATEMENT");
  IElementType DEFINITION = new ACSScriptElementType("DEFINITION");
  IElementType FUNCTION_BODY = new ACSScriptElementType("FUNCTION_BODY");
  IElementType FUNCTION_DEFINITION = new ACSScriptElementType("FUNCTION_DEFINITION");
  IElementType FUNCTION_INVOCATION = new ACSScriptElementType("FUNCTION_INVOCATION");
  IElementType SCRIPT_DEFINITION = new ACSScriptElementType("SCRIPT_DEFINITION");
  IElementType STATEMENT = new ACSScriptElementType("STATEMENT");
  IElementType TYPE = new ACSScriptElementType("TYPE");
  IElementType VARIABLE_DEFINITION = new ACSScriptElementType("VARIABLE_DEFINITION");

  IElementType COMMENT = new ACSScriptTokenType("COMMENT");
  IElementType FUNCTION = new ACSScriptTokenType("function");
  IElementType IDENTIFIER = new ACSScriptTokenType("IDENTIFIER");
  IElementType INT = new ACSScriptTokenType("int");
  IElementType RETURNS = new ACSScriptTokenType("returns");
  IElementType SCRIPT = new ACSScriptTokenType("Script");
  IElementType STR = new ACSScriptTokenType("str");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASSIGNMENT_STATEMENT) {
        return new ACSScriptAssignmentStatementImpl(node);
      }
      else if (type == DEFINITION) {
        return new ACSScriptDefinitionImpl(node);
      }
      else if (type == FUNCTION_BODY) {
        return new ACSScriptFunctionBodyImpl(node);
      }
      else if (type == FUNCTION_DEFINITION) {
        return new ACSScriptFunctionDefinitionImpl(node);
      }
      else if (type == FUNCTION_INVOCATION) {
        return new ACSScriptFunctionInvocationImpl(node);
      }
      else if (type == SCRIPT_DEFINITION) {
        return new ACSScriptScriptDefinitionImpl(node);
      }
      else if (type == STATEMENT) {
        return new ACSScriptStatementImpl(node);
      }
      else if (type == TYPE) {
        return new ACSScriptTypeImpl(node);
      }
      else if (type == VARIABLE_DEFINITION) {
        return new ACSScriptVariableDefinitionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}