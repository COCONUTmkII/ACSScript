package by.home.acs.language.psi;

import by.home.acs.language.psi.impl.ACSFunctionElementImpl;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import org.jetbrains.annotations.NotNull;

public class ACSFunctionEscaper extends LiteralTextEscaper<ACSFunctionElementImpl> {

    private int[] outSourceOffsets;

    public ACSFunctionEscaper(@NotNull ACSFunctionElementImpl host) {
        super(host);
    }

    //FIXME refactor this is need
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

    @Override
    public boolean isOneLine() {
        return !myHost.getText().contains("\\");
    }
}
