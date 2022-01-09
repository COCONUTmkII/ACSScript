package by.home.acs.language.archive;

import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.LocalFileProvider;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.newvfs.ArchiveFileSystem;
import com.intellij.openapi.vfs.newvfs.VfsImplUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseArchiveFileSystem extends ArchiveFileSystem {
    protected String fileSystemProtocol;
    protected String fileSystemSeparator;

    //used instead of deprecated getLocalVirtualFileFor method
    @Override
    public @Nullable VirtualFile getLocalByEntry(@NotNull VirtualFile entry) {
        return super.getLocalByEntry(entry);
    }

    //used instead of deprecated findLocalVirtualFileByPath
    @Override
    public @Nullable VirtualFile findFileByPath(@NotNull String path) {
        return VfsImplUtil.findFileByPath(this, path);
    }

    @Override
    protected @Nullable String normalize(@NotNull String path) {
        var separatorIndex = path.indexOf(fileSystemSeparator);
        if (separatorIndex > 0) {
            var root = path.substring(0, separatorIndex);
            return FileUtil.normalize(root) + path.substring(separatorIndex);
        }
        return super.normalize(path);
    }

    @Override
    public @NotNull String getProtocol() {
        return fileSystemProtocol;
    }

    @Override
    protected @NotNull String extractRootPath(@NotNull String normalizedPath) {
        var separatorIndex = normalizedPath.indexOf(fileSystemSeparator);
        assert separatorIndex > 0;
        return normalizedPath.substring(0, separatorIndex + fileSystemSeparator.length());
    }

    @Override
    protected @NotNull String extractLocalPath(@NotNull String rootPath) {
        return StringUtil.trimEnd(rootPath, fileSystemSeparator);
    }

    @Override
    protected @NotNull String composeRootPath(@NotNull String localPath) {
        return localPath + fileSystemSeparator;
    }

    @Override
    public @Nullable VirtualFile findFileByPathIfCached(@NotNull String path) {
        return VfsImplUtil.findFileByPathIfCached(this, path);
    }

    @Override
    public @Nullable VirtualFile refreshAndFindFileByPath(@NotNull String path) {
        return VfsImplUtil.refreshAndFindFileByPath(this, path);
    }

    @Override
    public void refresh(boolean asynchronous) {
        VfsImplUtil.refresh(this, asynchronous);
    }

    @Override
    public @NotNull String extractPresentableUrl(@NotNull String path) {
        return StringUtil.trimEnd(path, fileSystemSeparator);
    }


}
