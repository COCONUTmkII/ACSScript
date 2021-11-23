package by.home.acs.language.psi;

import by.home.acs.language.psi.impl.ACSFunctionElementImpl;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ACSFunctionManipulator extends AbstractElementManipulator<ACSFunctionElementImpl> {
    @Override
    public @Nullable
    ACSFunctionElementImpl handleContentChange(@NotNull ACSFunctionElementImpl element, @NotNull TextRange range, String newContent) throws IncorrectOperationException {
        TextRange textRange = getRangeInElement(element);
        final String oldName = element.getText();
        String newName = oldName.substring(0, range.getStartOffset()) + newContent + oldName.substring(range.getEndOffset());
        element.setName(newName.substring(textRange.getStartOffset()));
        return element;
    }

    @Override
    public ACSFunctionElementImpl handleContentChange(@NotNull ACSFunctionElementImpl element, String newContent) throws IncorrectOperationException {
        return super.handleContentChange(element, newContent);
    }

    @Override
    public @NotNull
    TextRange getRangeInElement(@NotNull ACSFunctionElementImpl element) {
        ASTNode valueNode = element.getFunctionNamesNode();
        if (valueNode == null) {
            return TextRange.from(element.getTextLength(), 0);
        } else {
            TextRange range = valueNode.getTextRange();
            return TextRange.from(range.getStartOffset() - element.getTextRange().getStartOffset(), range.getLength());
        }
    }
}
