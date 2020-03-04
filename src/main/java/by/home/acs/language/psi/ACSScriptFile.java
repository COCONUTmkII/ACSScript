package by.home.acs.language.psi;

import by.home.acs.language.ACSScriptLanguage;
import by.home.acs.language.ACSScriptType;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class ACSScriptFile extends PsiFileBase {
    public ACSScriptFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ACSScriptLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ACSScriptType.INSTANCE;
    }

    @Override
    public String toString() {
        return "ACS Script File";
    }
}
