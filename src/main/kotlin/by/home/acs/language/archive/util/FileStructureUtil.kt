package by.home.acs.language.archive.util

import by.home.acs.language.archive.wad.WADArchiveFileSystem
import by.home.acs.language.archive.wad.WADArchiveHandler
import com.google.common.hash.Hashing
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.BasePsiNode
import com.intellij.ide.projectView.impl.nodes.PsiDirectoryNode
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.application.ApplicationInfo
import com.intellij.openapi.application.PathManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleFileIndex
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileSystemItem
import com.intellij.util.containers.ContainerUtil
import com.intellij.util.io.FileAccessorCache
import com.intellij.util.io.URLUtil
import net.sf.sevenzipjbinding.ExtractOperationResult
import org.apache.commons.lang.StringUtils
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files

fun processPsiDirectoryChildren(
    children: Array<PsiElement>,
    container: MutableList<AbstractTreeNode<*>>, moduleFileIndex: ModuleFileIndex?,
    viewSettings: ViewSettings
) {
    for (child in children) {
        if (child !is PsiFileSystemItem) {
            continue
        }
        val vFile = child.virtualFile ?: continue
        if (moduleFileIndex != null && !moduleFileIndex.isInContent(vFile)) {
            continue
        }
        if (child is PsiFile) {
            container.add(PsiFileNode(child.getProject(), child, viewSettings))
        } else if (child is PsiDirectory) {
            container.add(PsiGenericDirectoryNode(child.getProject(), child, viewSettings))
        }
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun BasePsiNode<*>.processChildren(
    dir: PsiDirectory
): MutableCollection<AbstractTreeNode<*>> {
    val children = ArrayList<AbstractTreeNode<*>>()
    val project = dir.project
    val fileIndex = ProjectRootManager.getInstance(project).fileIndex
    val module = fileIndex.getModuleForFile(dir.virtualFile)
    val moduleFileIndex = if (module == null) null else ModuleRootManager.getInstance(
        module
    ).fileIndex
    processPsiDirectoryChildren(dir.children, children, moduleFileIndex, settings)
    return children
}

inline fun <T, R> FileAccessorCache.Handle<T>.getAndUse(block: (T) -> R): R {
    var released = false
    try {
        val value = this.get()
        return block(value)
    } catch (e: Exception) {
        released = true
        try {
            this.release()
        } catch (releaseException: Exception) {
        }
        throw e
    } finally {
        if (!released) {
            this.release()
        }
    }
}

class PsiGenericDirectoryNode(
    project: Project?, value: PsiDirectory,
    viewSettings: ViewSettings?
) : PsiDirectoryNode(project, value, viewSettings) {
    override fun getChildrenImpl(): MutableCollection<AbstractTreeNode<*>> {
        val project = project
        if (project != null) {
            val psiDirectory = value
            if (psiDirectory != null) {
                return processChildren(psiDirectory)
            }
        }
        return ContainerUtil.emptyList<AbstractTreeNode<*>>()
    }
}

object AppInfoUtil {
    val applicationInfo = ApplicationInfo.getInstance()
    val baselineVersion = applicationInfo.build.baselineVersion
}


object FileStructureUtil {
    const val FS_SEPARATOR = URLUtil.JAR_SEPARATOR
    private const val NESTED_FILES_ROOT = "archives"
    fun isArchiveFile(path: String): Boolean {
        val extensionIndex = path.lastIndexOf('.') + 1
        if (extensionIndex == 0 || extensionIndex >= path.length) {
            return false
        }
        val extension = path.substring(extensionIndex).toLowerCase()
        return SUPPORTED_ARCHIVES.contains(extension)
    }

    fun isNestedFile(path: String): Boolean {
        return StringUtils.countMatches(path, FS_SEPARATOR) > 0
    }

    fun getPluginTempFolder(): File {
        val tmpDir = PathManager.getTempPath()
        return File(tmpDir, PluginUtils.PLUGIN_NAME)
    }

    fun copyFileToTemp(file: VirtualFile): File {
        val nestedFilesRoot = File(getPluginTempFolder(), NESTED_FILES_ROOT)
        if (!nestedFilesRoot.exists()) {
            nestedFilesRoot.mkdirs()
        }
        val id = Hashing.adler32()
            .newHasher()
            .putString(file.name, Charset.defaultCharset())
            .putLong(file.timeStamp)
            .putLong(file.length)
            .hash()
            .toString()
        val outFolder = File(nestedFilesRoot, id)
        if (!outFolder.exists()) {
            outFolder.mkdirs()
        }
        val outFile = File(outFolder, file.name)
        if (!outFile.exists()) {
            if (!tryToDirectCopyFile(file, outFile)) {
                val stream = file.inputStream
                file.inputStream.use {
                    Files.copy(stream, outFile.toPath())
                }
            }
        }
        return outFile
    }

    /**
     * Trying to speed up file ops
     */
    private fun tryToDirectCopyFile(file: VirtualFile, outFile: File): Boolean {
        return try {
            tryToGetSevenZipStream(file)?.let { stream ->
                stream.holder.useStream {
                    outFile.outputStream().buffered().use { output ->
                        stream.directRead { bytes: ByteArray ->
                            output.write(bytes)
                            bytes.size
                        } == ExtractOperationResult.OK
                    }
                }
            } ?: false
        } catch (e: Throwable) {
            false
        }
    }

    private fun tryToGetSevenZipStream(file: VirtualFile): WADArchiveHandler.WADInputStream? {
        return (file.fileSystem as? WADArchiveFileSystem)?.let { fs ->
            (fs.getHandlerForFile(file) as? WADArchiveHandler)?.let { handler ->
                handler.getInputStreamForFile(file)
            }
        }
    }

    fun convertPathToIdea(path: String?): String {
        return path?.replace('\\', '/') ?: ""
    }
}

object PluginUtils {
    const val PLUGIN_NAME = "archive-browser-idea"
}

val SUPPORTED_ARCHIVES = listOf("wad", "pk3")
