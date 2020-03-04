package by.home.acs.language.psi;

import by.home.acs.language.ACSScriptLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class ACSScriptElementType extends IElementType {
    public ACSScriptElementType(@NotNull String debugName) {
        super(debugName, ACSScriptLanguage.INSTANCE);
    }
}
