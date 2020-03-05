// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import generated.psi.impl.*;

public interface GeneratedTypes {

  IElementType ASSIGNMENT_STATEMENT = new IElementType("ASSIGNMENT_STATEMENT", null);
  IElementType DEFINITION = new IElementType("DEFINITION", null);
  IElementType FUNCTION_BODY = new IElementType("FUNCTION_BODY", null);
  IElementType FUNCTION_DEFINITION = new IElementType("FUNCTION_DEFINITION", null);
  IElementType FUNCTION_INVOCATION = new IElementType("FUNCTION_INVOCATION", null);
  IElementType SCRIPT_DEFINITION = new IElementType("SCRIPT_DEFINITION", null);
  IElementType STATEMENT = new IElementType("STATEMENT", null);
  IElementType TYPE = new IElementType("TYPE", null);
  IElementType VARIABLE_DEFINITION = new IElementType("VARIABLE_DEFINITION", null);

  IElementType COMMENT = new IElementType("COMMENT", null);
  IElementType FUNCTION = new IElementType("function", null);
  IElementType IDENTIFIER = new IElementType("IDENTIFIER", null);
  IElementType INT = new IElementType("int", null);
  IElementType NUMBER = new IElementType("NUMBER", null);
  IElementType RETURNS = new IElementType("returns", null);
  IElementType SCRIPT = new IElementType("Script", null);
  IElementType STR = new IElementType("str", null);
  IElementType STRING = new IElementType("STRING", null);

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASSIGNMENT_STATEMENT) {
        return new AssignmentStatementImpl(node);
      }
      else if (type == DEFINITION) {
        return new DefinitionImpl(node);
      }
      else if (type == FUNCTION_BODY) {
        return new FunctionBodyImpl(node);
      }
      else if (type == FUNCTION_DEFINITION) {
        return new FunctionDefinitionImpl(node);
      }
      else if (type == FUNCTION_INVOCATION) {
        return new FunctionInvocationImpl(node);
      }
      else if (type == SCRIPT_DEFINITION) {
        return new ScriptDefinitionImpl(node);
      }
      else if (type == STATEMENT) {
        return new StatementImpl(node);
      }
      else if (type == TYPE) {
        return new TypeImpl(node);
      }
      else if (type == VARIABLE_DEFINITION) {
        return new VariableDefinitionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
