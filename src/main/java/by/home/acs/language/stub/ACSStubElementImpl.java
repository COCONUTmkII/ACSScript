package by.home.acs.language.stub;

import by.home.acs.language.ACSScriptLanguage;
import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import org.jetbrains.annotations.NotNull;

public class ACSStubElementImpl<T extends StubElement> extends StubBasedPsiElementBase<T> {
    public ACSStubElementImpl(@NotNull T stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public ACSStubElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public @NotNull
    Language getLanguage() {
        return ACSScriptLanguage.INSTANCE;
    }
}
