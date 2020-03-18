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

public class ACSScriptUntilLoopImpl extends ASTWrapperPsiElement implements ACSScriptUntilLoop {

  public ACSScriptUntilLoopImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ACSScriptVisitor visitor) {
    visitor.visitUntilLoop(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ACSScriptVisitor) accept((ACSScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ACSScriptLogicalType getLogicalType() {
    return findNotNullChildByClass(ACSScriptLogicalType.class);
  }

  @Override
  @Nullable
  public ACSScriptStatement getStatement() {
    return findChildByClass(ACSScriptStatement.class);
  }

}
