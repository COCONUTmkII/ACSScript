package by.home.acs.language.archive.pk3

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.vfs.VirtualFile
import javax.swing.Icon

class PK3FileType : FileType {
    override fun getName(): String {
        return "PK3"
    }

    override fun getDescription(): String {
        return "PK3 archive type"
    }

    override fun getDefaultExtension(): String {
        return "pk3"
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