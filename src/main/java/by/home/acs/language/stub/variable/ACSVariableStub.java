package by.home.acs.language.stub.variable;

import by.home.acs.language.psi.ACSVariableElement;
import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NotNull;

public interface ACSVariableStub extends StubElement<ACSVariableElement> {
    @NotNull
    String getVariableName();
}
