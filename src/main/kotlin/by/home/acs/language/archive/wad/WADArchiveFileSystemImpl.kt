package by.home.acs.language.archive.wad

import by.home.acs.language.archive.util.FileStructureUtil
import com.intellij.openapi.vfs.VirtualFileManager

class WADArchiveFileSystemImpl :
    WADArchiveFileSystem(WADArchiveFileType, SZ_PROTOCOL, FileStructureUtil.FS_SEPARATOR) {
    companion object {
        private const val SZ_PROTOCOL = "wad"
        val instance: WADArchiveFileSystem
            get() = VirtualFileManager.getInstance().getFileSystem(SZ_PROTOCOL) as WADArchiveFileSystem
    }
}