package by.home.acs.language.archive.wad

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class WADFileType : FileType {
    override fun getName(): String {
        return "WAD"
    }

    override fun getDescription(): String {
        return "WAD archive type"
    }

    override fun getDefaultExtension(): String {
        return "wad"
    }

    override fun getIcon(): Icon {
        return AllIcons.FileTypes.Archive
    }

    override fun isBinary(): Boolean {
        return true
    }

    override fun isReadOnly(): Boolean {
        return false
    }

    override fun getCharset(file: VirtualFile, content: ByteArray?): String? {
        return null
    }
}