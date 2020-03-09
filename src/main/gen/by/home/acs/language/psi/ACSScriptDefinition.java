// This is a generated file. Not intended for manual editing.
package by.home.acs.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ACSScriptDefinition extends PsiElement {

  @Nullable
  ACSScriptDirectivesDeclaration getDirectivesDeclaration();

  @Nullable
  ACSScriptFunctionDefinition getFunctionDefinition();

  @Nullable
  ACSScriptGlobalModifier getGlobalModifier();

  @Nullable
  ACSScriptScriptDefinition getScriptDefinition();

}
