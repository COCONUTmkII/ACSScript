package by.home.acs.language.psi;

import by.home.acs.language.ACSScriptLanguage;
import com.intellij.psi.tree.IElementType;
import com.sun.istack.NotNull;
import org.assertj.core.annotations.NonNull;

public class ACSScriptTokenType extends IElementType {
    public ACSScriptTokenType(@NotNull @NonNull String debugName) {
        super(debugName, ACSScriptLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "ACSScriptTokenType." + super.toString();
    }
}
