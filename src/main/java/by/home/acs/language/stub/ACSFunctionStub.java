package by.home.acs.language.stub;

import by.home.acs.language.psi.ACSFunctionElement;
import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NotNull;

public interface ACSFunctionStub extends StubElement<ACSFunctionElement> {
    @NotNull
    String getFunctionName();
}
