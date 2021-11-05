package by.home.acs.language.stub;

import by.home.acs.language.psi.ACSScriptFile;
import com.intellij.psi.stubs.PsiFileStubImpl;

public class ACSFileStub extends PsiFileStubImpl<ACSScriptFile> {

    public ACSFileStub(ACSScriptFile file) {
        super(file);
    }
}
