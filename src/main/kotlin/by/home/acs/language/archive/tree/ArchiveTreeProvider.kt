package by.home.acs.language.archive.tree

import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.projectView.impl.nodes.PsiFileNode
import com.intellij.ide.util.treeView.AbstractTreeNode

class ArchiveTreeProvider : TreeStructureProvider {
    override fun modify(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<AbstractTreeNode<*>>,
        settings: ViewSettings?
    ): MutableCollection<AbstractTreeNode<*>> {
        return children.asSequence().map { convertArchiveNode(it) }.toCollection(ArrayList())

    }

    private fun convertArchiveNode(node: AbstractTreeNode<*>): AbstractTreeNode<*> {
       return node
    }


}