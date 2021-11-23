package by.home.acs.language.psi;

import by.home.acs.language.psi.impl.ACSVariableElementImpl;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import org.jetbrains.annotations.NotNull;

public class ACSVariableEscaper extends LiteralTextEscaper<ACSVariableElementImpl> {

    private int[] outSourceOffsets;

    public ACSVariableEscaper(ACSVariableElementImpl acsVariableElement) {
        super(acsVariableElement);
    }

    @Override
    public boolean decode(@NotNull TextRange rangeInsideHost, @NotNull StringBuilder outChars) {
        return true;
    }

    @Override
    public int getOffsetInHost(int offsetInDecoded, @NotNull TextRange rangeInsideHost) {
        int result = offsetInDecoded < outSourceOffsets.length ? outSourceOffsets[offsetInDecoded] : -1;
        if (result == -1) return -1;
        return Math.min(result, rangeInsideHost.getLength()) + rangeInsideHost.getStartOffset();
    }

    public boolean isOneLine() {
        return !myHost.getText().contains("\\");
    }
}
