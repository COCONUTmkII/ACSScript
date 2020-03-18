// This is a generated file. Not intended for manual editing.
package by.home.acs.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ACSScriptScriptStatement extends PsiElement {

  @Nullable
  ACSScriptAssignmentStatement getAssignmentStatement();

  @Nullable
  ACSScriptConditionalOperator getConditionalOperator();

  @Nullable
  ACSScriptFunctionInvocation getFunctionInvocation();

  @Nullable
  ACSScriptLoops getLoops();

  @Nullable
  ACSScriptVariableDefinition getVariableDefinition();

  @Nullable
  ACSScriptVariableInitialization getVariableInitialization();

}
