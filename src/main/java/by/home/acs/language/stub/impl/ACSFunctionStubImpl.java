package by.home.acs.language.stub.impl;

import by.home.acs.language.psi.ACSFunctionElement;
import by.home.acs.language.stub.ACSFunctionStub;
import by.home.acs.language.stub.ACSStubElementType;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NotNull;

public class ACSFunctionStubImpl extends StubBase<ACSFunctionElement> implements ACSFunctionStub {
    private final String myFunctionName;
    private static final IStubElementType<ACSFunctionStub, ACSFunctionElement> stub = new ACSStubElementType();

    public ACSFunctionStubImpl(final StubElement parent, String elementType) {
        super(parent, stub);
        myFunctionName = elementType;
    }

    @NotNull
    @Override
    public String getFunctionName() {
        return myFunctionName;
    }
}
