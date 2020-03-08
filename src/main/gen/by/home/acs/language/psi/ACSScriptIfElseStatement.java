// This is a generated file. Not intended for manual editing.
package by.home.acs.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ACSScriptIfElseStatement extends PsiElement {

  @NotNull
  List<ACSScriptFunctionBody> getFunctionBodyList();

  @Nullable
  ACSScriptIfElseStatement getIfElseStatement();

  @NotNull
  ACSScriptLogicalType getLogicalType();

}
