package by.home.acs.language.stub.index;

import by.home.acs.language.psi.ACSFunctionElement;
import com.intellij.psi.stubs.StubIndexKey;

public interface ACSStubIndexKeys {
    StubIndexKey<String, ACSFunctionElement> FUNCTIONS = StubIndexKey.createIndexKey("acs.function.name");
}
