package by.home.acs.language.archive;

import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.projectView.impl.nodes.PsiFileNode;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.util.containers.ContainerUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class BasePsiFileNode extends PsiFileNode {
    public BasePsiFileNode(Project project, @NotNull PsiFile value, ViewSettings viewSettings) {
        super(project, value, viewSettings);
    }

    public List<AbstractTreeNode<?>> getChildrenForVirtualFile(VirtualFile rootFile) {
        if (myProject != null && rootFile != null) {
            var psiDirectory = PsiManager.getInstance(myProject).findDirectory(rootFile);
            if (psiDirectory != null) {
                //TODO implement processChildren method in util class
            }
        }
        return ContainerUtil.emptyList();
    }
}
