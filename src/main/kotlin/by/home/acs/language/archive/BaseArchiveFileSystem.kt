package by.home.acs.language.archive

import by.home.acs.language.archive.util.FileStructureUtil
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.util.text.StringUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.newvfs.ArchiveFileSystem
import com.intellij.openapi.vfs.newvfs.VfsImplUtil

abstract class BaseArchiveFileSystem(
    private val fsProtocol: String,
    private val fsSeparator: String = FileStructureUtil.FS_SEPARATOR
) : ArchiveFileSystem() {
    private fun getVirtualFileForArchive(entryFile: VirtualFile?): VirtualFile? {
        return if (entryFile == null) null else getLocalByEntry(entryFile)
    }

    fun getArchiveRootForLocalFile(file: VirtualFile): VirtualFile? {
        return getRootByLocal(file)
    }

    override fun getProtocol() = fsProtocol

//    override fun isCorrectFileType(local: VirtualFile): Boolean {
//        return FileTypeRegistry.getInstance().getFileTypeByFileName(local.name) is fileType
//    }

    override fun extractPresentableUrl(path: String) = super.extractPresentableUrl(
        StringUtil.trimEnd(path, fsSeparator)
    )

    override fun normalize(path: String): String? {
        val separatorIndex = path.indexOf(fsSeparator)
        if (separatorIndex > 0) {
            val root = path.substring(0, separatorIndex)
            return FileUtil.normalize(root) + path.substring(separatorIndex)
        }
        return super.normalize(path)
    }

    override fun extractRootPath(path: String): String {
        val separatorIndex = path.indexOf(fsSeparator)
        assert(
            separatorIndex >= 0
        ) { "Path passed to ${this.javaClass.simpleName} must have separator '!/': $path" }
        return path.substring(0, separatorIndex + fsSeparator.length)
    }

    override fun extractLocalPath(rootPath: String): String {
        return StringUtil.trimEnd(rootPath, fsSeparator)
    }

    override fun composeRootPath(localPath: String): String {
        return localPath + fsSeparator
    }

    override fun findFileByPath(path: String): VirtualFile? {
        return VfsImplUtil.findFileByPath(this, path)
    }

    override fun findFileByPathIfCached(path: String): VirtualFile? {
        return VfsImplUtil.findFileByPathIfCached(this, path)
    }

    override fun refreshAndFindFileByPath(path: String): VirtualFile? {
        return VfsImplUtil.refreshAndFindFileByPath(this, path)
    }

    override fun refresh(asynchronous: Boolean) {
        VfsImplUtil.refresh(this, asynchronous)
    }
}
