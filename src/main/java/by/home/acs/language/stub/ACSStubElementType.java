package by.home.acs.language.stub;

import by.home.acs.language.ACSScriptLanguage;
import by.home.acs.language.psi.ACSFunctionElement;
import by.home.acs.language.psi.impl.ACSFunctionElementImpl;
import by.home.acs.language.stub.impl.ACSFunctionStubImpl;
import by.home.acs.language.stub.index.ACSStubIndexKeys;
import com.intellij.psi.stubs.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ACSStubElementType extends IStubElementType<ACSFunctionStub, ACSFunctionElement> {

    public ACSStubElementType() {
        super("FUNCTION_NAME", ACSScriptLanguage.INSTANCE);
    }


    @Override
    public ACSFunctionElement createPsi(@NotNull ACSFunctionStub stub) {
        return new ACSFunctionElementImpl(stub, this);
    }

    @Override
    public @NotNull
    ACSFunctionStub createStub(@NotNull ACSFunctionElement psi, StubElement parentStub) {
        return new ACSFunctionStubImpl(parentStub, psi.getStub().getFunctionName());
    }

    @Override
    public @NotNull
    String getExternalId() {
        return "actioncodescript.acs";
    }

    @Override
    public void serialize(@NotNull ACSFunctionStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getFunctionName());
    }

    @Override
    public @NotNull
    ACSFunctionStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new ACSFunctionStubImpl(parentStub, dataStream.readNameString());
    }

    @Override
    public void indexStub(@NotNull ACSFunctionStub stub, @NotNull IndexSink sink) {
        sink.occurrence(ACSStubIndexKeys.FUNCTIONS, stub.getFunctionName());
    }
}
