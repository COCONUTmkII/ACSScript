package by.home.acs.language.psi;

import by.home.acs.language.stub.function.ACSFunctionStub;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.StubBasedPsiElement;

public interface ACSFunctionElement extends PsiNameIdentifierOwner, StubBasedPsiElement<ACSFunctionStub>, NavigatablePsiElement {
    String getFunctionName();
}
