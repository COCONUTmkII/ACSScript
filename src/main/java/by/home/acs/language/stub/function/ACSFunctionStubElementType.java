package by.home.acs.language.stub.function;

import by.home.acs.language.ACSScriptLanguage;
import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSFunctionElement;
import by.home.acs.language.psi.impl.ACSFunctionElementImpl;
import by.home.acs.language.stub.index.ACSStubIndexKeys;
import com.intellij.lang.LighterAST;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.LighterASTTokenNode;
import com.intellij.psi.impl.source.tree.LightTreeUtil;
import com.intellij.psi.stubs.*;
import com.intellij.util.CharTable;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ACSFunctionStubElementType extends ILightStubElementType<ACSFunctionStub, ACSFunctionElement> {

    public ACSFunctionStubElementType() {
        super("FUNCTION_NAME", ACSScriptLanguage.INSTANCE);
    }


    @Override
    public ACSFunctionElement createPsi(@NotNull ACSFunctionStub stub) {
        return new ACSFunctionElementImpl(stub, this);
    }

    @Override
    public @NotNull
    ACSFunctionStub createStub(@NotNull ACSFunctionElement psi, StubElement parentStub) {
        return new ACSFunctionStubImpl(parentStub, psi.getFunctionName());
    }

    @Override
    public @NotNull
    String getExternalId() {
        return "function.acs";
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

    @Override
    public @NotNull ACSFunctionStub createStub(@NotNull LighterAST tree, @NotNull LighterASTNode node, @NotNull StubElement parentStub) {
        LighterASTNode functionNode = LightTreeUtil.firstChildOfType(tree, node, ACSScriptTypes.FUNCTION_NAME);
        String functionName = intern(tree.getCharTable(), functionNode);
        return new ACSFunctionStubImpl(parentStub, functionName);
    }

    private String intern(CharTable charTable, LighterASTNode functionNode) {
        assert functionNode instanceof LighterASTTokenNode : functionNode;
        return charTable.intern(((LighterASTTokenNode)functionNode).getText()).toString();
    }
}
