package by.home.acs.language.archive.wad;

import by.home.acs.language.archive.BaseArchiveHandler;
import com.intellij.util.io.FileAccessorCache;
import org.jetbrains.annotations.NotNull;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

//TODO implement methods and test on actual wad archive. Also check is it binary
public class WADArchiveHandler extends BaseArchiveHandler<WADArchiveHandler.WADArchiveHolder> {

    public WADArchiveHandler(String localPath) {
        super(localPath);
    }

    @Override
    public FileAccessorCache<BaseArchiveHandler<WADArchiveHolder>, WADArchiveHolder> accessorCache() {
        return null;
    }

    @Override
    public WADArchiveHolder onCreate(BaseArchiveHandler<WADArchiveHolder> key) {
        return null;
    }

    @Override
    public void onDispose(WADArchiveHolder accessor) {

    }

    @Override
    public boolean onEqual(BaseArchiveHandler<WADArchiveHolder> firstHandler, BaseArchiveHandler<WADArchiveHolder> secondHandler) {
        return false;
    }



    @Override
    protected @NotNull Map<String, EntryInfo> createEntriesMap() throws IOException {
        return null;
    }

    @Override
    public @NotNull byte[] contentsToByteArray(@NotNull String relativePath) throws IOException {
        return new byte[0];
    }

    public static class WADArchiveHolder implements Closeable {

        @Override
        public void close() throws IOException {

        }
    }
}
