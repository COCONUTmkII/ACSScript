package by.home.acs.language.archive;

import com.intellij.openapi.vfs.impl.ArchiveHandler;
import com.intellij.util.io.FileAccessorCache;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

//TODO implement this
public abstract class BaseArchiveHandler<T> extends ArchiveHandler {
    public volatile Long myFileStamp = DEFAULT_TIMESTAMP;
    public volatile Long myFileLength = DEFAULT_LENGTH;

    public abstract FileAccessorCache<BaseArchiveHandler<T>, T> accessorCache();

    protected BaseArchiveHandler(@NotNull String path) {
        super(path);
    }

    protected FileAccessorCache.Handle<T> getFileHandle() throws IOException {
        var handle = accessorCache(); //here was [this]
        var canonicalFile = getFile().getCanonicalFile();
        //TODO attributes
        return null;
    }

    @Override
    protected void clearCaches() {
        accessorCache().remove(this);
        super.clearCaches();
    }

    protected CharSequence convertNameToBytes(String name) {
        if (name == null) {
            return convertNameToBytes("");
        }
        //TODO need AppInfoUtil here to finish implementation
        return "";
    }

    //TODO createCache here needs to be implemented. Maybe arguments are not right here
    protected FileAccessorCache<BaseArchiveHandler<T>, T> createCache() {
        return null;
    }
}
