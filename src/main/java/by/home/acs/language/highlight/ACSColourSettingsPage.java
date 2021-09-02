package by.home.acs.language.highlight;

import by.home.acs.language.ACSScriptIcon;
import by.home.acs.language.ACSScriptLanguage;
import com.intellij.application.options.colors.InspectionColorSettingsPage;
import com.intellij.codeHighlighting.RainbowHighlighter;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.colors.CodeInsightColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.RainbowColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.psi.codeStyle.DisplayPriority;
import com.intellij.psi.codeStyle.DisplayPrioritySortable;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class ACSColourSettingsPage implements RainbowColorSettingsPage, InspectionColorSettingsPage, DisplayPrioritySortable {

    @NonNls
    private static final Map<String, TextAttributesKey> ourTags = RainbowHighlighter.createRainbowHLM();

    static {
        ourTags.put("Function Call", ACSScriptTextAttributeKeyValue.FUNCTION_CALL);
        ourTags.put("unusedField", CodeInsightColors.NOT_USED_ELEMENT_ATTRIBUTES);
    }

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Key", ACSScriptTextAttributeKeyValue.KEY),
            new AttributesDescriptor("Function Call", ACSScriptTextAttributeKeyValue.FUNCTION_CALL),
            new AttributesDescriptor("Bad Value", ACSScriptTextAttributeKeyValue.BAD_CHARACTER),
            new AttributesDescriptor("String", ACSScriptTextAttributeKeyValue.STRING_VALUE),
            new AttributesDescriptor("Number", ACSScriptTextAttributeKeyValue.INT_VALUE)
    };

    @Override
    public @Nullable
    Icon getIcon() {
        return ACSScriptIcon.FILE;
    }

    @Override
    public @NotNull
    SyntaxHighlighter getHighlighter() {
        return new ACSScriptSyntaxHighlighter();
    }

    @Override
    public @NotNull
    String getDemoText() {
        return "#include \"zcommon.acs\"\n" +
                "\n" +
                "script 1 (void)\n" +
                "{\n" +
                "HudMessage(i: 123, s: \"123\"; 2, 1, 3, 0.1, 0.9, 5.0);\n" +
                "kek(1, 2);\n" +
                "}\n" +
                "\n" +
                "function void kek(int a, int b) {\n" +
                "    Log(i: a, i: b);\n" +
                "}\n";
    }

    @Override
    public @Nullable
    Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return ourTags;
    }

    @Override
    public @NotNull
    AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public @NotNull
    ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull
    @NlsContexts.ConfigurableName String getDisplayName() {
        return "Action Code Script";
    }

    @Override
    public boolean isRainbowType(TextAttributesKey type) {
        return false;
    }

    @Override
    public @Nullable
    Language getLanguage() {
        return ACSScriptLanguage.INSTANCE;
    }

    @Override
    public DisplayPriority getPriority() {
        return DisplayPriority.KEY_LANGUAGE_SETTINGS;
    }
};