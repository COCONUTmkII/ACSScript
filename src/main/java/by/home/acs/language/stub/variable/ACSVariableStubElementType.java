package by.home.acs.language.stub.variable;

import by.home.acs.language.ACSScriptLanguage;
import by.home.acs.language.ACSScriptTypes;
import by.home.acs.language.psi.ACSVariableElement;
import by.home.acs.language.psi.impl.ACSVariableElementImpl;
import by.home.acs.language.stub.index.ACSStubIndexKeys;
import com.intellij.lang.LighterAST;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.LighterASTTokenNode;
import com.intellij.psi.impl.source.tree.LightTreeUtil;
import com.intellij.psi.stubs.*;
import com.intellij.util.CharTable;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ACSVariableStubElementType extends ILightStubElementType<ACSVariableStub, ACSVariableElement> {

    public ACSVariableStubElementType() {
        super("VARIABLE_NAME", ACSScriptLanguage.INSTANCE);
    }

    @Override
    public @NotNull
    ACSVariableStub createStub(@NotNull LighterAST tree, @NotNull LighterASTNode node, @NotNull StubElement parentStub) {
        LighterASTNode variableNode = LightTreeUtil.firstChildOfType(tree, node, ACSScriptTypes.VARIABLE_NAME);
        String variableName = intern(tree.getCharTable(), variableNode);
        return new ACSVariableStubImpl(parentStub, variableName);
    }

    private String intern(CharTable charTable, LighterASTNode variableNode) {
        assert variableNode instanceof LighterASTTokenNode : variableNode;
        return charTable.intern(((LighterASTTokenNode) variableNode).getText()).toString();
    }

    @Override
    public ACSVariableElement createPsi(@NotNull ACSVariableStub stub) {
        return new ACSVariableElementImpl(stub, this);
    }

    @Override
    public @NotNull
    ACSVariableStub createStub(@NotNull ACSVariableElement psi, StubElement parentStub) {
        return new ACSVariableStubImpl(parentStub, psi.getVariableName());
    }

    @Override
    public @NotNull
    String getExternalId() {
        return "acsVariable";
    }

    @Override
    public void serialize(@NotNull ACSVariableStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getVariableName());
    }

    @Override
    public @NotNull
    ACSVariableStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new ACSVariableStubImpl(parentStub, dataStream.readNameString());
    }

    @Override
    public void indexStub(@NotNull ACSVariableStub stub, @NotNull IndexSink sink) {
        sink.occurrence(ACSStubIndexKeys.VARIABLES, stub.getVariableName());
    }


}
