package by.home.acs.language.archive.wad;


import by.home.acs.language.archive.BaseArchiveFileSystem;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeRegistry;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.impl.ArchiveHandler;
import com.intellij.openapi.vfs.newvfs.VfsImplUtil;
import org.jetbrains.annotations.NotNull;

public abstract class WADArchiveFileSystem extends BaseArchiveFileSystem {

    //here was companion object that was working with SevenZip class. But I will skip this and try to see what will be

    @Override
    protected @NotNull ArchiveHandler getHandler(@NotNull VirtualFile entryFile) {
        return VfsImplUtil.getHandler(this, entryFile, WADArchiveHandler::new);
    }

    public ArchiveHandler getHandlerForFile(VirtualFile virtualFile) {
        return getHandler(virtualFile);
    }

    @Override
    protected boolean isCorrectFileType(@NotNull VirtualFile local) {
        return FileTypeRegistry.getInstance().getFileTypeByFileName(local.getName()) instanceof WADFile;
    }
}
