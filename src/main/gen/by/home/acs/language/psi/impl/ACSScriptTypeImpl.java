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

public class ACSScriptTypeImpl extends ASTWrapperPsiElement implements ACSScriptType {

  public ACSScriptTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ACSScriptVisitor visitor) {
    visitor.visitType(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ACSScriptVisitor) accept((ACSScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ACSScriptBoolType getBoolType() {
    return findChildByClass(ACSScriptBoolType.class);
  }

  @Override
  @Nullable
  public ACSScriptIntType getIntType() {
    return findChildByClass(ACSScriptIntType.class);
  }

  @Override
  @Nullable
  public ACSScriptStringType getStringType() {
    return findChildByClass(ACSScriptStringType.class);
  }

}
