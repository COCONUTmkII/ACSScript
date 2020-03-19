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
  // '{' ArrayInitializers? '}'
  public static boolean ArrayInitializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayInitializer")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_INITIALIZER, "<array initializer>");
    r = consumeToken(b, "{");
    r = r && ArrayInitializer_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ArrayInitializers?
  private static boolean ArrayInitializer_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayInitializer_1")) return false;
    ArrayInitializers(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (NUMBER | STRING) (',' ArrayInitializers)?
  public static boolean ArrayInitializers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayInitializers")) return false;
    if (!nextTokenIs(b, "<array initializers>", NUMBER, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, ARRAY_INITIALIZERS, "<array initializers>");
    r = ArrayInitializers_0(b, l + 1);
    r = r && ArrayInitializers_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NUMBER | STRING
  private static boolean ArrayInitializers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayInitializers_0")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  // (',' ArrayInitializers)?
  private static boolean ArrayInitializers_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayInitializers_1")) return false;
    ArrayInitializers_1_0(b, l + 1);
    return true;
  }

  // ',' ArrayInitializers
  private static boolean ArrayInitializers_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayInitializers_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && ArrayInitializers(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (Type) '[' ']'
  public static boolean ArrayType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_TYPE, "<array type>");
    r = ArrayType_0(b, l + 1);
    r = r && consumeToken(b, "[");
    r = r && consumeToken(b, "]");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (Type)
  private static boolean ArrayType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '=' (FunctionInvocation)
  public static boolean AssignmentStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentStatement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && consumeToken(b, "=");
    r = r && AssignmentStatement_2(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_STATEMENT, r);
    return r;
  }

  // (FunctionInvocation)
  private static boolean AssignmentStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentStatement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionInvocation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bool
  public static boolean BoolType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolType")) return false;
    if (!nextTokenIs(b, BOOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BOOL);
    exit_section_(b, m, BOOL_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // case (IDENTIFIER | NUMBER | STRING) ':'  (FunctionInvocation | VariableDefinition)? (SwitchStatement)?  (break ';')? CaseOperator? (default ':' FunctionInvocation)?
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
    r = r && CaseOperator_7(b, l + 1);
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

  // (SwitchStatement)?
  private static boolean CaseOperator_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_4")) return false;
    CaseOperator_4_0(b, l + 1);
    return true;
  }

  // (SwitchStatement)
  private static boolean CaseOperator_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SwitchStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (break ';')?
  private static boolean CaseOperator_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_5")) return false;
    CaseOperator_5_0(b, l + 1);
    return true;
  }

  // break ';'
  private static boolean CaseOperator_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, null, r);
    return r;
  }

  // CaseOperator?
  private static boolean CaseOperator_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_6")) return false;
    CaseOperator(b, l + 1);
    return true;
  }

  // (default ':' FunctionInvocation)?
  private static boolean CaseOperator_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_7")) return false;
    CaseOperator_7_0(b, l + 1);
    return true;
  }

  // default ':' FunctionInvocation
  private static boolean CaseOperator_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CaseOperator_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFAULT);
    r = r && consumeToken(b, ":");
    r = r && FunctionInvocation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IfThenStatement | IfThenElseStatement |  SwitchStatement
  public static boolean ConditionalOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalOperator")) return false;
    if (!nextTokenIs(b, "<conditional operator>", IF, SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_OPERATOR, "<conditional operator>");
    r = IfThenStatement(b, l + 1);
    if (!r) r = IfThenElseStatement(b, l + 1);
    if (!r) r = SwitchStatement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '#' define IDENTIFIER IDENTIFIER
  public static boolean DefineDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefineDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINE_DECLARATION, "<define declaration>");
    r = consumeToken(b, "#");
    r = r && consumeTokens(b, 0, DEFINE, IDENTIFIER, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FunctionDefinition | ScriptDefinition | DirectivesDeclaration | GlobalModifier | VariableDefinition
  public static boolean Definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = FunctionDefinition(b, l + 1);
    if (!r) r = ScriptDefinition(b, l + 1);
    if (!r) r = DirectivesDeclaration(b, l + 1);
    if (!r) r = GlobalModifier(b, l + 1);
    if (!r) r = VariableDefinition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IncludeDeclaration | ImportDeclaration | DefineDeclaration | LibraryDeclaration
  public static boolean DirectivesDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DirectivesDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIRECTIVES_DECLARATION, "<directives declaration>");
    r = IncludeDeclaration(b, l + 1);
    if (!r) r = ImportDeclaration(b, l + 1);
    if (!r) r = DefineDeclaration(b, l + 1);
    if (!r) r = LibraryDeclaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '""'
  public static boolean EmptyString(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EmptyString")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EMPTY_STRING, "<empty string>");
    r = consumeToken(b, "\"\"");
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
  // if '(' LogicalType ')' '{' FunctionBody '}' (else ('{' FunctionBody '}' | IfThenElseStatement) )?
  public static boolean IfThenElseStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfThenElseStatement")) return false;
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
    r = r && IfThenElseStatement_7(b, l + 1);
    exit_section_(b, m, IF_THEN_ELSE_STATEMENT, r);
    return r;
  }

  // (else ('{' FunctionBody '}' | IfThenElseStatement) )?
  private static boolean IfThenElseStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfThenElseStatement_7")) return false;
    IfThenElseStatement_7_0(b, l + 1);
    return true;
  }

  // else ('{' FunctionBody '}' | IfThenElseStatement)
  private static boolean IfThenElseStatement_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfThenElseStatement_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && IfThenElseStatement_7_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' FunctionBody '}' | IfThenElseStatement
  private static boolean IfThenElseStatement_7_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfThenElseStatement_7_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfThenElseStatement_7_0_1_0(b, l + 1);
    if (!r) r = IfThenElseStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' FunctionBody '}'
  private static boolean IfThenElseStatement_7_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfThenElseStatement_7_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "{");
    r = r && FunctionBody(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // if '(' LogicalType ')' Statement
  public static boolean IfThenStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfThenStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && consumeToken(b, "(");
    r = r && LogicalType(b, l + 1);
    r = r && consumeToken(b, ")");
    r = r && Statement(b, l + 1);
    exit_section_(b, m, IF_THEN_STATEMENT, r);
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
  // int
  public static boolean IntType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IntType")) return false;
    if (!nextTokenIs(b, INT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INT);
    exit_section_(b, m, INT_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // '#' library STRING
  public static boolean LibraryDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LibraryDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIBRARY_DECLARATION, "<library declaration>");
    r = consumeToken(b, "#");
    r = r && consumeTokens(b, 0, LIBRARY, STRING);
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
  // SCRIPT ( STRING | NUMBER) (ScriptType)? ('(' Type IDENTIFIER')' | '(' VoidType ')')?  (NetType)? '{' ScriptBody '}'
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

  // STRING | NUMBER
  private static boolean ScriptDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptDefinition_1")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
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
  // VariableDefinition | VariableInitialization | AssignmentStatement | FunctionInvocation | ConditionalOperator | Loops
  public static boolean ScriptStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ScriptStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCRIPT_STATEMENT, "<script statement>");
    r = VariableDefinition(b, l + 1);
    if (!r) r = VariableInitialization(b, l + 1);
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
  // static
  public static boolean StaticModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StaticModifier")) return false;
    if (!nextTokenIs(b, STATIC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STATIC);
    exit_section_(b, m, STATIC_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // str
  public static boolean StringType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringType")) return false;
    if (!nextTokenIs(b, STR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STR);
    exit_section_(b, m, STRING_TYPE, r);
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
  // IntType | StringType | BoolType
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = IntType(b, l + 1);
    if (!r) r = StringType(b, l + 1);
    if (!r) r = BoolType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // StaticModifier? (ArrayType | Type) IDENTIFIER (';' | ('=' (FunctionInvocation | VariableInitialization | Operator)))
  public static boolean VariableDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_DEFINITION, "<variable definition>");
    r = VariableDefinition_0(b, l + 1);
    r = r && VariableDefinition_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && VariableDefinition_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // StaticModifier?
  private static boolean VariableDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_0")) return false;
    StaticModifier(b, l + 1);
    return true;
  }

  // ArrayType | Type
  private static boolean VariableDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_1")) return false;
    boolean r;
    r = ArrayType(b, l + 1);
    if (!r) r = Type(b, l + 1);
    return r;
  }

  // ';' | ('=' (FunctionInvocation | VariableInitialization | Operator))
  private static boolean VariableDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ";");
    if (!r) r = VariableDefinition_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' (FunctionInvocation | VariableInitialization | Operator)
  private static boolean VariableDefinition_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && VariableDefinition_3_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FunctionInvocation | VariableInitialization | Operator
  private static boolean VariableDefinition_3_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_3_1_1")) return false;
    boolean r;
    r = FunctionInvocation(b, l + 1);
    if (!r) r = VariableInitialization(b, l + 1);
    if (!r) r = Operator(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ( STRING | CHARACTER | EmptyString | LogicalType | ArrayInitializer | NUMBER) ';'
  public static boolean VariableInitialization(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableInitialization")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_INITIALIZATION, "<variable initialization>");
    r = VariableInitialization_0(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING | CHARACTER | EmptyString | LogicalType | ArrayInitializer | NUMBER
  private static boolean VariableInitialization_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableInitialization_0")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, CHARACTER);
    if (!r) r = EmptyString(b, l + 1);
    if (!r) r = LogicalType(b, l + 1);
    if (!r) r = ArrayInitializer(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
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
