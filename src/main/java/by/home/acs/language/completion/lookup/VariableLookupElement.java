package by.home.acs.language.completion.lookup;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.ui.JBColor;
import com.intellij.util.PlatformIcons;

public class VariableLookupElement {
    private final LookupElement variableLookupElement;

    public VariableLookupElement(String completionString) {
        this.variableLookupElement = LookupElementBuilder.create(completionString)
                .withPresentableText(completionString)
                .withItemTextForeground(JBColor.BLACK)
                .bold()
                .withIcon(PlatformIcons.VARIABLE_ICON)
                .withTailText(" primitive variable");
    }

    public LookupElement getVariableLookupElement() {
        return variableLookupElement;
    }
}
