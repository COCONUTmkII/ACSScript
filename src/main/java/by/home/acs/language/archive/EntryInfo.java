package by.home.acs.language.archive;

import com.intellij.openapi.vfs.impl.ArchiveHandler;
import org.jetbrains.annotations.NotNull;

//TODO refactor this because of protected access for EntryInfo in ArchiveHandler
public abstract class EntryInfo extends ArchiveHandler {

    protected EntryInfo(@NotNull String path) {
        super(path);
    }

}
