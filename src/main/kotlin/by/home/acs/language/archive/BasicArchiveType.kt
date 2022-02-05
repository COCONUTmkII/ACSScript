package by.home.acs.language.archive

import com.intellij.openapi.vfs.impl.ArchiveHandler

open class BasicArchiveType(path: String) : ArchiveHandler(path) {

    override fun createEntriesMap(): MutableMap<String, EntryInfo> {
        TODO("Not yet implemented")
    }

    override fun contentsToByteArray(relativePath: String): ByteArray {
        TODO("Not yet implemented")
    }

}