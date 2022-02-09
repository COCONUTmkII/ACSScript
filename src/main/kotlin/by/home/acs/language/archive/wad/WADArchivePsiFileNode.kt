package by.home.acs.language.archive.wad

import by.home.acs.language.archive.BasePsiFileNode
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.util.treeView.AbstractTreeNode
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile

class WADArchivePsiFileNode(
    project: Project?, value: PsiFile,
    viewSettings: ViewSettings?
) : BasePsiFileNode(project, value, viewSettings) {
    override fun getChildrenImpl(): MutableCollection<AbstractTreeNode<*>> {
        val root = virtualFile?.let { WADArchiveFileSystemImpl.instance.getArchiveRootForLocalFile(it) }
        return getChildrenForVirtualFile(root)
    }
}