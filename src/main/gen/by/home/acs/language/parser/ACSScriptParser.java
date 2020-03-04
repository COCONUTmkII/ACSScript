// This is a generated file. Not intended for manual editing.
package by.home.acs.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static by.home.acs.language.ACSScriptTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ACSScriptParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return ACSScriptFile(b, l + 1);
  }

  /* ********************************************************** */
  // COMMENT|Definition*
  static boolean ACSScriptFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ACSScriptFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT);
    if (!r) r = ACSScriptFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Definition*
  private static boolean ACSScriptFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ACSScriptFile_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ACSScriptFile_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER '=' FunctionInvocation
  public static boolean AssignmentStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentStatement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && FunctionInvocation(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // FunctionDefinition|ScriptDefinition
  public static boolean Definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition")) return false;
    if (!nextTokenIs(b, "<definition>", FUNCTION, SCRIPT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = FunctionDefinition(b, l + 1);
    if (!r) r = ScriptDefinition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Statement*
  public static boolean FunctionBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody")) return false;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_BODY, "<function body>");
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionBody", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // function IDENTIFIER '(' ')' (returns Type)? '{' FunctionBody '}'
  public static boolean FunctionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNCTION, IDENTIFIER);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, ")");
    r = r && FunctionDefinition_4(b, l + 1);
    r = r && consumeToken(b, "{");
    r = r && FunctionBody(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, FUNCTION_DEFINITION, r);
    return r;
  }

  // (returns Type)?
  private static boolean FunctionDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_4")) return false;
    FunctionDefinition_4_0(b, l + 1);
    return true;
  }

  // returns Type
  private static boolean FunctionDefinition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURNS);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '(' ')' ';'
  public static boolean FunctionInvocation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionInvocation")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, ";");
    exit_section_(b, m, FUNCTION_INVOCATION, r);
    return r;
  }

  /* ********************************************************** */
  // Script Type '(' ')' '{' FunctionBody '}'
  public static boolean ScriptDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition")) return false;
    if (!nextTokenIs(b, SCRIPT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCRIPT);
    r = r && Type(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && FunctionBody(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, SCRIPT_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // VariableDefinition | AssignmentStatement | FunctionInvocation
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = VariableDefinition(b, l + 1);
    if (!r) r = AssignmentStatement(b, l + 1);
    if (!r) r = FunctionInvocation(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // int | str
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    if (!nextTokenIs(b, "<type>", INT, STR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, STR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Type IDENTIFIER (';' | ('=' FunctionInvocation)?)
  public static boolean VariableDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition")) return false;
    if (!nextTokenIs(b, "<variable definition>", INT, STR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DEFINITION, "<variable definition>");
    r = Type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && VariableDefinition_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ';' | ('=' FunctionInvocation)?
  private static boolean VariableDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ";");
    if (!r) r = VariableDefinition_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=' FunctionInvocation)?
  private static boolean VariableDefinition_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_2_1")) return false;
    VariableDefinition_2_1_0(b, l + 1);
    return true;
  }

  // '=' FunctionInvocation
  private static boolean VariableDefinition_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && FunctionInvocation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
