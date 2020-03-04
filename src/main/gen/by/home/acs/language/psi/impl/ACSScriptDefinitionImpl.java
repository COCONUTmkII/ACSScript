// This is a generated file. Not intended for manual editing.
package by.home.acs.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static by.home.acs.language.ACSScriptTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import by.home.acs.language.psi.*;

public class ACSScriptDefinitionImpl extends ASTWrapperPsiElement implements ACSScriptDefinition {

  public ACSScriptDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ACSScriptVisitor visitor) {
    visitor.visitDefinition(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ACSScriptVisitor) accept((ACSScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ACSScriptFunctionDefinition getFunctionDefinition() {
    return findChildByClass(ACSScriptFunctionDefinition.class);
  }

  @Override
  @Nullable
  public ACSScriptScriptDefinition getScriptDefinition() {
    return findChildByClass(ACSScriptScriptDefinition.class);
  }

}
