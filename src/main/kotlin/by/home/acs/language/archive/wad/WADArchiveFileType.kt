package by.home.acs.language.archive.wad

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

object WADArchiveFileType : FileType {
    override fun getDefaultExtension(): String = ""

    override fun getIcon(): Icon = AllIcons.FileTypes.Archive

    override fun getCharset(file: VirtualFile, content: ByteArray): String? = null

    override fun getName() = "WAD"

    override fun getDescription() = "WAD archive type"

    override fun isBinary() = true

    override fun isReadOnly() = false
}