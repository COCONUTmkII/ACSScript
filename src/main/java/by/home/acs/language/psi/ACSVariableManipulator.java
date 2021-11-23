package by.home.acs.language.psi;

import by.home.acs.language.psi.impl.ACSVariableElementImpl;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ACSVariableManipulator extends AbstractElementManipulator<ACSVariableElementImpl> {

    @Override
    public @Nullable
    ACSVariableElementImpl handleContentChange(@NotNull ACSVariableElementImpl element, @NotNull TextRange range, String newContent) throws IncorrectOperationException {
        TextRange textRange = getRangeInElement(element);
        final String oldName = element.getText();
        String newName = oldName.substring(0, range.getStartOffset()) + newContent + oldName.substring(range.getEndOffset());
        element.setName(newName.substring(textRange.getStartOffset()));
        return element;
    }

    @Override
    public ACSVariableElementImpl handleContentChange(@NotNull ACSVariableElementImpl element, String newContent) throws IncorrectOperationException {
        return super.handleContentChange(element, newContent);
    }

    //maybe get range in element required here. need to check
}
