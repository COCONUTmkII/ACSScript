package by.home.acs.language.stub.index;

import by.home.acs.language.psi.ACSFunctionElement;
import by.home.acs.language.psi.ACSVariableElement;
import com.intellij.psi.stubs.StubIndexKey;

public interface ACSStubIndexKeys {
    StubIndexKey<String, ACSFunctionElement> FUNCTIONS = StubIndexKey.createIndexKey("acs.function.name");
    StubIndexKey<String, ACSVariableElement> VARIABLES = StubIndexKey.createIndexKey("acs.variable.name");
}
