package by.home.acs.language.archive;

import com.intellij.ide.projectView.TreeStructureProvider;
import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.projectView.impl.nodes.PsiFileNode;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.stream.Collectors;

public class ArchiveStructureProvider implements TreeStructureProvider {

    @Override
    public @NotNull
    Collection<AbstractTreeNode<?>> modify(@NotNull AbstractTreeNode<?> parent, @NotNull Collection<AbstractTreeNode<?>> children, ViewSettings settings) {
        return children.stream().map(this::convert).collect(Collectors.toList());
    }

    private AbstractTreeNode<?> convert(AbstractTreeNode<?> abstractTreeNode) {
        if (abstractTreeNode instanceof PsiFileNode) {
            var virtualFile = ((PsiFileNode) abstractTreeNode).getVirtualFile();
            if (virtualFile != null) {
                try {
                    var psiFile = abstractTreeNode.getValue();
                    if (FileStructureUtils.isArchiveFile(virtualFile.getPath()) && FileStructureUtils.isNestedFile(virtualFile.getPath())) {
                        var tempNestedFile = FileStructureUtils.copyFileToTemp(virtualFile);
                    }
                } catch (Exception e) {
                    return abstractTreeNode;
                }
            }
        }
        return abstractTreeNode;
    }

    //FileTypeFactory
}
