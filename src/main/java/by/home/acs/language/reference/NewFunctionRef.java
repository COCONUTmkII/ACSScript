package by.home.acs.language.reference;

import by.home.acs.language.psi.ACSFunctionElement;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class NewFunctionRef extends PsiReferenceBase<ACSFunctionElement> {

    public NewFunctionRef(@NotNull ACSFunctionElement element) {
        super(element);
    }

    @Override
    @NotNull
    public TextRange getRangeInElement() {
        return TextRange.from(0, myElement.getTextLength());
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        return myElement;
    }

}
