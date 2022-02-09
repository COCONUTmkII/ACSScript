package by.home.acs.language.archive.wad

import by.home.acs.language.archive.BaseArchiveFileSystem
import by.home.acs.language.archive.util.FileStructureUtil
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.FileTypeRegistry
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.impl.ArchiveHandler
import com.intellij.openapi.vfs.newvfs.VfsImplUtil
import net.sf.sevenzipjbinding.SevenZip

abstract class WADArchiveFileSystem(
    fileType: FileType,
    fsProtocol: String,
    fsSeparator: String
) : BaseArchiveFileSystem(fsProtocol, fsSeparator) {
    companion object {
        init {
            if (!SevenZip.isInitializedSuccessfully()) {
                val tmpDir = FileStructureUtil.getPluginTempFolder()
                if (!tmpDir.exists()) {
                    tmpDir.mkdirs()
                }
                SevenZip.initSevenZipFromPlatformJAR(tmpDir)
            }
        }
    }

    override fun getHandler(entryFile: VirtualFile): ArchiveHandler {
        return VfsImplUtil.getHandler(this, entryFile) { localPath ->
            WADArchiveHandler(localPath)
        }
    }

    fun getHandlerForFile(file: VirtualFile): ArchiveHandler? {
        return getHandler(file)
    }

    override fun isCorrectFileType(local: VirtualFile): Boolean {
        return FileTypeRegistry.getInstance().getFileTypeByFileName(local.name) is WADArchiveFileType
    }
}