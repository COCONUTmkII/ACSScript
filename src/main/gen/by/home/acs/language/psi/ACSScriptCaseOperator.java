// This is a generated file. Not intended for manual editing.
package by.home.acs.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ACSScriptCaseOperator extends PsiElement {

  @Nullable
  ACSScriptCaseOperator getCaseOperator();

  @NotNull
  List<ACSScriptFunctionInvocation> getFunctionInvocationList();

  @Nullable
  ACSScriptVariableDefinition getVariableDefinition();

}