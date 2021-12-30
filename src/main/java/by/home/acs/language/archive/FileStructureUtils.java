package by.home.acs.language.archive;

import by.home.acs.language.archive.type.SupportedFileType;
import com.google.common.hash.Hashing;
import com.intellij.ide.projectView.ViewSettings;
import com.intellij.ide.projectView.impl.nodes.PsiDirectoryNode;
import com.intellij.ide.projectView.impl.nodes.PsiFileNode;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.roots.ModuleFileIndex;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileSystemItem;
import com.intellij.util.io.URLUtil;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

public class FileStructureUtils {
    public static final String FILE_SEPARATOR = URLUtil.JAR_SEPARATOR;
    private static final String NESTED_FILE_ROOT = "archives";

    public static void processPsiDirectoryChildren(Collection<PsiElement> children,
                                                   List<AbstractTreeNode<?>> container,
                                                   ModuleFileIndex moduleFileIndex,
                                                   ViewSettings viewSettings) {
        for (PsiElement element : children) {
            if (!(element instanceof PsiFileSystemItem)) {
                continue;
            }
            var virtualFile = ((PsiFileSystemItem) element).getVirtualFile();
            if (virtualFile == null) {
                continue;
            }
            if (moduleFileIndex != null && !moduleFileIndex.isInContent(virtualFile)) {
                continue;
            }
            if (element instanceof PsiFile) {
                container.add(new PsiFileNode(element.getProject(), (PsiFile) element, viewSettings));
            } else if (element instanceof PsiDirectory) {
                //TODO other class declared here. See PsiGenericDirectoryNode
                container.add(new PsiDirectoryNode(element.getProject(), (PsiDirectory) element, viewSettings));
            }
        }

    }

    public static boolean isArchiveFile(String path) {
        var extensionIndex = path.lastIndexOf('.') + 1;
        if (extensionIndex == 0 || extensionIndex >= path.length()) {
            return false;
        }
        var extension = path.substring(extensionIndex).toLowerCase();
        return SupportedFileType.supportedArchives.contains(extension);
    }

    public static boolean isNestedFile(String path) {
        return StringUtils.countMatches(path, FILE_SEPARATOR) > 0;
    }

    public static File copyFileToTemp(VirtualFile virtualFile) {
        var nestedFilesRoot = new File(getPluginTempFolder(), NESTED_FILE_ROOT);
        if (!nestedFilesRoot.exists()) {
            nestedFilesRoot.mkdirs();
        }
        var id = Hashing.sha256()
                .newHasher()
                .putString(virtualFile.getName(), Charset.defaultCharset())
                .putLong(virtualFile.getTimeStamp())
                .putLong(virtualFile.getLength())
                .hash()
                .toString();
        var outFile = new File(id, virtualFile.getName());
        if (!outFile.exists()) {
            CopyFile(virtualFile, outFile);
        }
        return outFile;
    }

    private static void CopyFile(VirtualFile virtualFile, File outFile) {
        //TODO Files.copy might not work correctly because of kotlin inputstream.use method
        if (!tryToDirectoryCopyFile(virtualFile, outFile)) {
            try (final var stream = virtualFile.getInputStream()) {
                Files.copy(stream, Path.of(outFile.getPath()));
            } catch (IOException io) {
                //ignored
            }
        }
    }

    //TODO implement this
    private static boolean tryToDirectoryCopyFile(VirtualFile virtualFile, File outFile) {
        return false;
    }

    //TODO implement this
    private static boolean tryToGetWADStream(VirtualFile virtualFile) {
        return false;
    }

    public static File getPluginTempFolder() {
        var tmpDir = PathManager.getTempPath();
        return new File(tmpDir, "Action Code Script");
    }
}
