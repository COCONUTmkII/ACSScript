package by.home.acs.language;

import by.home.acs.language.psi.ACSScriptFile;
import by.home.acs.language.psi.ACSScriptScriptDefinition;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class ACSUtil {
    // I have no IDEA what am I writing...
    public static List<ACSScriptScriptDefinition> findScript(Project project, String number) {
        List<ACSScriptScriptDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsFile != null) {
                ACSScriptScriptDefinition[] scriptWord = PsiTreeUtil.getChildrenOfType(acsFile, ACSScriptScriptDefinition.class);
                if (scriptWord != null) {
                    for (ACSScriptScriptDefinition acs : scriptWord) {
                        if (number.equals(acs.getText())) {
                            result.add(acs);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<ACSScriptScriptDefinition> findScript(Project project) {
        List<ACSScriptScriptDefinition> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(ACSScriptType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            ACSScriptFile acsFile = (ACSScriptFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (acsFile != null) {
                ACSScriptScriptDefinition[] scriptWord = PsiTreeUtil.getChildrenOfType(acsFile, ACSScriptScriptDefinition.class);
                if (scriptWord != null) {
                    Collections.addAll(result, scriptWord);
                }
            }
        }
        return result;
    }
}