package by.home.acs.language.psi;

import by.home.acs.language.ACSScriptLanguage;
import by.home.acs.language.stub.ACSFileElementType;
import by.home.acs.language.stub.ACSStubElementType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class ACSScriptElementType extends IElementType {
    public ACSScriptElementType(@NotNull String debugName) {
        super(debugName, ACSScriptLanguage.INSTANCE);
    }

    public static IElementType createTypes(String type) {
        if (type.equals("FUNCTION_NAME")) {
            return ACSFileElementType.stub;
        } else {
            return new ACSScriptElementType(type);
        }
    }
}
