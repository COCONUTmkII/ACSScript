package by.home.acs.language.archive;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Map;

public interface SupportedArchiveType extends Closeable {
    Map<String, EntryInfo> createdEntriesFromMap();

    byte[] getEntryBytes(String relativePath);

    InputStream getInputStream();
}
