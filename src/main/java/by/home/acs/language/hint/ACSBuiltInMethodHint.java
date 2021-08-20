package by.home.acs.language.hint;

import com.intellij.codeInsight.hints.InlayInfo;
import com.intellij.codeInsight.hints.InlayParameterHintsProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

//Not implemented.
public class ACSBuiltInMethodHint implements InlayParameterHintsProvider {
    @Override
    public @NotNull
    List<InlayInfo> getParameterHints(@NotNull PsiElement element) {
        return InlayParameterHintsProvider.super.getParameterHints(element);
    }

    @Override
    public @NotNull
    List<InlayInfo> getParameterHints(@NotNull PsiElement element, @NotNull PsiFile file) {
        return InlayParameterHintsProvider.super.getParameterHints(element, file);
    }

    @Override
    public @NotNull
    Set<String> getDefaultBlackList() {
        return null;
    }
}
