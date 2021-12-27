package by.home.acs.language.archive;

import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.newvfs.ArchiveFileSystem;
import com.intellij.openapi.vfs.newvfs.VfsImplUtil;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

public abstract class ACSBasedFileSystem extends ArchiveFileSystem {
    private static final String SEPARATOR = "!/";

    public static boolean isValid(String path) {
        return path.contains(SEPARATOR);
    }

    static boolean isNestedFile(@NotNull String path) {
        if (StringUtils.countMatches(path, SEPARATOR) > 0) {
            return ACSArchiveProvider.SUPPORTED_ARCHIVE_EXTENSIONS.stream().anyMatch(path::endsWith);
        }
        return false;
    }

    protected static String getSeparator() {
        return SEPARATOR;
    }

    @NotNull
    @Override
    protected String composeRootPath(@NotNull String localPath) {
        return localPath + SEPARATOR;
    }

    @NotNull
    @Override
    protected String extractLocalPath(@NotNull String rootPath) {
        return StringUtil.trimEnd(rootPath, SEPARATOR);
    }

    @NotNull
    @Override
    protected String extractRootPath(@NotNull String path) {
        final int jarSeparatorIndex = path.indexOf(SEPARATOR);

        assert jarSeparatorIndex >= 0 : "Path passed to ${this.class} must have separator '${separator}': " + path;

        return path.substring(0, jarSeparatorIndex + SEPARATOR.length());
    }

    @Override
    public VirtualFile findFileByPathIfCached(@NotNull String path) {
        return isValid(path) ? VfsImplUtil.findFileByPathIfCached(this, path) : null;
    }

    @Override
    public VirtualFile findFileByPath(@NotNull String path) {
        return isValid(path) ? VfsImplUtil.findFileByPath(this, path) : null;
    }

    @Override
    public void refresh(boolean asynchronous) {
        VfsImplUtil.refresh(this, asynchronous);
    }

    @Override
    public VirtualFile refreshAndFindFileByPath(@NotNull String path) {
        return isValid(path) ? VfsImplUtil.refreshAndFindFileByPath(this, path) : null;
    }

    @NotNull
    @Override
    public String normalize(@NotNull String path) {
        int p = path.indexOf(SEPARATOR);
        return p > 0 ? FileUtil.normalize(path.substring(0, p)) + path.substring(p) : path;
    }
}
