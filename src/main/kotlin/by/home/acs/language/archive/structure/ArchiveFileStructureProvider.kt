package by.home.acs.language.archive.structure

import by.home.acs.language.archive.pk3.Pk3FileNode
import by.home.acs.language.archive.util.FileStructureUtil
import by.home.acs.language.archive.wad.WADArchiveFileType
import by.home.acs.language.archive.wad.WADArchivePsiFileNode
import com.intellij.ide.highlighter.ArchiveFileType
import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.PsiManager

class ArchiveFileStructureProvider : TreeStructureProvider {
    override fun modify(
        parent: AbstractTreeNode<*>, children: MutableCollection<AbstractTreeNode<*>>,
        settings: ViewSettings?
    ): MutableCollection<AbstractTreeNode<*>> {
        return children.asSequence().map { convertArchiveNode(it) }.toCollection(ArrayList())
    }

    override fun getData(selected: MutableCollection<AbstractTreeNode<*>>, dataId: String): Any? {
        return null
    }

    private fun convertArchiveNode(node: AbstractTreeNode<*>): AbstractTreeNode<*> {
        if (node is PsiFileNode) {
            val virtualFile = node.virtualFile
            if (virtualFile != null) {
                try {
                    var psiFile = node.value
                    if (FileStructureUtil.isArchiveFile(virtualFile.path)
                        && FileStructureUtil.isNestedFile(virtualFile.path)
                    ) {
                        val tempNestedFile = FileStructureUtil.copyFileToTemp(virtualFile)
                        val nestedVirtualFile = LocalFileSystem.getInstance().findFileByIoFile(tempNestedFile)
                        if (nestedVirtualFile != null) {
                            psiFile = PsiManager.getInstance(node.project!!).findFile(nestedVirtualFile)
                        }
                    }
                    return when (node.virtualFile?.fileType) {
                        is ArchiveFileType -> Pk3FileNode(node.project, psiFile, node.settings)
                        is WADArchiveFileType -> WADArchivePsiFileNode(node.project, psiFile, node.settings)
                        else -> node
                    }
                } catch (t: Throwable) {
                    // return the original node in case of any error
                    return node
                }
            }
        }
        return node
    }
}

