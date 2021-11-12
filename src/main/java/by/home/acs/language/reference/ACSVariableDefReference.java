package by.home.acs.language.reference;

import by.home.acs.language.psi.ACSVariableDefElement;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ACSVariableDefReference extends PsiReferenceBase<ACSVariableDefElement> {

    public ACSVariableDefReference(@NotNull ACSVariableDefElement element) {
        super(element);
    }

    @Override
    public @NotNull
    TextRange getRangeInElement() {
        return TextRange.from(0, myElement.getTextLength());
    }

    @Override
    public @Nullable
    PsiElement resolve() {
        return myElement;
    }
}
