// This is a generated file. Not intended for manual editing.
package by.home.acs.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ACSScriptVariableDefinition extends PsiElement {

  @Nullable
  ACSScriptFunctionInvocation getFunctionInvocation();

  @NotNull
  ACSScriptType getType();

  @Nullable
  ACSScriptVariableInitialization getVariableInitialization();

}
