package by.home.acs.language.archive;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public abstract class ACSBasedFileType implements FileType {

    @Override
    @NotNull
    public @NlsContexts.Label String getDescription() {
        return getName() + " archive";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.FileTypes.Archive;
    }

    @Override
    public String getCharset(@NotNull VirtualFile file, @NotNull byte[] content) {
        return null;
    }

    @Override
    public boolean isBinary() {
        return true;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

}
