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

public class ACSScriptStatementImpl extends ASTWrapperPsiElement implements ACSScriptStatement {

  public ACSScriptStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ACSScriptVisitor visitor) {
    visitor.visitStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ACSScriptVisitor) accept((ACSScriptVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ACSScriptAssignmentStatement getAssignmentStatement() {
    return findChildByClass(ACSScriptAssignmentStatement.class);
  }

  @Override
  @Nullable
  public ACSScriptFunctionInvocation getFunctionInvocation() {
    return findChildByClass(ACSScriptFunctionInvocation.class);
  }

  @Override
  @Nullable
  public ACSScriptVariableDefinition getVariableDefinition() {
    return findChildByClass(ACSScriptVariableDefinition.class);
  }

}
