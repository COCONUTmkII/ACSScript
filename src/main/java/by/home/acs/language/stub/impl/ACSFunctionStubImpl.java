package by.home.acs.language.stub.impl;

import by.home.acs.language.psi.ACSFunctionElement;
import by.home.acs.language.stub.ACSFileElementType;
import by.home.acs.language.stub.ACSFunctionStub;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NotNull;

public class ACSFunctionStubImpl extends StubBase<ACSFunctionElement> implements ACSFunctionStub {

    private final String myFunctionName;

    public ACSFunctionStubImpl(final StubElement parent, String elementType) {
        super(parent, ACSFileElementType.stub);
        myFunctionName = elementType;
    }

    @NotNull
    @Override
    public String getFunctionName() {
        return myFunctionName;
    }
}
