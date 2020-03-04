package by.home.acs.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ACSScriptType extends LanguageFileType {
    public static final ACSScriptType INSTANCE = new ACSScriptType();

    private ACSScriptType() {
        super(ACSScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "ACS Script file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "ACS Script language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "acs";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return ACSScriptIcon.FILE;
    }
}
