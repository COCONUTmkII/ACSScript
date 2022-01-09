package by.home.acs.language.archive;

import com.intellij.openapi.util.io.FileSystemUtil;
import com.intellij.openapi.vfs.impl.ArchiveHandler;
import com.intellij.util.io.FileAccessorCache;
import com.intellij.util.text.ByteArrayCharSequence;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public abstract class BaseArchiveHandler<T> extends ArchiveHandler {
    public volatile Long myFileStamp = DEFAULT_TIMESTAMP;
    public volatile Long myFileLength = DEFAULT_LENGTH;

    public abstract FileAccessorCache<BaseArchiveHandler<T>, T> accessorCache();
    public abstract T onCreate(BaseArchiveHandler<T> key);
    public abstract void onDispose(T accessor);
    public abstract boolean onEqual(BaseArchiveHandler<T> firstHandler, BaseArchiveHandler<T> secondHandler);

    protected BaseArchiveHandler(@NotNull String path) {
        super(path);
    }

    protected FileAccessorCache.Handle<T> getFileHandle() throws IOException {
        var handle = accessorCache().get(this);
        var canonicalFile = getFile().getCanonicalFile();
        var attributes = FileSystemUtil.getAttributes(canonicalFile);
        Objects.requireNonNull(attributes, canonicalFile.getName());
        if (attributes.lastModified == myFileStamp && attributes.length == myFileLength) {
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

    /**
     * This might work wrong because original method was created with default parameters.
     * onCreate, onDispose and OnEqual methods was also provided as a parameters.
     */
    protected FileAccessorCache<BaseArchiveHandler<T>, T> createCache(int protectedQueueSize, int probationalQueueSize) {
        return new FileAccessorCache<>(protectedQueueSize, probationalQueueSize) {
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
                return onCreate(key);
            }

            @Override
            protected void disposeAccessor(@NotNull T fileAccessor) throws IOException {
                onDispose(fileAccessor);
            }

            @Override
            public boolean isEqual(BaseArchiveHandler<T> val1, BaseArchiveHandler<T> val2) {
                return onEqual(val1, val2);
            }
        };
    }
}
