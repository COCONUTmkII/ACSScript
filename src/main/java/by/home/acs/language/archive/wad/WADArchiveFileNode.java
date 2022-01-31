package by.home.acs.language.archive.wad;

import by.home.acs.language.archive.BasePsiFileNode;
import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.JarFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class WADArchiveFileNode extends BasePsiFileNode {
    public WADArchiveFileNode(Project project, @NotNull PsiFile value, ViewSettings viewSettings) {
        super(project, value, viewSettings);
    }

    @Override
    public Collection<AbstractTreeNode<?>> getChildrenImpl() {
        final Collection<AbstractTreeNode<?>> parentChildren = super.getChildrenImpl();
        return parentChildren != null && !parentChildren.isEmpty() ? parentChildren : getChildrenForVirtualFile(checkVirtualFile(getVirtualFile()));
    }

    @Nullable
    private VirtualFile checkVirtualFile(VirtualFile virtualFile) {
        return virtualFile != null ? JarFileSystem.getInstance().getJarRootForLocalFile(virtualFile) : null;
    }
}
