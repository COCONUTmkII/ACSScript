// This is a generated file. Not intended for manual editing.
package by.home.acs.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import by.home.acs.language.psi.ACSScriptElementType;
import by.home.acs.language.psi.ACSScriptTokenType;
import by.home.acs.language.psi.impl.*;

public interface ACSScriptTypes {

  IElementType ARRAY_INITIALIZER = new ACSScriptElementType("ARRAY_INITIALIZER");
  IElementType ARRAY_INITIALIZERS = new ACSScriptElementType("ARRAY_INITIALIZERS");
  IElementType ARRAY_TYPE = new ACSScriptElementType("ARRAY_TYPE");
  IElementType ASSIGNMENT_STATEMENT = new ACSScriptElementType("ASSIGNMENT_STATEMENT");
  IElementType CASE_OPERATOR = new ACSScriptElementType("CASE_OPERATOR");
  IElementType CONDITIONAL_OPERATOR = new ACSScriptElementType("CONDITIONAL_OPERATOR");
  IElementType DEFINE_DECLARATION = new ACSScriptElementType("DEFINE_DECLARATION");
  IElementType DEFINITION = new ACSScriptElementType("DEFINITION");
  IElementType DIRECTIVES_DECLARATION = new ACSScriptElementType("DIRECTIVES_DECLARATION");
  IElementType DO_UNTIL_LOOP = new ACSScriptElementType("DO_UNTIL_LOOP");
  IElementType DO_WHILE_LOOP = new ACSScriptElementType("DO_WHILE_LOOP");
  IElementType FOR_LOOP = new ACSScriptElementType("FOR_LOOP");
  IElementType FUNCTION_BODY = new ACSScriptElementType("FUNCTION_BODY");
  IElementType FUNCTION_DEFINITION = new ACSScriptElementType("FUNCTION_DEFINITION");
  IElementType FUNCTION_INVOCATION = new ACSScriptElementType("FUNCTION_INVOCATION");
  IElementType GLOBAL_MODIFIER = new ACSScriptElementType("GLOBAL_MODIFIER");
  IElementType IF_THEN_ELSE_STATEMENT = new ACSScriptElementType("IF_THEN_ELSE_STATEMENT");
  IElementType IF_THEN_STATEMENT = new ACSScriptElementType("IF_THEN_STATEMENT");
  IElementType IMPORT_DECLARATION = new ACSScriptElementType("IMPORT_DECLARATION");
  IElementType INCLUDE_DECLARATION = new ACSScriptElementType("INCLUDE_DECLARATION");
  IElementType LIBRARY_DECLARATION = new ACSScriptElementType("LIBRARY_DECLARATION");
  IElementType LOGICAL_TYPE = new ACSScriptElementType("LOGICAL_TYPE");
  IElementType LOOPS = new ACSScriptElementType("LOOPS");
  IElementType NET_TYPE = new ACSScriptElementType("NET_TYPE");
  IElementType OPERATOR = new ACSScriptElementType("OPERATOR");
  IElementType RETURN_OPERATOR = new ACSScriptElementType("RETURN_OPERATOR");
  IElementType SCRIPT_BODY = new ACSScriptElementType("SCRIPT_BODY");
  IElementType SCRIPT_DEFINITION = new ACSScriptElementType("SCRIPT_DEFINITION");
  IElementType SCRIPT_STATEMENT = new ACSScriptElementType("SCRIPT_STATEMENT");
  IElementType SCRIPT_TYPE = new ACSScriptElementType("SCRIPT_TYPE");
  IElementType STATEMENT = new ACSScriptElementType("STATEMENT");
  IElementType SWITCH_STATEMENT = new ACSScriptElementType("SWITCH_STATEMENT");
  IElementType TYPE = new ACSScriptElementType("TYPE");
  IElementType UNTIL_LOOP = new ACSScriptElementType("UNTIL_LOOP");
  IElementType VARIABLE_DEFINITION = new ACSScriptElementType("VARIABLE_DEFINITION");
  IElementType VARIABLE_INITIALIZATION = new ACSScriptElementType("VARIABLE_INITIALIZATION");
  IElementType VOID_TYPE = new ACSScriptElementType("VOID_TYPE");
  IElementType WHILE_LOOP = new ACSScriptElementType("WHILE_LOOP");

  IElementType BOOL = new ACSScriptTokenType("bool");
  IElementType BREAK = new ACSScriptTokenType("break");
  IElementType CASE = new ACSScriptTokenType("case");
  IElementType COMMENT = new ACSScriptTokenType("COMMENT");
  IElementType DEATH = new ACSScriptTokenType("DEATH");
  IElementType DEFAULT = new ACSScriptTokenType("default");
  IElementType DEFINE = new ACSScriptTokenType("define");
  IElementType DISCONNECT = new ACSScriptTokenType("DISCONNECT");
  IElementType DO = new ACSScriptTokenType("do");
  IElementType ELSE = new ACSScriptTokenType("else");
  IElementType ENTER = new ACSScriptTokenType("ENTER");
  IElementType FALSE = new ACSScriptTokenType("false");
  IElementType FOR = new ACSScriptTokenType("for");
  IElementType FUNCTION = new ACSScriptTokenType("function");
  IElementType GLOBAL = new ACSScriptTokenType("global");
  IElementType IDENTIFIER = new ACSScriptTokenType("IDENTIFIER");
  IElementType IF = new ACSScriptTokenType("if");
  IElementType IMPORT = new ACSScriptTokenType("import");
  IElementType INCLUDE = new ACSScriptTokenType("include");
  IElementType INT = new ACSScriptTokenType("int");
  IElementType KILL = new ACSScriptTokenType("KILL");
  IElementType LIBRARY = new ACSScriptTokenType("library");
  IElementType LIGHTNING = new ACSScriptTokenType("LIGHTNING");
  IElementType NET = new ACSScriptTokenType("net");
  IElementType NUMBER = new ACSScriptTokenType("NUMBER");
  IElementType OPEN = new ACSScriptTokenType("OPEN");
  IElementType REOPEN = new ACSScriptTokenType("REOPEN");
  IElementType RESPAWN = new ACSScriptTokenType("RESPAWN");
  IElementType RETURN = new ACSScriptTokenType("RETURN");
  IElementType SCRIPT = new ACSScriptTokenType("SCRIPT");
  IElementType STR = new ACSScriptTokenType("str");
  IElementType STRING = new ACSScriptTokenType("STRING");
  IElementType SWITCH = new ACSScriptTokenType("switch");
  IElementType TRUE = new ACSScriptTokenType("true");
  IElementType UNLOADING = new ACSScriptTokenType("UNLOADING");
  IElementType UNTIL = new ACSScriptTokenType("until");
  IElementType VOID = new ACSScriptTokenType("void");
  IElementType WHILE = new ACSScriptTokenType("while");
  IElementType WORLD = new ACSScriptTokenType("world");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY_INITIALIZER) {
        return new ACSScriptArrayInitializerImpl(node);
      }
      else if (type == ARRAY_INITIALIZERS) {
        return new ACSScriptArrayInitializersImpl(node);
      }
      else if (type == ARRAY_TYPE) {
        return new ACSScriptArrayTypeImpl(node);
      }
      else if (type == ASSIGNMENT_STATEMENT) {
        return new ACSScriptAssignmentStatementImpl(node);
      }
      else if (type == CASE_OPERATOR) {
        return new ACSScriptCaseOperatorImpl(node);
      }
      else if (type == CONDITIONAL_OPERATOR) {
        return new ACSScriptConditionalOperatorImpl(node);
      }
      else if (type == DEFINE_DECLARATION) {
        return new ACSScriptDefineDeclarationImpl(node);
      }
      else if (type == DEFINITION) {
        return new ACSScriptDefinitionImpl(node);
      }
      else if (type == DIRECTIVES_DECLARATION) {
        return new ACSScriptDirectivesDeclarationImpl(node);
      }
      else if (type == DO_UNTIL_LOOP) {
        return new ACSScriptDoUntilLoopImpl(node);
      }
      else if (type == DO_WHILE_LOOP) {
        return new ACSScriptDoWhileLoopImpl(node);
      }
      else if (type == FOR_LOOP) {
        return new ACSScriptForLoopImpl(node);
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
      else if (type == GLOBAL_MODIFIER) {
        return new ACSScriptGlobalModifierImpl(node);
      }
      else if (type == IF_THEN_ELSE_STATEMENT) {
        return new ACSScriptIfThenElseStatementImpl(node);
      }
      else if (type == IF_THEN_STATEMENT) {
        return new ACSScriptIfThenStatementImpl(node);
      }
      else if (type == IMPORT_DECLARATION) {
        return new ACSScriptImportDeclarationImpl(node);
      }
      else if (type == INCLUDE_DECLARATION) {
        return new ACSScriptIncludeDeclarationImpl(node);
      }
      else if (type == LIBRARY_DECLARATION) {
        return new ACSScriptLibraryDeclarationImpl(node);
      }
      else if (type == LOGICAL_TYPE) {
        return new ACSScriptLogicalTypeImpl(node);
      }
      else if (type == LOOPS) {
        return new ACSScriptLoopsImpl(node);
      }
      else if (type == NET_TYPE) {
        return new ACSScriptNetTypeImpl(node);
      }
      else if (type == OPERATOR) {
        return new ACSScriptOperatorImpl(node);
      }
      else if (type == RETURN_OPERATOR) {
        return new ACSScriptReturnOperatorImpl(node);
      }
      else if (type == SCRIPT_BODY) {
        return new ACSScriptScriptBodyImpl(node);
      }
      else if (type == SCRIPT_DEFINITION) {
        return new ACSScriptScriptDefinitionImpl(node);
      }
      else if (type == SCRIPT_STATEMENT) {
        return new ACSScriptScriptStatementImpl(node);
      }
      else if (type == SCRIPT_TYPE) {
        return new ACSScriptScriptTypeImpl(node);
      }
      else if (type == STATEMENT) {
        return new ACSScriptStatementImpl(node);
      }
      else if (type == SWITCH_STATEMENT) {
        return new ACSScriptSwitchStatementImpl(node);
      }
      else if (type == TYPE) {
        return new ACSScriptTypeImpl(node);
      }
      else if (type == UNTIL_LOOP) {
        return new ACSScriptUntilLoopImpl(node);
      }
      else if (type == VARIABLE_DEFINITION) {
        return new ACSScriptVariableDefinitionImpl(node);
      }
      else if (type == VARIABLE_INITIALIZATION) {
        return new ACSScriptVariableInitializationImpl(node);
      }
      else if (type == VOID_TYPE) {
        return new ACSScriptVoidTypeImpl(node);
      }
      else if (type == WHILE_LOOP) {
        return new ACSScriptWhileLoopImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
