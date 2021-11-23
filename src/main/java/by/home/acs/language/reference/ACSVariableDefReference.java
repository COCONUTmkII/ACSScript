package by.home.acs.language.reference;

import by.home.acs.language.psi.ACSVariableElement;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ACSVariableDefReference extends PsiReferenceBase<ACSVariableElement> {

    public ACSVariableDefReference(@NotNull ACSVariableElement element) {
        super(element);
    }

    @Override
    public @NotNull
    TextRange getRangeInElement() {
        return TextRange.from(0, myElement.getTextLength());
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        return myElement;
    }
}
