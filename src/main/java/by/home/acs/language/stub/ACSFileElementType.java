package by.home.acs.language.stub;

import by.home.acs.language.psi.ACSFunctionElement;
import by.home.acs.language.stub.function.ACSFunctionStub;
import by.home.acs.language.stub.function.ACSFunctionStubElementType;
import com.intellij.lang.Language;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IStubFileElementType;

public class ACSFileElementType extends IStubFileElementType<ACSFileStub> {
    public ACSFileElementType(Language language) {
        super(language);
    }

    public static final IStubElementType<ACSFunctionStub, ACSFunctionElement> stub = new ACSFunctionStubElementType();
}
