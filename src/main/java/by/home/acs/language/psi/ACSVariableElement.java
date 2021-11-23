package by.home.acs.language.psi;

import by.home.acs.language.stub.variable.ACSVariableStub;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.StubBasedPsiElement;

public interface ACSVariableElement extends PsiNameIdentifierOwner, StubBasedPsiElement<ACSVariableStub>, NavigatablePsiElement {
    String getVariableName();
}
