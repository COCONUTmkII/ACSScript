package by.home.acs.language.stub.variable;

import by.home.acs.language.psi.ACSVariableElement;
import by.home.acs.language.stub.ACSFileElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NotNull;

public class ACSVariableStubImpl extends StubBase<ACSVariableElement> implements ACSVariableStub {

    private final String myVarName;

    public ACSVariableStubImpl(final StubElement parent, String elementType) {
        super(parent, ACSFileElementType.VARIABLE_STUB);
        this.myVarName = elementType;
    }

    @NotNull
    @Override
    public String getVariableName() {
        return myVarName;
    }
}
