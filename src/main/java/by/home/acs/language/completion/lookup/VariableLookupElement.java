package by.home.acs.language.completion.lookup;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.ui.JBColor;
import com.intellij.util.PlatformIcons;

public class VariableLookupElement {

    public static LookupElement createBoldLookupElement(String completionString) {
        return LookupElementBuilder.create(completionString)
                .withPresentableText(completionString)
                .withItemTextForeground(JBColor.BLACK)
                .bold();
    }

    public static LookupElement createBoldLookupElementWithIcon(String completionString) {
        return LookupElementBuilder.create(completionString)
                .withPresentableText(completionString)
                .withItemTextForeground(JBColor.BLACK)
                .bold()
                .withIcon(PlatformIcons.VARIABLE_ICON);
    }

    public static LookupElement createLookupElementWithTail(String completionString, String tailText) {
        return LookupElementBuilder.create(completionString)
                .withPresentableText(completionString)
                .withItemTextForeground(JBColor.BLACK)
                .bold()
                .withIcon(PlatformIcons.VARIABLE_ICON)
                .withTailText(tailText);
    }

    public static LookupElement createLookupElementWithTypeAndTail(String completionString, String typeText, String tailText) {
        return LookupElementBuilder.create(completionString)
                .withPresentableText(completionString)
                .withItemTextForeground(JBColor.BLACK)
                .bold()
                .withIcon(PlatformIcons.VARIABLE_ICON)
                .withTailText(tailText)
                .withTypeText(typeText);
    }

    public static LookupElement createTypeLookupElement(String completionString) {
        return LookupElementBuilder.create(completionString)
                .withPresentableText(completionString)
                .withItemTextForeground(JBColor.BLACK);
    }
}
