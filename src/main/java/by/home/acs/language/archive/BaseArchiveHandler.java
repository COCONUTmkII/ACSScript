package by.home.acs.language.archive;

import com.intellij.openapi.util.io.FileSystemUtil;
import com.intellij.openapi.vfs.impl.ArchiveHandler;
import com.intellij.util.io.FileAccessorCache;
import com.intellij.util.text.ByteArrayCharSequence;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

//TODO implement this
public abstract class BaseArchiveHandler<T> extends ArchiveHandler {
    public volatile Long myFileStamp = DEFAULT_TIMESTAMP;
    public volatile Long myFileLength = DEFAULT_LENGTH;

    public abstract FileAccessorCache<BaseArchiveHandler<T>, T> accessorCache();

    protected BaseArchiveHandler(@NotNull String path) {
        super(path);
    }

    protected FileAccessorCache.Handle<T> getFileHandle() throws IOException {
        var handle = accessorCache().get(this);
        var canonicalFile = getFile().getCanonicalFile();
        var attributes = Optional.ofNullable(FileSystemUtil.getAttributes(canonicalFile));
        attributes.orElseThrow(() -> new FileNotFoundException(canonicalFile.getName()));
        if (attributes.get().lastModified == myFileStamp && attributes.get().length == myFileLength) {
            return handle;
        }
        clearCaches();
        handle.release();
        return accessorCache().get(this);
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
        return ByteArrayCharSequence.convertToBytesIfPossible(name); //could use deprecated convertToAsciByte if api version is >= 183
    }

    //TODO createCache here needs to be implemented. Maybe arguments are not right here
    protected FileAccessorCache<BaseArchiveHandler<T>, T> createCache(int protectedQueueSize, int probationalQueueSize) {
        return new FileAccessorCache<BaseArchiveHandler<T>, T>(protectedQueueSize, probationalQueueSize) {
            @Override
            protected @NotNull
            T createAccessor(BaseArchiveHandler<T> key) throws IOException {
                var attributes = Optional.ofNullable(FileSystemUtil.getAttributes(key.getFile().getCanonicalFile()));
                attributes.ifPresentOrElse(fileAttributes -> {
                    key.myFileStamp = fileAttributes.lastModified;
                    key.myFileLength = fileAttributes.length;
                }, () -> {
                    key.myFileStamp = ArchiveHandler.DEFAULT_TIMESTAMP;
                    key.myFileLength = ArchiveHandler.DEFAULT_LENGTH;
                });
                return null;
            }

            @Override
            protected void disposeAccessor(@NotNull T fileAccessor) throws IOException {
                //TODO understand how to close accessor
            }
        };
    }
}
