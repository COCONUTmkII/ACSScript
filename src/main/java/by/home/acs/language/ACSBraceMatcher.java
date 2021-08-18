package by.home.acs.language;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ACSBraceMatcher implements PairedBraceMatcher {
    public static final BracePair[] BRACE_PAIRS = {
            new BracePair(ACSScriptTypes.OPEN_BRACE, ACSScriptTypes.CLOSE_BRACE, true),
            new BracePair(ACSScriptTypes.OPEN_BRACKET, ACSScriptTypes.CLOSE_BRACKET, true),
            new BracePair(ACSScriptTypes.OPEN_SQUARE_BRACKET, ACSScriptTypes.CLOSE_SQUARE_BRACKET, true)
    };


    @NotNull
    @Override
    public BracePair[] getPairs() {
        return BRACE_PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return contextType == null;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
