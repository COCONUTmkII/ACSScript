package by.home.acs.language.archive;

import java.util.Set;

public class ACSArchiveProvider {
    public static final Set<String> SUPPORTED_ARCHIVE_EXTENSIONS = Set.of(
            ACSSupportedArchiveTypes.DOT + ACSSupportedArchiveTypes.WAD_FILE,
            ACSSupportedArchiveTypes.DOT + ACSSupportedArchiveTypes.PK3_FILE
    );
}
