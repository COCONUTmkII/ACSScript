package by.home.acs.language.archive.wad;

import by.home.acs.language.archive.BaseArchiveHandler;
import com.Ostermiller.util.CircularByteBuffer;
import com.intellij.util.io.FileAccessorCache;
import kotlin.jvm.Synchronized;
import net.sf.sevenzipjbinding.*;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import static by.home.acs.language.archive.FileStructureUtils.convertPathToIdea;
import static by.home.acs.language.archive.FileStructureUtils.getAndUse;

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

    // Jesus, sorry for this method...
    // Instead of returning getAndUse i changed the implementations
    @Override
    @NotNull
    protected Map<String, EntryInfo> createEntriesMap() throws IOException {
        getAndUse(getFileHandle(), holder -> {
            try {
                return holder.useStream(wadArchiveHolder -> {
                    var simpleInArchive = holder.simpleInterface;
                    var archive = holder.archive;
                    if (archive != null) {
                        try {
                            var stringEntryInfoLinkedHashMap = new LinkedHashMap<String, EntryInfo>(simpleInArchive.getNumberOfItems());
                            stringEntryInfoLinkedHashMap.put("", createRootEntry());
                            if (isSingleFileArchive(archive)) {
                                var entry = simpleInArchive.getArchiveItem(0);
                                var path = createEntryNameForSingleArchive(entry);
                                return getOrCreate(entry, stringEntryInfoLinkedHashMap, simpleInArchive, path);
                            } else {
                                for (ISimpleInArchiveItem item : simpleInArchive.getArchiveItems()) {
                                    return getOrCreate(item, stringEntryInfoLinkedHashMap, simpleInArchive, null);
                                }
                            }
                        } catch (SevenZipException ignored) {
                        }
                    }
                    return Collections.emptyMap();
                });
            } catch (IOException ignored) {
            }
            return Collections.emptyMap();
        });
        return Collections.emptyMap();
    }

    private EntryInfo getOrCreate(ISimpleInArchiveItem item, LinkedHashMap<String, EntryInfo> map,
                                  ISimpleInArchive archive, String altEntryName) throws SevenZipException {
        var entryName = altEntryName == null ? convertPathToIdea(item.getPath()) : altEntryName;
        var info = map.get(entryName);
        if (info != null) {
            return info;
        }
        var path = splitPathAndFix(entryName);
        var parentInfo = getOrCreate(path.first, map, archive);
        if (".".equals(path.second)) {
            return parentInfo;
        }
        var shortName = convertNameToBytes(path.second);
        var definedLength = checkLengthOrCreate(item.getSize());
        var definedCreationTime = checkCreationTimeOrCreate(item);
        info = new EntryInfo(shortName, item.isFolder(), definedLength, definedCreationTime, parentInfo);
        map.put(entryName, info);
        return info;
    }

    private EntryInfo getOrCreate(String entryName, LinkedHashMap<String, EntryInfo> map, ISimpleInArchive archive) throws SevenZipException {
        var info = map.get(entryName);
        if (info != null) {
            var items = archive.getArchiveItems();
            for (ISimpleInArchiveItem item : items) {
                var myItem = convertPathToIdea(item.getPath());
                if (myItem.equals(entryName)) {
                    return getOrCreate(item, map, archive, null);
                }
            }
            var path = splitPathAndFix(entryName);
            var parentInfo = getOrCreate(path.first, map, archive);
            info = new EntryInfo(convertNameToBytes(path.second), true, DEFAULT_LENGTH, DEFAULT_TIMESTAMP, parentInfo);
            map.put(entryName, info);
        }
        if (info != null && !info.isDirectory) {
            info = new EntryInfo(info.shortName, true, info.length, info.timestamp, info.parent);
            map.put(entryName, info);
        }
        return info;
    }

    private Long checkLengthOrCreate(Long size) {
        return size == null ? DEFAULT_LENGTH : size;
    }

    private Long checkCreationTimeOrCreate(ISimpleInArchiveItem item) throws SevenZipException {
        return item.getCreationTime() == null ? DEFAULT_TIMESTAMP : item.getCreationTime().getTime();
    }

    @SuppressWarnings("Not suggested merged archive extensions")
    private String createEntryNameForSingleArchive(ISimpleInArchiveItem entry) throws SevenZipException {
        var path = convertPathToIdea(entry.getPath());
        if (!path.isEmpty()) {
            return path;
        }
        var archiveFileName = getFile().getName();
        return archiveFileName.substring(0, archiveFileName.lastIndexOf('.'));
    }

    private boolean isSingleFileArchive(IInArchive archive) throws SevenZipException {
        return (archive.getNumberOfItems() == 1 && archive.getArchiveFormat() == null)
                || !archive.getArchiveFormat().supportMultipleFiles();
    }


    @Override
    public @NotNull
    byte[] contentsToByteArray(@NotNull String relativePath) throws IOException {
        return new byte[0];
    }

    public static class WADArchiveHolder implements Closeable {
        private final ReusableRandomAccessFileStream stream;
        private final IInArchive archive;
        private final ISimpleInArchive simpleInterface;

        public WADArchiveHolder(File file) {
            this.stream = new ReusableRandomAccessFileStream(file);
            this.archive = toArchive();
            this.simpleInterface = archive.getSimpleInterface();
        }

        @Nullable
        public IInArchive toArchive() {
            IInArchive archive = null;
            try (stream) {
                archive = SevenZip.openInArchive(null, stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return archive;
        }

        public <R> R useStream(Function<WADArchiveHolder, R> block) throws IOException {
            try (stream) {
                return block.apply(this);
            }
        }

        public void closeStream() throws IOException {
            stream.close();
        }

        public void close() throws IOException {
            try (stream) {
                try (archive) {
                    simpleInterface.close();
                }
            }
        }
    }

    private static class WADInputStream extends InputStream {
        private final WADArchiveHolder holder;
        private final ISimpleInArchiveItem item;
        private final CircularByteBuffer buffer = null;
        private final InputStream stream = null;

        public WADInputStream(WADArchiveHolder holder, ISimpleInArchiveItem item) {
            this.holder = holder;
            this.item = item;
        }

        @Override
        public int read() throws IOException {
            return 0;
        }
    }

    private static class ReusableRandomAccessFileStream implements IInStream {
        private final File file;
        private RandomAccessFile accessFile = null;
        private Long filePointer = 0L;

        public ReusableRandomAccessFileStream(File file) {
            this.file = file;
        }

        @Synchronized
        @Override
        public long seek(long offset, int seekOrigin) {
            try {
                final var openedFile = getRandomFile();
                switch (seekOrigin) {
                    case ISeekableStream.SEEK_SET:
                        openedFile.seek(offset);
                        break;
                    case ISeekableStream.SEEK_CUR:
                        openedFile.seek(openedFile.getFilePointer() + offset);
                        break;
                    case ISeekableStream.SEEK_END:
                        openedFile.seek(openedFile.length() + offset);
                        break;
                    default:
                        throw new IllegalArgumentException("Seek: unknown origin" + seekOrigin);
                }
                filePointer = openedFile.getFilePointer();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return filePointer;
        }

        @Synchronized
        @Override
        public int read(byte[] data) {
            int readByte = 0;
            try {
                final var openedFile = getRandomFile();
                final var read = openedFile.read(data);
                filePointer = openedFile.getFilePointer();
                if (read != -1) {
                    readByte = read;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return readByte;
        }

        @Synchronized
        @Override
        public void close() throws IOException {
            if (accessFile != null) {
                accessFile.close();
                accessFile = null;
            }
        }

        private RandomAccessFile getRandomFile() throws IOException {
            return accessFile != null ? accessFile : generateAccessFile();
        }

        private RandomAccessFile generateAccessFile() throws IOException {
            var randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.seek(filePointer);
            accessFile = randomAccessFile;
            return randomAccessFile;
        }
    }
}
