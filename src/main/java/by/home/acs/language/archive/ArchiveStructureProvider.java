package by.home.acs.language.archive;

import by.home.acs.language.archive.wad.WADArchiveFileNode;
import com.intellij.ide.highlighter.ArchiveFileType;
import com.intellij.ide.projectView.TreeStructureProvider;
import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.projectView.impl.nodes.PsiFileNode;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

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
                    var psiFile = (PsiFile) abstractTreeNode.getValue();
                    if (FileStructureUtils.isArchiveFile(virtualFile.getPath()) && FileStructureUtils.isNestedFile(virtualFile.getPath())) {
                        var tempNestedFile = FileStructureUtils.copyFileToTemp(virtualFile);
                        var nestedVirtualFile = LocalFileSystem.getInstance().findFileByIoFile(tempNestedFile);
                        if (nestedVirtualFile != null) {
                            psiFile = PsiManager.getInstance(requireNonNull(abstractTreeNode.getProject())).findFile(nestedVirtualFile);
                        }
                    }
                    var fileType = requireNonNull(virtualFile.getFileType());
                    //TODO check does psiFile is not null
                    return new WADArchiveFileNode(abstractTreeNode.getProject(), psiFile, ((PsiFileNode) abstractTreeNode).getSettings());
                } catch (Exception e) {
                    return abstractTreeNode;
                }
            }
        }
        return abstractTreeNode;
    }

    //FileTypeFactory
}
