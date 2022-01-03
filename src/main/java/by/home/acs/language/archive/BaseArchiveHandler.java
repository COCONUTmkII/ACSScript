package by.home.acs.language.archive;

import com.intellij.openapi.vfs.impl.ArchiveHandler;
import org.jetbrains.annotations.NotNull;

//TODO implement this
public abstract class BaseArchiveHandler extends ArchiveHandler {
    public volatile Long myFileStamp = DEFAULT_TIMESTAMP;
    public volatile Long myFileLength = DEFAULT_LENGTH;

    protected BaseArchiveHandler(@NotNull String path) {
        super(path);
    }
}
