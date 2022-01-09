package by.home.acs.language.archive.wad;

import by.home.acs.language.ACSScriptIcon;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class WADFile implements FileType {
    @Override
    public @NotNull String getName() {
        return "wad";
    }

    @Override
    public @NotNull
    @NlsContexts.Label String getDescription() {
        return "WAD file archive";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "wad";
    }

    @Override
    public @Nullable Icon getIcon() {
        return ACSScriptIcon.FILE;
    }

    //is it false?
    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public @Nullable String getCharset(@NotNull VirtualFile file,  @NotNull byte[] content) {
        return null;
    }
}
