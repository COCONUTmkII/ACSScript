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
        private final ReusableRandomAccessFileStream stream;
        private final IInArchive archive;
        private final ISimpleInArchive simpleInterface;

        public WADArchiveHolder(File file) {
            this.stream = new ReusableRandomAccessFileStream(file);
            this.archive = toArchive();
            this.simpleInterface = archive.getSimpleInterface();
        }

        @Nullable
        @SuppressWarnings("May throw NPE")
        public IInArchive toArchive() {
            IInArchive archive = null;
            try (stream) {
                archive = SevenZip.openInArchive(null, stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return archive;
        }

        //TODO IMPLEMENT THIS
        /**
         *fun <R> useStream(block: (SevenZipArchiveHolder) -> R): R {
         *  return stream.use {
         *    block(this)
         *  }
         *}
         *
         */
        public void useStream( WADArchiveHolder holder) throws IOException {

        }

        public void closeStream() throws IOException {
            stream.close();
        }

        public void close() throws IOException {
            try(stream) {
                try(archive) {
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
                    case ISeekableStream.SEEK_SET: openedFile.seek(offset);
                    break;
                    case ISeekableStream.SEEK_CUR: openedFile.seek(openedFile.getFilePointer() + offset);
                    break;
                    case ISeekableStream.SEEK_END: openedFile.seek(openedFile.length() + offset);
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
