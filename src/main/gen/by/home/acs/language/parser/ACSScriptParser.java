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
  // case (IDENTIFIER | NUMBER | STRING) ':'  (FunctionInvocation | VariableDefinition)?  (break ';')? CaseOperator? (default ':' FunctionInvocation)?
  public static boolean CaseOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && CaseOperator_1(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && CaseOperator_3(b, l + 1);
    r = r && CaseOperator_4(b, l + 1);
    r = r && CaseOperator_5(b, l + 1);
    r = r && CaseOperator_6(b, l + 1);
    exit_section_(b, m, CASE_OPERATOR, r);
    return r;
  }

  // IDENTIFIER | NUMBER | STRING
  private static boolean CaseOperator_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_1")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  // (FunctionInvocation | VariableDefinition)?
  private static boolean CaseOperator_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_3")) return false;
    CaseOperator_3_0(b, l + 1);
    return true;
  }

  // FunctionInvocation | VariableDefinition
  private static boolean CaseOperator_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_3_0")) return false;
    boolean r;
    r = FunctionInvocation(b, l + 1);
    if (!r) r = VariableDefinition(b, l + 1);
    return r;
  }

  // (break ';')?
  private static boolean CaseOperator_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_4")) return false;
    CaseOperator_4_0(b, l + 1);
    return true;
  }

  // break ';'
  private static boolean CaseOperator_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  // CaseOperator?
  private static boolean CaseOperator_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_5")) return false;
    CaseOperator(b, l + 1);
    return true;
  }

  // (default ':' FunctionInvocation)?
  private static boolean CaseOperator_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_6")) return false;
    CaseOperator_6_0(b, l + 1);
    return true;
  }

  // default ':' FunctionInvocation
  private static boolean CaseOperator_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFAULT);
    r = r && consumeToken(b, ":");
    r = r && FunctionInvocation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IfElseStatement | SwitchStatement
  public static boolean ConditionalOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalOperator")) return false;
    if (!nextTokenIs(b, "<conditional operator>", IF, SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_OPERATOR, "<conditional operator>");
    r = IfElseStatement(b, l + 1);
    if (!r) r = SwitchStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FunctionDefinition | ScriptDefinition | DirectivesDeclaration | GlobalModifier
  public static boolean Definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = FunctionDefinition(b, l + 1);
    if (!r) r = ScriptDefinition(b, l + 1);
    if (!r) r = DirectivesDeclaration(b, l + 1);
    if (!r) r = GlobalModifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IncludeDeclaration | ImportDeclaration
  public static boolean DirectivesDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DirectivesDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIRECTIVES_DECLARATION, "<directives declaration>");
    r = IncludeDeclaration(b, l + 1);
    if (!r) r = ImportDeclaration(b, l + 1);
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
  // function (VoidType | Type) IDENTIFIER '(' ')'  '{' FunctionBody '}'
  public static boolean FunctionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION);
    r = r && FunctionDefinition_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && FunctionBody(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, FUNCTION_DEFINITION, r);
    return r;
  }

  // VoidType | Type
  private static boolean FunctionDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_1")) return false;
    boolean r;
    r = VoidType(b, l + 1);
    if (!r) r = Type(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '(' ')' ';' ReturnOperator?
  public static boolean FunctionInvocation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionInvocation")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, ";");
    r = r && FunctionInvocation_4(b, l + 1);
    exit_section_(b, m, FUNCTION_INVOCATION, r);
    return r;
  }

  // ReturnOperator?
  private static boolean FunctionInvocation_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionInvocation_4")) return false;
    ReturnOperator(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (global | world) Type IDENTIFIER':'IDENTIFIER';'
  public static boolean GlobalModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GlobalModifier")) return false;
    if (!nextTokenIs(b, "<global modifier>", GLOBAL, WORLD)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_MODIFIER, "<global modifier>");
    r = GlobalModifier_0(b, l + 1);
    r = r && Type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ":");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ";");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // global | world
  private static boolean GlobalModifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GlobalModifier_0")) return false;
    boolean r;
    r = consumeToken(b, GLOBAL);
    if (!r) r = consumeToken(b, WORLD);
    return r;
  }

  /* ********************************************************** */
  // if '(' LogicalType ')' '{' FunctionBody '}' (else ('{' FunctionBody '}' | IfElseStatement) )?
  public static boolean IfElseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && consumeToken(b, "(");
    r = r && LogicalType(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && FunctionBody(b, l + 1);
    r = r && consumeToken(b, "}");
    r = r && IfElseStatement_7(b, l + 1);
    exit_section_(b, m, IF_ELSE_STATEMENT, r);
    return r;
  }

  // (else ('{' FunctionBody '}' | IfElseStatement) )?
  private static boolean IfElseStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseStatement_7")) return false;
    IfElseStatement_7_0(b, l + 1);
    return true;
  }

  // else ('{' FunctionBody '}' | IfElseStatement)
  private static boolean IfElseStatement_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseStatement_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && IfElseStatement_7_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' FunctionBody '}' | IfElseStatement
  private static boolean IfElseStatement_7_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseStatement_7_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfElseStatement_7_0_1_0(b, l + 1);
    if (!r) r = IfElseStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' FunctionBody '}'
  private static boolean IfElseStatement_7_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseStatement_7_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && FunctionBody(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '#' import STRING
  public static boolean ImportDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_DECLARATION, "<import declaration>");
    r = consumeToken(b, "#");
    r = r && consumeTokens(b, 0, IMPORT, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '#' include STRING
  public static boolean IncludeDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IncludeDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE_DECLARATION, "<include declaration>");
    r = consumeToken(b, "#");
    r = r && consumeTokens(b, 0, INCLUDE, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // true | false
  public static boolean LogicalType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LogicalType")) return false;
    if (!nextTokenIs(b, "<logical type>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_TYPE, "<logical type>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // forLoop | whileLoop | untilLoop | doWhileLoop | doUntilLoop
  public static boolean Loops(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Loops")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOOPS, "<loops>");
    r = forLoop(b, l + 1);
    if (!r) r = whileLoop(b, l + 1);
    if (!r) r = untilLoop(b, l + 1);
    if (!r) r = doWhileLoop(b, l + 1);
    if (!r) r = doUntilLoop(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // net
  public static boolean NetType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NetType")) return false;
    if (!nextTokenIs(b, NET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NET);
    exit_section_(b, m, NET_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ('=' | '+' | '-' | '*' | '/' | '%' | '&' | '|' | '^' | '~' | '<<' | '>>' | '==' | '!=' | '>' | '<' | '>=' | '<=' | '&&' | '||' | '!' | '+=' | '++' | '-=' | '--' | '*=' | '/=' | '%=' | '&=' | '|=' | '^=' | '<<=' | '>>=') IDENTIFIER? NUMBER? STRING?';'
  public static boolean Operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operator")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && Operator_1(b, l + 1);
    r = r && Operator_2(b, l + 1);
    r = r && Operator_3(b, l + 1);
    r = r && Operator_4(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, OPERATOR, r);
    return r;
  }

  // '=' | '+' | '-' | '*' | '/' | '%' | '&' | '|' | '^' | '~' | '<<' | '>>' | '==' | '!=' | '>' | '<' | '>=' | '<=' | '&&' | '||' | '!' | '+=' | '++' | '-=' | '--' | '*=' | '/=' | '%=' | '&=' | '|=' | '^=' | '<<=' | '>>='
  private static boolean Operator_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operator_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    if (!r) r = consumeToken(b, "+");
    if (!r) r = consumeToken(b, "-");
    if (!r) r = consumeToken(b, "*");
    if (!r) r = consumeToken(b, "/");
    if (!r) r = consumeToken(b, "%");
    if (!r) r = consumeToken(b, "&");
    if (!r) r = consumeToken(b, "|");
    if (!r) r = consumeToken(b, "^");
    if (!r) r = consumeToken(b, "~");
    if (!r) r = consumeToken(b, "<<");
    if (!r) r = consumeToken(b, ">>");
    if (!r) r = consumeToken(b, "==");
    if (!r) r = consumeToken(b, "!=");
    if (!r) r = consumeToken(b, ">");
    if (!r) r = consumeToken(b, "<");
    if (!r) r = consumeToken(b, ">=");
    if (!r) r = consumeToken(b, "<=");
    if (!r) r = consumeToken(b, "&&");
    if (!r) r = consumeToken(b, "||");
    if (!r) r = consumeToken(b, "!");
    if (!r) r = consumeToken(b, "+=");
    if (!r) r = consumeToken(b, "++");
    if (!r) r = consumeToken(b, "-=");
    if (!r) r = consumeToken(b, "--");
    if (!r) r = consumeToken(b, "*=");
    if (!r) r = consumeToken(b, "/=");
    if (!r) r = consumeToken(b, "%=");
    if (!r) r = consumeToken(b, "&=");
    if (!r) r = consumeToken(b, "|=");
    if (!r) r = consumeToken(b, "^=");
    if (!r) r = consumeToken(b, "<<=");
    if (!r) r = consumeToken(b, ">>=");
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER?
  private static boolean Operator_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operator_2")) return false;
    consumeToken(b, IDENTIFIER);
    return true;
  }

  // NUMBER?
  private static boolean Operator_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operator_3")) return false;
    consumeToken(b, NUMBER);
    return true;
  }

  // STRING?
  private static boolean Operator_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operator_4")) return false;
    consumeToken(b, STRING);
    return true;
  }

  /* ********************************************************** */
  // return ';' | return IDENTIFIER ';'
  public static boolean ReturnOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnOperator")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ReturnOperator_0(b, l + 1);
    if (!r) r = ReturnOperator_1(b, l + 1);
    exit_section_(b, m, RETURN_OPERATOR, r);
    return r;
  }

  // return ';'
  private static boolean ReturnOperator_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnOperator_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  // return IDENTIFIER ';'
  private static boolean ReturnOperator_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnOperator_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, RETURN, IDENTIFIER);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ScriptStatement*
  public static boolean ScriptBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptBody")) return false;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_BODY, "<script body>");
    while (true) {
      int c = current_position_(b);
      if (!ScriptStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ScriptBody", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // SCRIPT (NUMBER | STRING) (ScriptType)? ('(' Type IDENTIFIER')' | '(' VoidType ')')?  (NetType)? '{' ScriptBody '}'
  public static boolean ScriptDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition")) return false;
    if (!nextTokenIs(b, SCRIPT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCRIPT);
    r = r && ScriptDefinition_1(b, l + 1);
    r = r && ScriptDefinition_2(b, l + 1);
    r = r && ScriptDefinition_3(b, l + 1);
    r = r && ScriptDefinition_4(b, l + 1);
    r = r && consumeToken(b, "{");
    r = r && ScriptBody(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, SCRIPT_DEFINITION, r);
    return r;
  }

  // NUMBER | STRING
  private static boolean ScriptDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition_1")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  // (ScriptType)?
  private static boolean ScriptDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition_2")) return false;
    ScriptDefinition_2_0(b, l + 1);
    return true;
  }

  // (ScriptType)
  private static boolean ScriptDefinition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ScriptType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('(' Type IDENTIFIER')' | '(' VoidType ')')?
  private static boolean ScriptDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition_3")) return false;
    ScriptDefinition_3_0(b, l + 1);
    return true;
  }

  // '(' Type IDENTIFIER')' | '(' VoidType ')'
  private static boolean ScriptDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ScriptDefinition_3_0_0(b, l + 1);
    if (!r) r = ScriptDefinition_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' Type IDENTIFIER')'
  private static boolean ScriptDefinition_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && Type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' VoidType ')'
  private static boolean ScriptDefinition_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && VoidType(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // (NetType)?
  private static boolean ScriptDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition_4")) return false;
    ScriptDefinition_4_0(b, l + 1);
    return true;
  }

  // (NetType)
  private static boolean ScriptDefinition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = NetType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VariableDefinition | AssignmentStatement | FunctionInvocation | ConditionalOperator | Loops
  public static boolean ScriptStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_STATEMENT, "<script statement>");
    r = VariableDefinition(b, l + 1);
    if (!r) r = AssignmentStatement(b, l + 1);
    if (!r) r = FunctionInvocation(b, l + 1);
    if (!r) r = ConditionalOperator(b, l + 1);
    if (!r) r = Loops(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OPEN | ENTER | RETURN | RESPAWN | DEATH | LIGHTNING | UNLOADING | DISCONNECT | KILL | REOPEN
  public static boolean ScriptType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_TYPE, "<script type>");
    r = consumeToken(b, OPEN);
    if (!r) r = consumeToken(b, ENTER);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, RESPAWN);
    if (!r) r = consumeToken(b, DEATH);
    if (!r) r = consumeToken(b, LIGHTNING);
    if (!r) r = consumeToken(b, UNLOADING);
    if (!r) r = consumeToken(b, DISCONNECT);
    if (!r) r = consumeToken(b, KILL);
    if (!r) r = consumeToken(b, REOPEN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VariableDefinition | AssignmentStatement | FunctionInvocation | ConditionalOperator | Loops | ReturnOperator
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = VariableDefinition(b, l + 1);
    if (!r) r = AssignmentStatement(b, l + 1);
    if (!r) r = FunctionInvocation(b, l + 1);
    if (!r) r = ConditionalOperator(b, l + 1);
    if (!r) r = Loops(b, l + 1);
    if (!r) r = ReturnOperator(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // switch '(' (IDENTIFIER | NUMBER) ')' '{' CaseOperator '}'
  public static boolean SwitchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement")) return false;
    if (!nextTokenIs(b, SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWITCH);
    r = r && consumeToken(b, "(");
    r = r && SwitchStatement_2(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && CaseOperator(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, SWITCH_STATEMENT, r);
    return r;
  }

  // IDENTIFIER | NUMBER
  private static boolean SwitchStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SwitchStatement_2")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  /* ********************************************************** */
  // int | str | bool
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, STR);
    if (!r) r = consumeToken(b, BOOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Type IDENTIFIER (';' | ('=' (FunctionInvocation | VariableInitialization | Operator)))
  public static boolean VariableDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DEFINITION, "<variable definition>");
    r = Type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && VariableDefinition_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ';' | ('=' (FunctionInvocation | VariableInitialization | Operator))
  private static boolean VariableDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ";");
    if (!r) r = VariableDefinition_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' (FunctionInvocation | VariableInitialization | Operator)
  private static boolean VariableDefinition_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && VariableDefinition_2_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FunctionInvocation | VariableInitialization | Operator
  private static boolean VariableDefinition_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_2_1_1")) return false;
    boolean r;
    r = FunctionInvocation(b, l + 1);
    if (!r) r = VariableInitialization(b, l + 1);
    if (!r) r = Operator(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (NUMBER | STRING | LogicalType)  ';'
  public static boolean VariableInitialization(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableInitialization")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_INITIALIZATION, "<variable initialization>");
    r = VariableInitialization_0(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NUMBER | STRING | LogicalType
  private static boolean VariableInitialization_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableInitialization_0")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = LogicalType(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // void
  public static boolean VoidType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VoidType")) return false;
    if (!nextTokenIs(b, VOID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VOID);
    exit_section_(b, m, VOID_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // do '{' Statement? '}' until '(' LogicalType ')' ';'
  public static boolean doUntilLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doUntilLoop")) return false;
    if (!nextTokenIs(b, DO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DO);
    r = r && consumeToken(b, "{");
    r = r && doUntilLoop_2(b, l + 1);
    r = r && consumeToken(b, "}");
    r = r && consumeToken(b, UNTIL);
    r = r && consumeToken(b, "(");
    r = r && LogicalType(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, ";");
    exit_section_(b, m, DO_UNTIL_LOOP, r);
    return r;
  }

  // Statement?
  private static boolean doUntilLoop_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doUntilLoop_2")) return false;
    Statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // do '{' Statement? '}' while '(' LogicalType ')' ';'
  public static boolean doWhileLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doWhileLoop")) return false;
    if (!nextTokenIs(b, DO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DO);
    r = r && consumeToken(b, "{");
    r = r && doWhileLoop_2(b, l + 1);
    r = r && consumeToken(b, "}");
    r = r && consumeToken(b, WHILE);
    r = r && consumeToken(b, "(");
    r = r && LogicalType(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, ";");
    exit_section_(b, m, DO_WHILE_LOOP, r);
    return r;
  }

  // Statement?
  private static boolean doWhileLoop_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doWhileLoop_2")) return false;
    Statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // for '(' IDENTIFIER ';' LogicalType ';' IDENTIFIER ')' '{' Statement '}'
  public static boolean forLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forLoop")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && consumeToken(b, "(");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ";");
    r = r && LogicalType(b, l + 1);
    r = r && consumeToken(b, ";");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && Statement(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, FOR_LOOP, r);
    return r;
  }

  /* ********************************************************** */
  // until '(' LogicalType ')' '{' Statement? '}'
  public static boolean untilLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "untilLoop")) return false;
    if (!nextTokenIs(b, UNTIL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNTIL);
    r = r && consumeToken(b, "(");
    r = r && LogicalType(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && untilLoop_5(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, UNTIL_LOOP, r);
    return r;
  }

  // Statement?
  private static boolean untilLoop_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "untilLoop_5")) return false;
    Statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // while '(' LogicalType ')' '{' Statement? '}'
  public static boolean whileLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileLoop")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && consumeToken(b, "(");
    r = r && LogicalType(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && consumeToken(b, "{");
    r = r && whileLoop_5(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, WHILE_LOOP, r);
    return r;
  }

  // Statement?
  private static boolean whileLoop_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileLoop_5")) return false;
    Statement(b, l + 1);
    return true;
  }

}
